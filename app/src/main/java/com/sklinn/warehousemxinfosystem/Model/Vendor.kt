package com.sklinn.warehousemxinfosystem.Model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
class Vendor(

    @PrimaryKey(autoGenerate = true)
    val vendor_id: Long? = null,

    @ColumnInfo(name = "vendeor_name")
    val vendorName: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "phone")
    val phone: String,

    @ColumnInfo(name = "address")
    val address: String,

    @ColumnInfo(name = "transport_info")
    val transportInfo: String,

    @ColumnInfo(name = "login_password")
    val password: String,

    @ColumnInfo(name = "photo")
    val photo: String
): Parcelable