package se.is.agriculturalequipment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by iFirst on 12/19/16.
 */

public class TableG200 {

    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase readSqLiteDatabase, writeSqLiteDatabase;

    public static final String TABLE_G200 = "g200TABLE";
    public static final String COLUMN_G200_ID = "_id";
    public static final String COLUMN_PART_NAME = "partNameG200";
    public static final String COLUMN_PART_PRICE = "partPriceG200";

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

    public String[] readPartName(){
        String[] strPartName = null;
        Cursor objCursor = readSqLiteDatabase.query(TABLE_G200,
                new String[]{COLUMN_G200_ID, COLUMN_PART_NAME},
                null, null, null, null, null, null);
        if(objCursor != null){
            objCursor.moveToFirst();
            strPartName = new String[objCursor.getCount()];
            for (int i = 0; i < objCursor.getCount(); i++){
                strPartName[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PART_NAME));
                objCursor.moveToNext();
            }//end for.
        }//end if.
        objCursor.close();
        return strPartName;
    }

    public String[] readPartPrice(){
        String[] strPartPrice = null;
        Cursor objCursor = readSqLiteDatabase.query(TABLE_G200,
                new String[]{COLUMN_G200_ID, COLUMN_PART_PRICE},
                null, null, null, null, null, null);
        if(objCursor != null){
            objCursor.moveToFirst();
            strPartPrice = new String[objCursor.getCount()];
            for(int i=0; i<objCursor.getCount();i++) {
                strPartPrice[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PART_PRICE));
                objCursor.moveToNext();
            }//end for.
        }//end if.

        objCursor.close();
        return strPartPrice;
    }
}
