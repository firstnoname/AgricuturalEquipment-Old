package se.is.agriculturalequipment;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by iFirst on 16/1/2560.
 */

public class TableGX35 {

    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase readSqLiteDatabase, writeSqLiteDatabase;

    public static final String TABLE_GX35 = "gx35TABLE";
    public static final String COLUMN_GX35_ID = "_id";
    public static final String COLUMN_PART_NAME = "partName";
    public static final String COLUMN_PART_PRICE = "partPrice";

    public TableGX35(Context context) {
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();
    }//End of structure.

    public long addNewPart(String strName, String strPrice) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_PART_NAME, strName);
        objContentValues.put(COLUMN_PART_PRICE, strPrice);

        return writeSqLiteDatabase.insert(TABLE_GX35, null, objContentValues);
    }


}
