package com.example.wells.miniapp1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableDouble
import androidx.lifecycle.*
import com.example.wells.miniapp1.databinding.FragmentOneBinding
import java.text.DecimalFormat

class SomeViewModel: ViewModel(){
    var mbps: String = ""
    var mib: String = ""
    var tTime = ObservableDouble()

    fun addTransferTime(temp1: Double): String{
        val temp2 = DecimalFormat("#0.0")
        val temp3 = temp2.format(temp1) + " secs"

        return temp3
    }

    fun onTextChangeWatcher1(text: CharSequence){
        mbps = text.toString()
        if (mbps != "" && mib != "") {
            val why = Integer.parseInt(mbps)
            val why2 = Integer.parseInt(mib)
            val mibConverted = why2.toDouble() * 1.048576
            val convertedTime = mibConverted / why.toDouble()
            tTime.set(convertedTime)
        }
    }

    fun onTextChangeWatcher2(text: CharSequence){
        mib = text.toString()
        if (mbps != "" && mib != "") {
            val why = Integer.parseInt(mbps)
            val why2 = Integer.parseInt(mib)
            val mibConverted = why2.toDouble() * 1.048576
            val convertedTime = mibConverted / why.toDouble()
            tTime.set(convertedTime)
        }
    }
}

class FragmentOne : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val fragBinding: FragmentOneBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false)
        val fragView: View = fragBinding.root
        val viewModel: SomeViewModel = ViewModelProviders.of(this).get(SomeViewModel::class.java)
        fragBinding.output = viewModel
        return fragView
    }

    companion object {
        fun newInstance():FragmentOne
        {
            return FragmentOne()
        }
    }
}

//Works Cited
//https://stackoverflow.com/questions/33798426/how-to-databind-to-ontextchanged-for-an-edittext-on-android