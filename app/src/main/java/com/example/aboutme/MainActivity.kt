package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val myName: MyName = MyName("Taren Lewis")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ///Replace setContentView with Binding set content view
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //This is initializing the XML "myName" variable to the initialized object varaible myName declared at the beginning of MainActivity.
        binding.myName = myName

        /*//This is the original listener for the "Done" button press, to receive the user nickname input and display it.
        findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickname(it)
        }*/
        //This is the improved version of the listener, as a binding
        //This is the listener for the "Done" button press, to receive the user nickname input and display it.
        binding.doneButton.setOnClickListener{
            addNickname(it)
        }

    }

    private fun addNickname (doneButtonView: View){

        //Is the "doneButtonView" view passed as an argument even used??

/*
        //These are the original variable assignments and variable controls. I am leaving these here so that I can learn from the differences between the two
        // and reflect on them when I look back at this code later.
        val editText = findViewById<EditText>(R.id.nickname_edit) // This is an integer(??) ID
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text) // Also an integer I believe

        // This sets the nickname Text to whatever the user has input in the nickname_edit edit text field
        nicknameTextView.text = editText.text

        //Sets the edit text view and done button view to GONE, or invisible (and not taking up space)
        editText.visibility = View.GONE
        doneButtonView.visibility = View.GONE

        //sets the nickname text view with its updated string to visible
        nicknameTextView.visibility = View.VISIBLE
*/


        //This is the updated version of the original variable assignments and view controls
        // Updated assignments with Binding
        binding.apply {

            // This dynamically sets the nickname Text to whatever the user has input in the nickname_edit edit text field
            //nicknameText.text = binding.nicknameEdit.text
            //To initialize the nickname variable of the myName Object created at the beginning of the MainActivity:
            myName?.nickname = nicknameEdit.text.toString()

            //This invalidates current bindings and recreates them with the correct data
            invalidateAll()
            //Make buttons and views disappear
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE

            //sets the nickname text view with its updated string to visible
            nicknameText.visibility = View.VISIBLE
        }


        // hides the keyboard after user presses the done button
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(doneButtonView.windowToken, 0)
    }
}
