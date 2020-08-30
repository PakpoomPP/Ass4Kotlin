package com.example.ass4kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showDatePickerDialog(v: View) {
        val newDateFragment = DatePickerFragment()
        newDateFragment.show(supportFragmentManager, "Date Picker")
    }

    fun showResult(view: View) {
        val selectID: Int = radioGroup.checkedRadioButtonId
        var gender = ""
        try {
            var radioButtonChecked: RadioButton = findViewById(selectID)
            gender = radioButtonChecked.text as String
        } catch (t: Throwable) {
            gender = ""
        }
        text_show.text =
            "Name: ${edit_name.text}\nPassword: ${edit_pass.text}\nGender: ${gender}\nEmail: ${edit_email.text}\nBirthday: ${text_BD.text}"
    }
    fun reset(v: View){
        edit_name.text.clear()
        edit_pass.text.clear()
        edit_email.text.clear()
        radioGroup.clearCheck()
        text_BD.text = "mm/dd/yy"
        text_show.text = "Show Information"
    }
}