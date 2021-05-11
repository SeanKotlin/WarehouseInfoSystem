package com.sklinn.warehousemxinfosystem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sklinn.warehousemxinfosystem.Adapter.ProductItemListener
import com.sklinn.warehousemxinfosystem.Adapter.ProductListAdapter
import com.sklinn.warehousemxinfosystem.Model.AppDatabase
import com.sklinn.warehousemxinfosystem.Model.Product
import com.sklinn.warehousemxinfosystem.Model.ProductDao
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
        val productList = productDao.getAllProduct()

        productListAdapter = ProductListAdapter(this)
        rvProductList.adapter = productListAdapter
        rvProductList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        productListAdapter.setNewData(productList)

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
        productDao = AppDatabase.getDatabase(requireContext()).getProductDao()
        productDao.getAllProduct()
    }

    override fun onDeleteClick(product: Product) {
        val Dialog = AlertDialog.Builder(requireContext())
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
        Dialog.show()
    }
}