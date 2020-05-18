package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickname(it)
        }

    }

    private fun addNickname (doneButtonView: View){
        val editText = findViewById<EditText>(R.id.nickname_edit) // This is an integer(??) ID
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text) // Also an integer I believe

        // This sets the nickname Text to whatever the user has input in the nickname_edit edit text field
        nicknameTextView.text = editText.text

        //Sets the edit text view and done button view to GONE, or invisible (and not taking up space)
        editText.visibility = View.GONE
        doneButtonView.visibility = View.GONE

        //sets the nickname text view with its updated string to visible
        nicknameTextView.visibility = View.VISIBLE


        // hides the keyboard after user presses the done button
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(doneButtonView.windowToken, 0)

    }

}
