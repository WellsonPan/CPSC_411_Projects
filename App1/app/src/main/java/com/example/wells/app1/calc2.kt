package com.example.wells.app1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher

import kotlinx.android.synthetic.main.activity_calc2.*
import java.text.DecimalFormat

class calc2 : AppCompatActivity() {

    fun valid():Boolean{
        return editText.text.toString() != "" && editText2.text.toString() != "" && editText3.text.toString() != "" && editText3.text.toString() != "0"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc2)

        val tip = object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                if (valid()) {
                    val butts = editText.text
                    val butts2 = editText2.text
                    val butts3 = editText3.text
                    val but = butts.toString()
                    val but2 = butts2.toString()
                    val but3 = butts3.toString()
                    val why = but.toFloat()
                    val why2 = but2.toFloat()
                    val why3 = but3.toFloat()

                    val firstEval = why * (why2 / 100)
                    val secondEval = firstEval + why
                    val thirdEval = secondEval / why3
                    val formatter = DecimalFormat("#0.00")
                    val formatter2 = "$" + formatter.format(thirdEval) + " per person"
                    textView4.text = formatter2
                }
                else
                {
                    textView4.setText(R.string.validity)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun afterTextChanged(s: Editable?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
        editText.addTextChangedListener(tip)
        editText2.addTextChangedListener(tip)
        editText3.addTextChangedListener(tip)
    }
}
