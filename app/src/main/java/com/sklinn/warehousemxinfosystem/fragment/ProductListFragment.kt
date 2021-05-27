package com.sklinn.warehousemxinfosystem.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sklinn.warehousemxinfosystem.Activity.ProductInfoActivity
import com.sklinn.warehousemxinfosystem.Adapter.ProductListAdapter
import com.sklinn.warehousemxinfosystem.AppDatabase.AppDatabase
import com.sklinn.warehousemxinfosystem.AppDatabase.ProductDao
import com.sklinn.warehousemxinfosystem.Model.Product
import com.sklinn.warehousemxinfosystem.ProductItemListener
import com.sklinn.warehousemxinfosystem.R
import kotlinx.android.synthetic.main.fragment_product_list.*

class ProductListFragment() : Fragment(), ProductItemListener {
    private lateinit var productListAdapter: ProductListAdapter
    private lateinit var productDao: ProductDao

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productDao = AppDatabase.getDatabase(requireContext()).getProductDao()


        productListAdapter = ProductListAdapter(this)
        rvProductList.adapter = productListAdapter
        rvProductList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        loadProduct()

        fabAddProduct.setOnClickListener {
            val intent = ProductInfoActivity.newIntent(requireContext())
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        loadProduct()
    }

    private fun loadProduct() {
        val productList = productDao.getAllProduct()
        productListAdapter.setNewData(productList)
    }

    override fun onDeleteClick(product: Product) {
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Delete")
            .setMessage("Are you sure to delete ${product.pName}")
            .setPositiveButton("Delete") { dialog, which ->
                dialog.dismiss()
                productDao.deleteProduct(product)
                loadProduct()
            }
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }.create()
        dialog.show()
    }
}