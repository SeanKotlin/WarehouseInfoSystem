package com.sklinn.warehousemxinfosystem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sklinn.warehousemxinfosystem.Activity.VendorInfoActivity
import com.sklinn.warehousemxinfosystem.Adapter.VendorListAdapter
import com.sklinn.warehousemxinfosystem.AppDatabase.AppDatabase
import com.sklinn.warehousemxinfosystem.AppDatabase.VendorDao
import kotlinx.android.synthetic.main.fragment_vendor_list.*

class VendorListFragment : Fragment() {
    private lateinit var vendorListAdapter: VendorListAdapter
    private lateinit var vendorDao: VendorDao

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vendor_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vendorDao = AppDatabase.getDatabase(requireContext()).getVendorDao()

        vendorListAdapter = VendorListAdapter()
        rvVendorList.adapter = vendorListAdapter
        rvVendorList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


        fabAddVendor.setOnClickListener {
            //go to intent
            val intent = VendorInfoActivity.newIntent(requireContext())
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        loadVendor()
    }

    private fun loadVendor(){
        val vendorList = vendorDao.getAllVendors()
        vendorListAdapter.setNewData(vendorList)
    }

}