package com.cindytech.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.cindytech.model.Model;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String MODEL_TABLE = "MODEL_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_MODEL_NUMBER = "MODEL_NUMBER";
    public static final String COLUMN_MODEL_ARM = "MODEL_ARM";
    public static final String COLUMN_MODEL_DISARM = "MODEL_DISARM";
    public static final String COLUMN_MODEL_NIGHT = "MODEL_NIGHT";
    public static final String COLUMN_MODEL_DAY = "MODEL_DAY";
    public static final String COLUMN_MODEL_STATUS = "MODEL_STATUS";
    public static final String COLUMN_MODEL_ENABLE = "MODEL_ENABLE";
    public static final String COLUMN_MODEL_DISABLE = "MODEL_DISABLE";
    public static final String COLUMN_MODEL_TIME = "MODEL_TIME";
    public static final String COLUMN_MODEL_PASSWORD = "MODEL_PASSWORD";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "model.db", null, 1);
    }

    // this is called the firs time a database is accessed. There should be code in here to create a new database.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + MODEL_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_MODEL_NUMBER + " TEXT, " + COLUMN_MODEL_ARM + " TEXT, " + COLUMN_MODEL_DISARM + " TEXT , " + COLUMN_MODEL_NIGHT + " TEXT, " + COLUMN_MODEL_DAY + " TEXT, " + COLUMN_MODEL_STATUS + " TEXT, " + COLUMN_MODEL_ENABLE + " TEXT, " + COLUMN_MODEL_DISABLE + " TEXT, " + COLUMN_MODEL_TIME + " TEXT, " + COLUMN_MODEL_PASSWORD + " TEXT)";
        db.execSQL(createTableStatement);
    }


    // this is called if the database version number changes. It present previous users apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(Model model){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_MODEL_NUMBER, model.getNumber());
        cv.put(COLUMN_MODEL_ARM, model.getArm());
        cv.put(COLUMN_MODEL_DISARM, model.getDisarm());
        cv.put(COLUMN_MODEL_NIGHT, model.getNight());
        cv.put(COLUMN_MODEL_DAY, model.getDay());
        cv.put(COLUMN_MODEL_STATUS, model.getStatus());
        cv.put(COLUMN_MODEL_ENABLE, model.getEnable());
        cv.put(COLUMN_MODEL_DISABLE, model.getDisable());
        cv.put(COLUMN_MODEL_TIME, model.getTime());
        cv.put(COLUMN_MODEL_PASSWORD, model.getPassword());

        long insert = db.insert(MODEL_TABLE, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}
