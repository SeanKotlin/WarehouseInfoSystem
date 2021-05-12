package com.sklinn.warehousemxinfosystem.AppDatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sklinn.warehousemxinfosystem.Model.Product
import com.sklinn.warehousemxinfosystem.Model.Vendor

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


