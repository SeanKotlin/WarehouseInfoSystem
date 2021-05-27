package com.sklinn.warehousemxinfosystem.AppDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sklinn.warehousemxinfosystem.Model.Product
import com.sklinn.warehousemxinfosystem.Model.Vendor

@Database(entities = arrayOf(Product::class, Vendor::class), version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getProductDao(): ProductDao
    abstract fun getVendorDao(): VendorDao

    companion object {
        private var instance: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "default")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }

    }
}