package com.test.viewmodelssavedstate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    // kill background process by command:
    // adb shell am kill com.test.viewmodelssavedstate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.text_view)

        val viewModel = ViewModelProvider(
            this,
            SavedStateViewModelFactory(application, this)
        ).get(MainViewModel::class.java)

        button.setOnClickListener {
            viewModel.setNewText("Button clicked")
        }

        viewModel.text.observe(this) {
            textView.text = it
        }
    }
}