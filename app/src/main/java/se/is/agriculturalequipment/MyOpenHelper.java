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
    private static final String CREATE_TABLE_G200 = "create table g200TABLE(_id integer primary key, partNameG200 TEXT, partPriceG200 TEXT);";
    private static final String CREATE_TABLE_GX160 = "create table gx160TABLE(_id integer primary key, partNameGX160 TEXT, partPriceGX160 TEXT);";
    private static final String CREATE_TABLE_GX35 = "create table gx35TABLE(_id integer primary key, partNameGX35 TEXT, partPriceGX35 TEXT);";
    private static final String CREATE_TABLE_T200 = "create table t200TABLE(_id integer primary key, partNameT200 TEXT, partPriceT200 TEXT);";
    private static final String CREATE_TABLE_TM31 = "create table tm31TABLE(_id integer primary key, partNameTM31 TEXT, partPriceTM31 TEXT);";

    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_G200);
        sqLiteDatabase.execSQL(CREATE_TABLE_GX160);
        sqLiteDatabase.execSQL(CREATE_TABLE_GX35);
        sqLiteDatabase.execSQL(CREATE_TABLE_T200);
        sqLiteDatabase.execSQL(CREATE_TABLE_TM31);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
