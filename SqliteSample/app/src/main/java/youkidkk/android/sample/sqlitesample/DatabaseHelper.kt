package youkidkk.android.sample.sqlitesample

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DROP_TABLE)
        onCreate(db)
    }

    companion object {
        val DB_NAME = "data.db"
        val TABLE_NAME = "data"
        val CREATE_TABLE = "create table ${TABLE_NAME} ( id integer primary key autoincrement, value varchar );"
        val DROP_TABLE = "drop table ${TABLE_NAME};"
    }

}
