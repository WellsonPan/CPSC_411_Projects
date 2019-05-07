package com.example.wells.app1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher

import kotlinx.android.synthetic.main.activity_calc1.*
import java.text.DecimalFormat

class calc1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc1)

        val bmi = object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                if (editText.text.toString() != "" && editText2.text.toString() != "") {
                    val butts = editText.text
                    val butts2 = editText2.text
                    val but = butts.toString()
                    val but2 = butts2.toString()
                    val why = but.toFloat()
                    val why2 = but2.toFloat()
                    val why3 = why2 / 100

                    val firstEval = why / why3
                    val secondEval = firstEval / why3
                    val formatter = DecimalFormat("#0.0")
                    val formatter2 = formatter.format(secondEval) + " kg/m2"
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
        editText.addTextChangedListener(bmi)
        editText2.addTextChangedListener(bmi)
    }
}
