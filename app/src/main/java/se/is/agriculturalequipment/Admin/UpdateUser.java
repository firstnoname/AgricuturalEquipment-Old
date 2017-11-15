package se.is.agriculturalequipment.Admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import se.is.agriculturalequipment.DAO.UserDAO;
import se.is.agriculturalequipment.DAO.UserDAOServer;
import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.model.User;

public class UpdateUser extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText edtNameUser, edtUsername,edtPassword;
    Button btnUpdate, btnDelete;
    Spinner spnUserRole;

    int idRole;
    String roleSel;
    String where;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        final User edtUser = (User) getIntent().getSerializableExtra("selectedUser");
        where = getIntent().getStringExtra("where");
        edtNameUser = (EditText) findViewById(R.id.edtName);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPass);
        spnUserRole = (Spinner) findViewById(R.id.spnRole);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        edtNameUser.setText(edtUser.getNameUser());
        edtUsername.setText(edtUser.getUsername());
        edtPassword.setText(edtUser.getPassword());

        //Check position of spinner.
        switch (edtUser.getUserRole()) {
            case "Owner":
                idRole = 0;
                break;
            default:
                idRole = 1;
        }

        ArrayAdapter<CharSequence> adapterRole = ArrayAdapter.createFromResource(this,
                R.array.user_role, android.R.layout.simple_dropdown_item_1line);
        spnUserRole.setAdapter(adapterRole);
        spnUserRole.setSelection(idRole);
        spnUserRole.setOnItemSelectedListener(this);


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User updateUser = new User();
                updateUser.setId(edtUser.getId());
                updateUser.setNameUser(String.valueOf(edtNameUser.getText()));
                updateUser.setUsername(String.valueOf(edtUsername.getText()));
                updateUser.setPassword(String.valueOf(edtPassword.getText()));
                updateUser.setUserRole(roleSel);

                /*UserDAO userDAO = new UserDAO(getApplicationContext());
                userDAO.open();
                userDAO.updateUser(updateUser);
                userDAO.close();*/

                //Update to server.
                UserDAOServer updateUserServ = new UserDAOServer(getApplicationContext());
                updateUserServ.updateUser(updateUser);

                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDAO userDAODel = new UserDAO(getApplicationContext());
                userDAODel.open();
                userDAODel.deleteUser(edtUser);
                userDAODel.close();

                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        roleSel = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
