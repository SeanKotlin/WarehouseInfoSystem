package com.sklinn.warehousemxinfosystem.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sklinn.warehousemxinfosystem.AppDatabase.AppDatabase
import com.sklinn.warehousemxinfosystem.AppDatabase.VendorDao
import com.sklinn.warehousemxinfosystem.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment: Fragment() {

    private lateinit var vendorDao: VendorDao

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vendorDao = AppDatabase.getDatabase(requireContext()).getVendorDao()
        val vendor = vendorDao.getVendorById(1)     //Id passed from LogIn Vendor

        tvPersonName.text = vendor.vendorName
        tvPersonEmail.text = vendor.email
        lbPhone.text = vendor.phone
        lbAddress.text = vendor.address
        lbTransportRoute.text = vendor.transportInfo

        btnLogOut.setOnClickListener {
            activity?.finish()
        }

    }

}