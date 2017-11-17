package se.is.agriculturalequipment.Admin;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import se.is.agriculturalequipment.DAO.UserDAO;
import se.is.agriculturalequipment.DAO.UserDAOServer;
import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.adapter.AdapterUserList;
import se.is.agriculturalequipment.model.User;

public class OwnerPage extends AppCompatActivity {
    String strWhere = "Owner";
    ListView listview_owner;
    FloatingActionButton btnAddOwner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_page);

        listview_owner = (ListView) findViewById(R.id.listview_owner);
        btnAddOwner = (FloatingActionButton) findViewById(R.id.btnAddOwner);


        btnAddOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddUser = new Intent(getApplicationContext(), AddUser.class);
                startActivity(intentAddUser);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        /*UserDAO userDAO = new UserDAO(getApplicationContext());
        userDAO.open();
        ArrayList<User> myListUser = userDAO.getAllUser(strWhere);
        final AdapterUserList adapter = new AdapterUserList(this,myListUser);
        listview_owner.setAdapter(adapter);
        userDAO.close();*/

        UserDAOServer userDAOServer = new UserDAOServer(getApplicationContext());
        ArrayList<User> myListUser = userDAOServer.getAllUser(strWhere);
        Log.d("myListUser : ", String.valueOf(myListUser.size()));
        final AdapterUserList adapter = new AdapterUserList(this, myListUser);
        listview_owner.setAdapter(adapter);

        listview_owner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentUpdate = new Intent(getApplicationContext(), UpdateUser.class);
                intentUpdate.putExtra("selectedUser", adapter.getItem(position));
                intentUpdate.putExtra("where", strWhere);
                startActivity(intentUpdate);
            }
        });
    }
}
