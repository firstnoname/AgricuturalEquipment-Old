package se.is.agriculturalequipment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by iFirst on 17/1/2560.
 */

public class TableTM31 {
    public static final String TABLE_TM31 = "tm31TABLE";
    public static final String COLUMN_TM31_ID = "_id";
    public static final String COLUMN_PART_NAME_TM31 = "partNameTM31";
    public static final String COLUMN_PART_PRICE_TM31 = "partPriceTM31";
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase readSqLiteDatabase, writeSqLiteDatabase;

    public TableTM31(Context context) {
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();
    }//End of constructor.

    public long addNewPart(String str_part_tm31_name, String str_part_tm31_price) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_PART_NAME_TM31, str_part_tm31_name);
        objContentValues.put(COLUMN_PART_PRICE_TM31, str_part_tm31_price);

        return writeSqLiteDatabase.insert(TABLE_TM31, null, objContentValues);
    }

    public String[] readPartName() {
        String[] strPartName = null;
        Cursor objCursor = readSqLiteDatabase.query(TABLE_TM31,
                new String[]{COLUMN_TM31_ID, COLUMN_PART_NAME_TM31},
                null, null, null, null, null, null);
        if (objCursor != null) {
            objCursor.moveToFirst();
            strPartName = new String[objCursor.getCount()];
            for (int i = 0; i < objCursor.getCount(); i++) {
                strPartName[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PART_NAME_TM31));
                objCursor.moveToNext();
            }//End for loop.
        }//ENd if.

        objCursor.close();
        return strPartName;
    }

    public String[] readPartPrice() {
        String[] strPartPrice = null;
        Cursor objCursor = readSqLiteDatabase.query(TABLE_TM31,
                new String[]{COLUMN_TM31_ID, COLUMN_PART_PRICE_TM31},
                null, null, null, null, null, null);
        if (objCursor != null) {
            objCursor.moveToFirst();
            strPartPrice = new String[objCursor.getCount()];
            for (int i = 0; i < objCursor.getCount(); i++) {
                strPartPrice[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PART_PRICE_TM31));
                objCursor.moveToNext();
            }//End for loop.
        }//ENd if.

        objCursor.close();
        return strPartPrice;
    }
}
