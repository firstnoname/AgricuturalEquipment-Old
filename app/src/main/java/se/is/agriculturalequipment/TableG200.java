package se.is.agriculturalequipment;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by iFirst on 12/19/16.
 */

public class TableG200 {

    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase readSqLiteDatabase, writeSqLiteDatabase;

    public static final String TABLE_G200 = "g200TABLE";
    public static final String COLUMN_G200_ID = "_id";
    public static final String COLUMN_PART_NAME = "partName";
    public static final String COLUMN_PART_PRICE = "partPrice";

    public TableG200(Context context) {
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();
    } //End construct.

    public long addNewPart(String strName,String strPrice){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_PART_NAME, strName);
        objContentValues.put(COLUMN_PART_PRICE, strPrice);
        return writeSqLiteDatabase.insert(TABLE_G200,null,objContentValues);
    }
}
