package com.sklinn.warehousemxinfosystem.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sklinn.warehousemxinfosystem.AppDatabase.AppDatabase
import com.sklinn.warehousemxinfosystem.Model.Product
import com.sklinn.warehousemxinfosystem.Model.ProductDao
import com.sklinn.warehousemxinfosystem.R
import kotlinx.android.synthetic.main.activity_product_info.*

class ProductInfoActivity : AppCompatActivity() {

    private lateinit var productDao: ProductDao

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ProductInfoActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_info)

        productDao = AppDatabase.getDatabase(applicationContext).getProductDao()

        //create product
        fabAcceptVendor.setOnClickListener {
            createProduct()
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun createProduct() {
        val productName = etVendorName.text.toString()
        val productUnit = etVendorEmail.text.toString()
        val prductBatch = etVendorPhone.text.toString()
        val productExpiry = etVendorAddress.text.toString()
        val productGeneric = etTransportInfo.text.toString()
        val productCategory = etVendorPassword.text.toString()
        val productCode = etProductCode.text.toString()
        val productProgram = etProductProgram.text.toString()
        val product = Product(
            pName = productName,
            pUnit = productUnit,
            pBatch = prductBatch,
            pExpiry = productExpiry,
            pGeneric = productGeneric,
            pCategory = productCategory,
            pCode = productCode,
            pProgram = productProgram
        )
        productDao.createProduct(product)
    }
}