package com.example.crud

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASENAME = "tokofirman"
val TABLENAME = "laptop"
val COL_ID  = "id"
val COL_BRAND = "brand"
val COL_SERI = "seri"
val COL_HARGA = "harga"
val COL_STATUS = "status"
val COL_TAGS = "tags"
class DBHelper(val context: Context): SQLiteOpenHelper(context, DATABASENAME,null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val createTable =
            "CREATE TABLE " + TABLENAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_BRAND + " VARCHAR(20)," + COL_SERI + " VARCHAR(30), " +
                    COL_HARGA + " INTEGER, " + COL_STATUS + " VARCHAR(20), " + COL_TAGS + " VARCHAR(50) )"
        p0?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
    fun insertData(laptop: LaptopModel) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_BRAND, laptop.brand)
        contentValues.put(COL_SERI, laptop.seri)
        contentValues.put(COL_HARGA, laptop.harga)
        contentValues.put(COL_STATUS, laptop.status)
        contentValues.put(COL_TAGS, laptop.tags)
        val result = database.insert(TABLENAME, null, contentValues)
        if (result == (0).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("Range")
    fun readData():


}