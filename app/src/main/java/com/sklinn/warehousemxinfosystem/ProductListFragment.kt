package com.sklinn.warehousemxinfosystem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sklinn.warehousemxinfosystem.Adapter.ProductListAdapter
import kotlinx.android.synthetic.main.fragment_product_list.*

class ProductListFragment(

): Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_product_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productList = mutableListOf<Product>()
        val adapter = ProductListAdapter()
        rvProductList.adapter = adapter
        rvProductList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        adapter.notifyDataSetChanged()
    }
}