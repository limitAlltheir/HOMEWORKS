package by.limitAlltheir.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.limitAlltheir.myapplication.database.dao.DoctorDao
import by.limitAlltheir.myapplication.database.entity.Doctor

@Database(entities = [Doctor::class], version = 1)
abstract class DoctorDB : RoomDatabase() {

    abstract fun doctorDao(): DoctorDao
}

object Db {
    fun getDb(context: Context) {
        Room.databaseBuilder(context, DoctorDB::class.java, "DoctorDataBase").build()
    }
}