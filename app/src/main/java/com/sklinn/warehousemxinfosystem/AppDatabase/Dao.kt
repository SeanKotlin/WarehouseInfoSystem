package com.sklinn.warehousemxinfosystem.Model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert
    fun createProduct(product: Product): Long

    @Query("SELECT * FROM product")
    fun getAllProduct(): List<Product>

    @Query("SELECT * FROM product WHERE id = :id")
    fun getProductById(id: Long): Product

    @Delete
    fun deleteProduct(product: Product): Int
}

@Dao
interface VenderDao{

    @Insert
    fun createVendor(vendor: Vendor): Long

//    @Query ("SELECT * FROM table_vendor WHERE vendor_id = :id")
//    fun getVendorById(id: Long): Vendor

    @Query("SELECT * FROM table_vendor")
    fun getAllVendors(): List<Vendor>
}