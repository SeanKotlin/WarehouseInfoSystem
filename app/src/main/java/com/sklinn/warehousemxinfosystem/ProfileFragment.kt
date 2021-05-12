package com.sklinn.warehousemxinfosystem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment: Fragment() {

//    private lateinit var venderDao: VenderDao

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        venderDao = AppDatabase.getDatabase(requireContext()).getVendorDao()
//        val vendor = venderDao.getVendorById(1)

        tvPersonName.text = "Mr. Soe Khaing Linn"
        tvPersonEmail.text = "soekhainglinn@gmail.com"
        lbPhone.text = "09-123123123"
        lbAddress.text = "NO 39/ Aye Sadi Quarter/ Myitkyina"
        lbTransportRoute.text = "by Mann Mandalar Bus"

        btnLogOut.setOnClickListener {
            //todo logout button activity from fragment
        }

    }

}