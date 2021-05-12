package com.sklinn.warehousemxinfosystem.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sklinn.warehousemxinfosystem.Model.Product
import com.sklinn.warehousemxinfosystem.ProductItemListener
import com.sklinn.warehousemxinfosystem.R
import kotlinx.android.synthetic.main.item_product.view.*

class ProductListAdapter(
    var listener: ProductItemListener
) : RecyclerView.Adapter<ProductListAdapter.myViewHolder>() {
    private var productlist = mutableListOf<Product>()

    inner class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateUi(data: Product) {
            itemView.item_program.text = data.pProgram
            itemView.item_ProductName.text = data.pName

            itemView.btnDelete.setOnClickListener {
                listener.onDeleteClick(data)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_product, parent, false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val data = productlist.get(position)
        holder.populateUi(data)
    }

    override fun getItemCount(): Int {
        return productlist.size
    }

    fun setNewData(list: List<Product>) {
        productlist.clear()
        productlist.addAll(list)
        notifyDataSetChanged()
    }
}