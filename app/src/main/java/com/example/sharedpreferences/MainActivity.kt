package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val EXAMPLE_PREFERENCES = "example_preferences"
const val EDIT_TEXT_KEY = "key_for_edit_text"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefs = getSharedPreferences(EXAMPLE_PREFERENCES, MODE_PRIVATE)
        val restoreButton = findViewById<Button>(R.id.restoreButton)

        val editText = findViewById<EditText>(R.id.editText)
        val saveButton = findViewById<Button>(R.id.saveButton)


        editText.setText(sharedPrefs.getString(EDIT_TEXT_KEY, ""))

        saveButton.setOnClickListener {
            sharedPrefs.edit()
                .putString(EDIT_TEXT_KEY, editText.editableText.toString())
                .apply()

            Toast.makeText(this, "Сохранили значение ${editText.editableText}", Toast.LENGTH_SHORT)
                .show()
        }
        restoreButton.setOnClickListener {
            editText.setText(sharedPrefs.getString(EDIT_TEXT_KEY, ""))
        }
    }
    }