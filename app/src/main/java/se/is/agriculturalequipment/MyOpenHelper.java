package se.is.agriculturalequipment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by iFirst on 12/19/16.
 */

public class MyOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AgriculturalEquipment.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE_G200 = "create table g200TABLE(_id integer primary key, partName TEXT, partPrice REAL);";

    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_G200);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
