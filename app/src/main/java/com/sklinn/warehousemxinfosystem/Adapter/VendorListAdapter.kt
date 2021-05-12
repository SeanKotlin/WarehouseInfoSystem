package com.sklinn.warehousemxinfosystem.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sklinn.warehousemxinfosystem.Model.Vendor
import com.sklinn.warehousemxinfosystem.R
import kotlinx.android.synthetic.main.item_vendor.view.*

class VendorListAdapter(
//    var listener: VendorItemListener
) : RecyclerView.Adapter<VendorListAdapter.myViewHolder>() {

    private var vendorList = mutableListOf<Vendor>()

    inner class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateUi(vendor: Vendor) {
            itemView.tvVendorName.text = vendor.vendorName
            itemView.tvVendorPhone.text = vendor.phone

//            itemView.setOnClickListener {
//                listener.onReadClick(vendor)
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_vendor, parent, false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val data = vendorList.get(position)
        holder.populateUi(data)
    }

    override fun getItemCount(): Int {
        return vendorList.size
    }

    fun setNewData(list: List<Vendor>) {
        vendorList.clear()
        vendorList.addAll(list)
        notifyDataSetChanged()
    }
}