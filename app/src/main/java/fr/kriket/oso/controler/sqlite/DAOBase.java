package fr.kriket.oso.controler.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by fred on 1/1/17.
 */

public abstract class DAOBase {

    // Database version

    protected final static int VERSION = 1;

    // File Name
    protected final static String NOM = "database.db";
    protected SQLiteDatabase mDb = null;
    protected DatabaseHandler mHandler = null;



    public DAOBase(Context pContext) {
        this.mHandler = new DatabaseHandler(pContext, NOM, null, VERSION);
    }



    public SQLiteDatabase open() {
        // Pas besoin de fermer la dernière base puisque getWritableDatabase s'en charge
        mDb = mHandler.getWritableDatabase();
        return mDb;
    }



    public void close() {
        mDb.close();
    }



    public SQLiteDatabase getDb() {
        return mDb;
    }

}
