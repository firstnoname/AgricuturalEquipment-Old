package se.is.agriculturalequipment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import se.is.agriculturalequipment.MyOpenHelper;
import se.is.agriculturalequipment.model.PartList;

/**
 * Created by iFirst-PC on 31/10/2560.
 */

public class PartDAO {
    private SQLiteDatabase database;
    private MyOpenHelper dbHelper;

    public PartDAO(Context context) {
        dbHelper = new MyOpenHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public ArrayList<PartList> getAllPart(String tblName) {
        String tableName = tblName;
        ArrayList<PartList> partLists = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + tableName + ";", null);
        cursor.moveToFirst();

        PartList mPartList;

        while (!cursor.isAfterLast()) {
            //partLists.add(cursor.getString(1));
            mPartList = new PartList();
            mPartList.setId(cursor.getInt(0));
            mPartList.setPartname(cursor.getString(1));
            mPartList.setPartPrice(cursor.getString(2));
            partLists.add(mPartList);
            cursor.moveToNext();
        }
        cursor.close();

        return partLists;
    }

    public void add(PartList partList, String tableName) {

        String lowCase = null;
        if (tableName == "G200") {
            lowCase = tableName.toLowerCase();
        }
        PartList newPartList = new PartList();
        newPartList = partList;

        ContentValues values = new ContentValues();
        values.put("partName" + tableName, newPartList.getPartname());
        values.put("partPrice" + tableName, newPartList.getPartPrice());
        this.database.insert(lowCase + "TABLE", null, values);
        Log.d("Part list demo:: ", "Inserted");

    }

    public void update(PartList partList, String tableName) {
        String lowCase = tableName.toLowerCase();

        PartList updatePartList = partList;

        ContentValues values = new ContentValues();

        values.put("_id", updatePartList.getId());
        values.put("partName" + tableName, updatePartList.getPartname());
        values.put("partPrice" + tableName, updatePartList.getPartPrice());

        String where = "_id=" + updatePartList.getId();

        this.database.update(lowCase + "TABLE", values, where, null);
        //Log.d("Part List Demo :: ", "Update OK!");
    }


}
