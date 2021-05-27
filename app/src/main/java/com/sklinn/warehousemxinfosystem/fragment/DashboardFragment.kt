package com.sklinn.warehousemxinfosystem.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sklinn.warehousemxinfosystem.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment(): Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_dashboard,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        containerDBProductList.setOnClickListener {
           //go to respective fragment

        }

    }

}