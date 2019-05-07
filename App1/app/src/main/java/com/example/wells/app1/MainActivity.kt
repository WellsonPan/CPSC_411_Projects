package com.example.wells.app1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.view.*

data class Calculators(val name: String)

val calc = arrayOf(Calculators("BMI Calculator"), Calculators("Tip Calculator"), Calculators("Tax Calculator"), Calculators("Unit Conversion"))

class MainActivity : AppCompatActivity() {
    
    data class ViewHolder(val text1: TextView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView.adapter = object : ArrayAdapter<Calculators>(this, R.layout.item, R.id.calcNameView, calc){

            override fun getView(position:Int, convertView: View?, parent: ViewGroup): View{
                val item = super.getView(position, convertView, parent)
                var holder: ViewHolder? = item.tag as ViewHolder?

                if (holder == null)
                {
                    holder = ViewHolder(item.calcNameView)
                    item.tag = holder
                }

                holder.text1.text = calc[position].name

                return item
            }
        }

        listView.setOnItemClickListener{_, _, position, _ ->
            if (position == 0)
            {
                showCalc1()
            }
            else if (position == 1)
            {
                showCalc2()
            }
            else if (position == 2)
            {
                showCalc3()
            }
            else if (position == 3)
            {
                showCalc4()
            }
        }
    }

    fun showCalc1(){
        val intent = Intent(this, calc1::class.java)
        startActivity(intent)
    }

    fun showCalc2(){
        val intent = Intent(this, calc2::class.java)
        startActivity(intent)
    }

    fun showCalc3() {
        val intent = Intent(this, calc3::class.java)
        startActivity(intent)
    }

    fun showCalc4(){
        val intent = Intent(this, calc4::class.java)
        startActivity(intent)
    }
}
