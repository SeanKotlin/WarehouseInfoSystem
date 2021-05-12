package com.sklinn.warehousemxinfosystem.AppDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sklinn.warehousemxinfosystem.Model.Vendor

@Dao
interface VendorDao {

    @Insert
    fun createVendor(vendor: Vendor): Long

    @Query("SELECT * FROM vendor")
    fun getAllVendors(): List<Vendor>

    @Query("SELECT * FROM vendor WHERE vendor_id = :vendorId")
    fun getVendorById(vendorId: Long): Vendor
}