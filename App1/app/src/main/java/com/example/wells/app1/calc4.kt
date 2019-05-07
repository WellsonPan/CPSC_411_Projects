package com.example.wells.app1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import java.text.DecimalFormat

import kotlinx.android.synthetic.main.activity_calc4.*

class calc4 : AppCompatActivity(){

    var pos: String = ""
    var pos2: String = ""
    var pos3: String = ""
    var pos4: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc4)

        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, R.array.lengths, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = adapter
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                 pos = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                textView.text = getString(R.string.selectUnit)
            }
        }
        spinner2.adapter = adapter
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                pos2 = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                textView.text = getString(R.string.selectUnit)
            }

        }

        val adapter2 : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, R.array.weights, android.R.layout.simple_spinner_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner3.adapter = adapter2
        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                pos3 = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                textView.text = getString(R.string.selectUnit)
            }
        }
        spinner4.adapter = adapter2
        spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                pos4 = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                textView.text = getString(R.string.selectUnit)
            }

        }

        button.setOnClickListener {view ->
            when(view.getId()) {
                R.id.button -> lengthConversion()
            }
        }

        button2.setOnClickListener{view ->
            when(view.getId()){
                R.id.button2->weightConversion()
            }
        }
    }

    fun weightConversion(){
        if (editText2.text.toString() != "")
        {
            var temp: Float = 0.0f
            var temp2: Float = 0.0f
            if (pos3 == "Milligrams"){
                temp = editText2.text.toString().toFloat()
            }
            else if(pos3 == "Grams"){
                temp = editText2.text.toString().toFloat() * 1000.0f
            }
            else if (pos3 == "Kilograms"){
                temp = editText2.text.toString().toFloat() * 1000.0f * 1000.0f
            }
            else if(pos3 == "Metric Tons"){
                temp = editText2.text.toString().toFloat() * 1000.0f * 1000.0f * 1000.0f
            }
            else if (pos3 == "Ounces"){
                temp = editText2.text.toString().toFloat() * 28349.5f
            }
            else if (pos3 == "Pounds"){
                temp = editText2.text.toString().toFloat() * 28349.5f * 16.0f
            }
            else if (pos3 == "Tons"){
                temp = editText2.text.toString().toFloat() * 28349.5f * 16.0f * 2000.0f
            }

            if (pos4 == "Milligrams"){
                temp2 = temp
            }
            else if(pos4 == "Grams"){
                temp2 = temp / 1000.0f
            }
            else if (pos4 == "Kilograms"){
                temp2 = temp / (1000.0f * 1000.0f)
            }
            else if(pos4 == "Metric Tons"){
                temp2 = temp / (1000.0f * 1000.0f * 1000.0f)
            }
            else if (pos4 == "Ounces"){
                temp2 = temp / 28349.5f
            }
            else if (pos4 == "Pounds"){
                temp2 = temp / (28349.5f * 16.0f)
            }
            else if (pos4 == "Tons"){
                temp2 = temp / (28349.5f * 16.0f * 2000.0f)
            }

            val formatter = DecimalFormat("#0.00")
            val temp3 = formatter.format(temp2) + " " + pos4
            textView2.text = temp3
        }
        else
        {
            textView2.text = getString(R.string.validity)
        }
    }

    fun lengthConversion(){
        if (editText1.text.toString() != "")
        {
            var temp: Float = 0.0f
            var temp2: Float = 0.0f
            if (pos == "Centimeters"){
                temp = editText1.text.toString().toFloat()
            }
            else if(pos == "Meters"){
                temp = editText1.text.toString().toFloat() * 100.0f
            }
            else if (pos == "Kilometers"){
                temp = editText1.text.toString().toFloat() * 1000.0f
            }
            else if(pos == "Inches"){
                temp = editText1.text.toString().toFloat() * 2.54f
            }
            else if (pos == "Feet"){
                temp = editText1.text.toString().toFloat() * 2.54f * 12.0f
            }
            else if (pos == "Yards"){
                temp = editText1.text.toString().toFloat() * 2.54f * 36.0f
            }
            else if (pos == "Miles"){
                temp = editText1.text.toString().toFloat() * 2.54f * 63360.0f
            }

            if (pos2 == "Centimeters"){
                temp2 = temp
            }
            else if(pos2 == "Meters"){
                temp2 = temp / 100.0f
            }
            else if (pos2 == "Kilometers"){
                temp2 = temp / 1000.0f
            }
            else if(pos2 == "Inches"){
                temp2 = temp / 2.54f
            }
            else if (pos2 == "Feet"){
                temp2 = temp / (2.54f * 12.0f)
            }
            else if (pos2 == "Yards"){
                temp2 = temp / (2.54f * 36.0f)
            }
            else if (pos2 == "Miles"){
                temp2 = temp / (2.54f * 63360.0f)
            }

            val formatter = DecimalFormat("#0.00")
            val temp3 = formatter.format(temp2) + " " + pos2
            textView.text = temp3
        }
        else
        {
            textView.text = getString(R.string.validity)
        }
    }
}
