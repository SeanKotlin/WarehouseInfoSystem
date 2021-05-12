package com.sklinn.warehousemxinfosystem.Model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
class Product(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    @ColumnInfo(name = "product_name") val pName: String,
    @ColumnInfo(name = "product_unit") val pUnit: String,
    @ColumnInfo(name = "product_batch") val pBatch: String,
    @ColumnInfo(name = "product_expiry") val pExpiry: String,
    @ColumnInfo(name = "product_generic") val pGeneric: String,
    @ColumnInfo(name = "product_category") val pCategory: String,
    @ColumnInfo(name = "product_code") val pCode: String,
    @ColumnInfo(name = "product_program") val pProgram: String
) : Parcelable {
}