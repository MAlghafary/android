package com.example.motivateme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var name : EditText
    private lateinit var message : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get a refereance to the button and add click listener
        val updateButton : Button = findViewById(R.id.main_activity_bt_update)
        updateButton.setOnClickListener { updateMessage() }

        name = findViewById(R.id.main_activity_et_name);
        message = findViewById(R.id.main_activity_tv_motivation_text);
    }

    private fun updateMessage(){
        val userName = name.text
        val motivationMessages = listOf("Keep it up","Never give up","Get it done");
        val index = (0..4).random();
        val motivationMessag = motivationMessages[index]

        if(userName.toString() == ""){
            message.text = "Make sure to enter your name"
        } else {
            message.text = "Hello $userName , $motivationMessag"
        }

        name.setText("")

        hideKeyboard()
    }

    private fun hideKeyboard(){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager;
        imm.hideSoftInputFromWindow(name.windowToken,0);
    }
}