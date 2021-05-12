package com.sklinn.warehousemxinfosystem

import com.sklinn.warehousemxinfosystem.Model.Product
import com.sklinn.warehousemxinfosystem.Model.Vendor

interface ProductItemListener {
    fun onDeleteClick(product: Product)
}

interface VendorItemListener{
    fun onReadClick(vendor: Vendor)
}