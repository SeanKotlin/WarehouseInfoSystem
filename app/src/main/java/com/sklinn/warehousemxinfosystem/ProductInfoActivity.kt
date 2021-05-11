package com.sklinn.warehousemxinfosystem

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sklinn.warehousemxinfosystem.Model.AppDatabase
import com.sklinn.warehousemxinfosystem.Model.Product
import com.sklinn.warehousemxinfosystem.Model.ProductDao
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
        fabAcceptProduct.setOnClickListener {
            createProduct()
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun createProduct() {
        val productName = etProductName.text.toString()
        val productUnit = etProductUnit.text.toString()
        val prductBatch = etProductBatchNumber.text.toString()
        val productExpiry = etProductExpiry.text.toString()
        val productGeneric = etProductGenericName.text.toString()
        val productCategory = etProductCategory.text.toString()
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