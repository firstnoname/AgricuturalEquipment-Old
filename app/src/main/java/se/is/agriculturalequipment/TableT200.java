package se.is.agriculturalequipment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by iFirst on 17/1/2560.
 */

public class TableT200 {
    public static final String TABLE_T200 = "t200TABLE";
    public static final String COLUMN_T200_ID = "_id";
    public static final String COLUMN_PART_NAME_T200 = "partNameT200";
    public static final String COLUMN_PART_PRICE_T200 = "partPriceT200";
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase readSqLiteDatabase, writeSqLiteDatabase;

    public TableT200(Context context) {
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();
    }//End of constructor.

    public long addNewPart(String part_t200_name, String part_t200_price) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_PART_NAME_T200, part_t200_name);
        objContentValues.put(COLUMN_PART_PRICE_T200, part_t200_price);

        return writeSqLiteDatabase.insert(TABLE_T200, null, objContentValues);
    }

    public String[] readPartName() {
        String[] strPartName = null;
        Cursor objCursor = readSqLiteDatabase.query(TABLE_T200,
                new String[]{COLUMN_T200_ID, COLUMN_PART_NAME_T200},
                null, null, null, null, null, null);
        if (objCursor != null) {
            objCursor.moveToFirst();
            strPartName = new String[objCursor.getCount()];
            for (int i = 0; i < objCursor.getCount(); i++) {
                strPartName[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PART_NAME_T200));
                objCursor.moveToNext();
            }//End for loop.
        }//ENd if.

        objCursor.close();
        return strPartName;
    }

    public String[] readPartPrice() {
        String[] strPartPrice = null;
        Cursor objCursor = readSqLiteDatabase.query(TABLE_T200,
                new String[]{COLUMN_T200_ID, COLUMN_PART_PRICE_T200},
                null, null, null, null, null, null);
        if (objCursor != null) {
            objCursor.moveToFirst();
            strPartPrice = new String[objCursor.getCount()];
            for (int i = 0; i < objCursor.getCount(); i++) {
                strPartPrice[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PART_PRICE_T200));
                objCursor.moveToNext();
            }//End for loop.
        }//ENd if.

        objCursor.close();
        return strPartPrice;
    }
}
