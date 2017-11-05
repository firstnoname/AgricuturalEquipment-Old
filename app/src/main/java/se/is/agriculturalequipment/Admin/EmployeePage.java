package se.is.agriculturalequipment.Admin;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import se.is.agriculturalequipment.DAO.UserDAO;
import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.adapter.AdapterUserList;
import se.is.agriculturalequipment.model.User;

public class EmployeePage extends AppCompatActivity {

    String strWhere = "Empl oyee";
    ListView listview_emp;
    FloatingActionButton btnAddEmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_page);

        //Bind widget.
        listview_emp = (ListView) findViewById(R.id.listview_employee);
        btnAddEmp = (FloatingActionButton) findViewById(R.id.btnAddEmployee);

        btnAddEmp.setOnClickListener(new View.OnClickListener() {
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

        UserDAO userDAO = new UserDAO(getApplicationContext());
        userDAO.open();
        ArrayList<User> myListUser = userDAO.getAllUser(strWhere);
        final AdapterUserList adapter = new AdapterUserList(this, myListUser);
        listview_emp.setAdapter(adapter);
        userDAO.close();

        listview_emp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentUpdate = new Intent(getApplicationContext(), UpdateUser.class);
                intentUpdate.putExtra("selectedUser", adapter.getItem(position));
                startActivity(intentUpdate);
            }
        });
    }
}
