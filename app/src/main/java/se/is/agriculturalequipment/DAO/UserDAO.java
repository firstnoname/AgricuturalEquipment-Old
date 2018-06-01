package se.is.agriculturalequipment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import java.util.ArrayList;

import se.is.agriculturalequipment.MyOpenHelper;
import se.is.agriculturalequipment.model.User;

/**
 * Created by BlackClover on 11/2/2017.
 */

public class UserDAO {
    private SQLiteDatabase database;
    private MyOpenHelper dbHelper;

    public UserDAO(Context context) {
        dbHelper = new MyOpenHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        database.close();
    }

    public ArrayList<User> getAllUser(String where) {

        ArrayList<User> userList = new ArrayList<>();
        /*Cursor cursor = database.rawQuery("SELECT * FROM userTable WHERE userRole=" + where + ";",
                null);*/
//        String sqlSelect = "SELECT * FROM userTable WHERE userRole = " + where + ";";
        String sqlSelect = "SELECT * FROM userTable WHERE userRole = '" + where + "'";
        Cursor cursor = database.rawQuery(sqlSelect, null);
        cursor.moveToFirst();

        User mUser;

        while (!cursor.isAfterLast()) {
            mUser = new User();
            mUser.setId(cursor.getInt(0));
            mUser.setNameUser(cursor.getString(1));
            mUser.setUsername(cursor.getString(2));
            mUser.setPassword(cursor.getString(3));
            mUser.setUserRole(cursor.getString(4));
            userList.add(mUser);
            cursor.moveToNext();
        }

        return userList;
    }

    public void addUser(User user) {
        User newUser = user;

        ContentValues values = new ContentValues();
        values.put("nameUser", newUser.getNameUser());
        values.put("username", newUser.getUsername());
        values.put("password", newUser.getPassword());
        values.put("userRole", newUser.getUserRole());
        this.database.insert("userTable", null, values);
        Log.d("User :: ", "Insert user complete.");
    }

    public void updateUser(User user) {
        User updateUser = user;
        ContentValues values = new ContentValues();
        values.put("nameUser", updateUser.getNameUser());
        values.put("username", updateUser.getUsername());
        values.put("password", updateUser.getPassword());
        values.put("userRole", updateUser.getUserRole());

        String where = "id=" + updateUser.getId();

        this.database.update("userTable", values, where, null);

    }

    public void deleteUser(User user) {
        User delUser = user;
        String sqlText = "DELETE FROM userTable WHERE id=" + delUser.getId();
        this.database.execSQL(sqlText);
    }


}
