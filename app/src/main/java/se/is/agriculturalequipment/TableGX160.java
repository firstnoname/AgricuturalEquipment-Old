package se.is.agriculturalequipment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by iFirst on 8/1/2560.
 */

public class TableGX160 {
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase readSqLiteDatabase, writeSqLiteDatabase;

    public static final String TABLE_GX160 = "gx160TABLE";
    public static final String COLUMN_GX160_ID = "_id";
    public static final String COLUMN_PART_NAME = "partNameGX160";
    public static final String COLUMN_PART_PRICE = "partPriceGX160";

    public TableGX160(Context context) {
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();
    }//End of constructor.

    public long addNewPart(String strName, String strPrice){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_PART_NAME, strName);
        objContentValues.put(COLUMN_PART_PRICE, strPrice);

        return writeSqLiteDatabase.insert(TABLE_GX160, null, objContentValues);
    }

    public String[] readPartName(){
        String[] strPartName = null;
        Cursor objCursor = readSqLiteDatabase.query(TABLE_GX160,
                new String[]{COLUMN_GX160_ID, COLUMN_PART_NAME},
                null, null, null, null, null, null);
        if (objCursor != null) {
            objCursor.moveToFirst();
            strPartName = new String[objCursor.getCount()];
            for (int i = 0; i < objCursor.getCount(); i++) {
                strPartName[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PART_NAME));
                objCursor.moveToNext();
            }//End for loop.
        }//End if.

        objCursor.close();
        return strPartName;
    }

    public String[] readPartPrice(){
        String[] strPartPrice = null;
        Cursor objCursor = readSqLiteDatabase.query(TABLE_GX160,
                new String[]{COLUMN_GX160_ID, COLUMN_PART_PRICE},
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

