package com.example.trits.tritsstatus

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table " + TABLE_Service + "(" + ID
                + " integer primary key," + NAME + " text," + Status + " text" + ")")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("drop table if exists $TABLE_Service")
        onCreate(db)
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "DBTrits"

        const val TABLE_Service = "Service"
        const val ID = "_id"
        const val NAME = "service_name"
        const val Status = "status"
    }
}