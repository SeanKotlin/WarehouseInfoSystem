package com.sklinn.warehousemxinfosystem.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun getProductDao(): ProductDao

    companion object{
        private var instance : AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase{
            if (instance==null){
                instance = Room.databaseBuilder(context,AppDatabase::class.java,"default")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                }
            return instance!!
        }

    }
}