package se.is.agriculturalequipment.Admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import se.is.agriculturalequipment.DAO.UserDAO;
import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.model.User;

public class AddUser extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spnRole;
    Button btnAddUser;
    EditText edtNameUser,edtUsername,edtPassword;
    String roleSel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        spnRole = (Spinner) findViewById(R.id.spnRole);
        btnAddUser = (Button) findViewById(R.id.btnAddUser);
        edtNameUser = (EditText) findViewById(R.id.edtNameUser);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        ArrayAdapter<CharSequence> adapterRole = ArrayAdapter.createFromResource(this,
                R.array.user_role, android.R.layout.simple_spinner_item);
        adapterRole.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spnRole.setAdapter(adapterRole);
        spnRole.setOnItemSelectedListener(this);

        //Button add user.
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User mUser = new User();
                mUser.setNameUser(String.valueOf(edtNameUser.getText()));
                mUser.setUsername(String.valueOf(edtUsername.getText()));
                mUser.setPassword(String.valueOf(edtPassword.getText()));
                mUser.setUserRole(roleSel);

                UserDAO addUser = new UserDAO(getApplicationContext());
                addUser.open();
                addUser.addUser(mUser);
                addUser.close();

                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        roleSel = parent.getItemAtPosition(position).toString();
        //Toast.makeText(this, "Selected : " + roleSel, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "Selected id : "+ position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
