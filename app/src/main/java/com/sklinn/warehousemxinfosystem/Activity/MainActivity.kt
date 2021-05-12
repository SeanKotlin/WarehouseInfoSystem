package com.sklinn.warehousemxinfosystem.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.sklinn.warehousemxinfosystem.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bot_navigation.setOnNavigationItemSelectedListener { item->
            val fragment = when(item.itemId){
                R.id.menu_bot_productlist -> ProductListFragment()
                R.id.menu_bot_vendor -> VendorListFragment()
                R.id.menu_bot_transaction -> TransactionFragment()

                R.id.menu_bot_profile -> ProfileFragment()
                else -> null
            }
            fragment?.let {
                replaceFragment(it)
            }

         return@setOnNavigationItemSelectedListener true
        }
        bot_navigation.selectedItemId = R.id.menu_bot_productlist
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerMain,fragment)
                .commit()
    }
}