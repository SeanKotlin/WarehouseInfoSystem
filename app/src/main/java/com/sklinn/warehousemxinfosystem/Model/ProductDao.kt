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