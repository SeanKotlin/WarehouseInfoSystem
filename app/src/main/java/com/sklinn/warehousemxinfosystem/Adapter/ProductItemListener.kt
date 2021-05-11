package com.sklinn.warehousemxinfosystem.Adapter

import com.sklinn.warehousemxinfosystem.Model.Product

interface ProductItemListener {
    fun onDeleteClick(product: Product)
}