package com.sklinn.warehousemxinfosystem.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sklinn.warehousemxinfosystem.AppDatabase.AppDatabase
import com.sklinn.warehousemxinfosystem.AppDatabase.VendorDao
import com.sklinn.warehousemxinfosystem.Model.*
import com.sklinn.warehousemxinfosystem.R
import kotlinx.android.synthetic.main.activity_product_info.*
import kotlinx.android.synthetic.main.fragment_profile.*

class VendorInfoActivity : AppCompatActivity() {

    private lateinit var venderDao: VendorDao

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, VendorInfoActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_info)

        venderDao = AppDatabase.getDatabase(applicationContext).getVendorDao()

        //create product
        fabAcceptVendor.setOnClickListener {
            createVendor()
            onBackPressed()
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        finish()
//        return true
//    }

    private fun createVendor() {
        val vendorName = etVendorName.text.toString()
        val vendorEmail = etVendorEmail.text.toString()
        val vendorPhone = etVendorPhone.text.toString()
        val vendorAddress = etVendorAddress.text.toString()
        val vendorTransporation = etTransportInfo.text.toString()
        val vendorPassword = etVendorPassword.text.toString()
        val photo = ivProfilePhoto.toString()

        val vendor = Vendor(
            vendorName = vendorName,
            email = vendorEmail,
            phone = vendorPhone,
            address = vendorAddress,
            transportInfo = vendorTransporation,
            password = vendorPassword,
            photo = photo
        )
        venderDao.createVendor(vendor)
    }
}