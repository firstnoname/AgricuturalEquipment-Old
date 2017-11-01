package se.is.agriculturalequipment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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


        String insertG200a = "INSERT INTO g200TABLE (partNameG200,partPriceG200) VALUES ('จานกระตุก','420');";
        String insertG200b = "INSERT INTO g200TABLE (partNameG200,partPriceG200) VALUES ('ถังน้ำมัน','700');";
        String insertG200c = "INSERT INTO g200TABLE (partNameG200,partPriceG200) VALUES ('หม้อกรองอากาศ','250');";
        String insertG200d = "INSERT INTO g200TABLE (partNameG200,partPriceG200) VALUES ('คาร์บูเรเตอร์','450');";
        String insertG200e = "INSERT INTO g200TABLE (partNameG200,partPriceG200) VALUES ('เสื้อสูบ','2200');";
        String insertG200f = "INSERT INTO g200TABLE (partNameG200,partPriceG200) VALUES ('ก๊อกน้ำมัน','150');";
        String insertG200g = "INSERT INTO g200TABLE (partNameG200,partPriceG200) VALUES ('ท่อไอเสีย','160');";
        String insertG200h = "INSERT INTO g200TABLE (partNameG200,partPriceG200) VALUES ('สวิตช์ปิดเปิด','120');";
        String insertG200i = "INSERT INTO g200TABLE (partNameG200,partPriceG200) VALUES ('คอยล์','580');";
        String insertG200j = "INSERT INTO g200TABLE (partNameG200,partPriceG200) VALUES ('ฝาถังน้ำมัน','50');";
        String insertG200k = "INSERT INTO g200TABLE (partNameG200,partPriceG200) VALUES ('ทำสี','120');";
        String insertG200l = "INSERT INTO g200TABLE (partNameG200,partPriceG200) VALUES ('ฝาถังน้ำมันเครื่อง','50');";
        String insertG200m = "INSERT INTO g200TABLE (partNameG200,partPriceG200) VALUES ('ปลั๊กหัวเทียน','50');";

        sqLiteDatabase.execSQL(insertG200a);
        sqLiteDatabase.execSQL(insertG200b);
        sqLiteDatabase.execSQL(insertG200c);
        sqLiteDatabase.execSQL(insertG200d);
        sqLiteDatabase.execSQL(insertG200e);
        sqLiteDatabase.execSQL(insertG200f);
        sqLiteDatabase.execSQL(insertG200g);
        sqLiteDatabase.execSQL(insertG200h);
        sqLiteDatabase.execSQL(insertG200i);
        sqLiteDatabase.execSQL(insertG200j);
        sqLiteDatabase.execSQL(insertG200k);
        sqLiteDatabase.execSQL(insertG200l);
        sqLiteDatabase.execSQL(insertG200m);

        String insertGX160a = "INSERT INTO gx160TABLE (partNameGX160,partPriceGX160) VALUES ('จานกระตุก','420');";
        String insertGX160b = "INSERT INTO gx160TABLE (partNameGX160,partPriceGX160) VALUES ('ถังน้ำมัน','650');";
        String insertGX160c = "INSERT INTO gx160TABLE (partNameGX160,partPriceGX160) VALUES ('หม้อกรองอากาศ','300');";
        String insertGX160d = "INSERT INTO gx160TABLE (partNameGX160,partPriceGX160) VALUES ('คาร์บูเรเตอร์','420');";
        String insertGX160e = "INSERT INTO gx160TABLE (partNameGX160,partPriceGX160) VALUES ('เสื้อสูบ','1800');";
        String insertGX160f = "INSERT INTO gx160TABLE (partNameGX160,partPriceGX160) VALUES ('ก๊อกน้ำมัน','150');";
        String insertGX160g = "INSERT INTO gx160TABLE (partNameGX160,partPriceGX160) VALUES ('ท่อไอเสีย','150');";
        String insertGX160h = "INSERT INTO gx160TABLE (partNameGX160,partPriceGX160) VALUES ('สวิตช์ปิดเปิด','120');";
        String insertGX160i = "INSERT INTO gx160TABLE (partNameGX160,partPriceGX160) VALUES ('คอยล์','550');";
        String insertGX160j = "INSERT INTO gx160TABLE (partNameGX160,partPriceGX160) VALUES ('ฝาถังน้ำมัน','50');";
        String insertGX160k = "INSERT INTO gx160TABLE (partNameGX160,partPriceGX160) VALUES ('ทำสี','120');";
        String insertGX160l = "INSERT INTO gx160TABLE (partNameGX160,partPriceGX160) VALUES ('ฝาถังน้ำมันเครื่อง','50');";
        String insertGX160m = "INSERT INTO gx160TABLE (partNameGX160,partPriceGX160) VALUES ('ปลั๊กหัวเทียน','50');";

        sqLiteDatabase.execSQL(insertGX160a);
        sqLiteDatabase.execSQL(insertGX160b);
        sqLiteDatabase.execSQL(insertGX160c);
        sqLiteDatabase.execSQL(insertGX160d);
        sqLiteDatabase.execSQL(insertGX160e);
        sqLiteDatabase.execSQL(insertGX160f);
        sqLiteDatabase.execSQL(insertGX160g);
        sqLiteDatabase.execSQL(insertGX160h);
        sqLiteDatabase.execSQL(insertGX160i);
        sqLiteDatabase.execSQL(insertGX160j);
        sqLiteDatabase.execSQL(insertGX160k);
        sqLiteDatabase.execSQL(insertGX160l);
        sqLiteDatabase.execSQL(insertGX160m);


        String insertGX35a = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('จานกระตุก','350');";
        String insertGX35b = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('ถังน้ำมัน','350');";
        String insertGX35c = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('มือเร่ง','180');";
        String insertGX35d = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('ใบมีด','150');";
        String insertGX35e = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('หม้อกรองอากาศ','250');";
        String insertGX35f = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('คาร์บูเรเตอร์','550');";
        String insertGX35g = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('เสื้อสูบ','850');";
        String insertGX35h = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('ก๊อกน้ำมัน','120');";
        String insertGX35i = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('ท่อไอเสีย','210');";
        String insertGX35j = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('คอตัดหญ้า','800');";
        String insertGX35k = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('กระบอกหาง','580');";
        String insertGX35l = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('สวิตช์ปิดเปิด','80');";
        String insertGX35m = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('คอยล์','550');";
        String insertGX35n = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('ฝาถังน้ำมัน','50');";
        String insertGX35o = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('ทำสี','80');";
        String insertGX35p = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('แกนเพลา','280');";
        String insertGX35q = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('ฝาถังน้ำมันเครื่อง','50');";
        String insertGX35r = "INSERT INTO gx35TABLE (partNameGX35,partPriceGX35) VALUES ('ปลั๊กหัวเทียน','50');";

        sqLiteDatabase.execSQL(insertGX35a);
        sqLiteDatabase.execSQL(insertGX35b);
        sqLiteDatabase.execSQL(insertGX35c);
        sqLiteDatabase.execSQL(insertGX35d);
        sqLiteDatabase.execSQL(insertGX35e);
        sqLiteDatabase.execSQL(insertGX35f);
        sqLiteDatabase.execSQL(insertGX35g);
        sqLiteDatabase.execSQL(insertGX35h);
        sqLiteDatabase.execSQL(insertGX35i);
        sqLiteDatabase.execSQL(insertGX35j);
        sqLiteDatabase.execSQL(insertGX35k);
        sqLiteDatabase.execSQL(insertGX35l);
        sqLiteDatabase.execSQL(insertGX35m);
        sqLiteDatabase.execSQL(insertGX35n);
        sqLiteDatabase.execSQL(insertGX35o);
        sqLiteDatabase.execSQL(insertGX35p);
        sqLiteDatabase.execSQL(insertGX35q);
        sqLiteDatabase.execSQL(insertGX35r);


        String insertT200a = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('จานกระตุก','340');";
        String insertT200b = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('ถังน้ำมัน','280');";
        String insertT200c = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('มือเร่ง','160');";
        String insertT200d = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('ใบมีด','150');";
        String insertT200e = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('หม้อกรองอากาศ','200');";
        String insertT200f = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('คาร์บูเรเตอร์','480');";
        String insertT200g = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('เสื้อสูบ','650');";
        String insertT200h = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('ก๊อกน้ำมัน','120');";
        String insertT200i = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('ท่อไอเสีย','160');";
        String insertT200j = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('คอตัดหญ้า','750');";
        String insertT200k = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('กระบอกหาง','580');";
        String insertT200l = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('สวิตช์ปิดเปิด','80');";
        String insertT200m = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('คอยล์','550');";
        String insertT200n = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('ฝาถังน้ำมัน','50');";
        String insertT200o = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('ทำสี','50');";
        String insertT200p = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('แกนเพลา','280');";
        String insertT200q = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('ฝาถังน้ำมันเครื่อง','50');";
        String insertT200r = "INSERT INTO t200TABLE (partNameT200,partPriceT200) VALUES ('ปลั๊กหัวเทียน','50');";

        sqLiteDatabase.execSQL(insertT200a);
        sqLiteDatabase.execSQL(insertT200b);
        sqLiteDatabase.execSQL(insertT200c);
        sqLiteDatabase.execSQL(insertT200d);
        sqLiteDatabase.execSQL(insertT200e);
        sqLiteDatabase.execSQL(insertT200f);
        sqLiteDatabase.execSQL(insertT200g);
        sqLiteDatabase.execSQL(insertT200h);
        sqLiteDatabase.execSQL(insertT200i);
        sqLiteDatabase.execSQL(insertT200j);
        sqLiteDatabase.execSQL(insertT200k);
        sqLiteDatabase.execSQL(insertT200l);
        sqLiteDatabase.execSQL(insertT200m);
        sqLiteDatabase.execSQL(insertT200n);
        sqLiteDatabase.execSQL(insertT200o);
        sqLiteDatabase.execSQL(insertT200p);
        sqLiteDatabase.execSQL(insertT200q);
        sqLiteDatabase.execSQL(insertT200r);


        String insertTM31a = "INSERT INTO tm31TABLE (partNameTM31,partPriceTM31) VALUES ('หม้อลม','350');";
        String insertTM31b = "INSERT INTO tm31TABLE (partNameTM31,partPriceTM31) VALUES ('ลูกยางชุด','220');";
        String insertTM31c = "INSERT INTO tm31TABLE (partNameTM31,partPriceTM31) VALUES ('ตัวตั้งโปโล','580');";
        String insertTM31d = "INSERT INTO tm31TABLE (partNameTM31,partPriceTM31) VALUES ('ท่อนดูด','350');";
        String insertTM31e = "INSERT INTO tm31TABLE (partNameTM31,partPriceTM31) VALUES ('ท่อนส่ง','550');";
        String insertTM31f = "INSERT INTO tm31TABLE (partNameTM31,partPriceTM31) VALUES ('ลูกสูบ','220');";
        String insertTM31g = "INSERT INTO tm31TABLE (partNameTM31,partPriceTM31) VALUES ('มู่เล่ย์','280');";
        String insertTM31h = "INSERT INTO tm31TABLE (partNameTM31,partPriceTM31) VALUES ('เกย์วัดความดัน','180');";
        String insertTM31i = "INSERT INTO tm31TABLE (partNameTM31,partPriceTM31) VALUES ('ก๊อกน้ำ','65');";
        String insertTM31j = "INSERT INTO tm31TABLE (partNameTM31,partPriceTM31) VALUES ('ฝาปิดน้ำมันเครื่อง','50');";
        String insertTM31k = "INSERT INTO tm31TABLE (partNameTM31,partPriceTM31) VALUES ('ทำสี','80');";
        String insertTM31l = "INSERT INTO tm31TABLE (partNameTM31,partPriceTM31) VALUES ('ฝาถังน้ำมันเครื่อง','50');";

        sqLiteDatabase.execSQL(insertTM31a);
        sqLiteDatabase.execSQL(insertTM31b);
        sqLiteDatabase.execSQL(insertTM31c);
        sqLiteDatabase.execSQL(insertTM31d);
        sqLiteDatabase.execSQL(insertTM31e);
        sqLiteDatabase.execSQL(insertTM31f);
        sqLiteDatabase.execSQL(insertTM31g);
        sqLiteDatabase.execSQL(insertTM31h);
        sqLiteDatabase.execSQL(insertTM31i);
        sqLiteDatabase.execSQL(insertTM31j);
        sqLiteDatabase.execSQL(insertTM31k);
        sqLiteDatabase.execSQL(insertTM31l);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
