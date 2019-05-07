package com.example.wells.miniapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.transaction


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        displayFrag()
    }

    override fun onPause() {
        super.onPause()
        closeFrag()
    }

    fun displayFrag()
    {
        val firstFrag = FragmentOne.newInstance()
        supportFragmentManager.transaction(){
            add(R.id.fragmentOne, firstFrag)
            addToBackStack(null)
        }
    }

    fun closeFrag()
    {
        val firstFrag = supportFragmentManager.findFragmentById(R.id.fragmentOne) as FragmentOne
        if (firstFrag != null)
        {
            supportFragmentManager.transaction(){
                remove(firstFrag)
            }
        }
    }

    companion object {
        internal val STATE_FRAGMENT = "timeVal"
    }
}
