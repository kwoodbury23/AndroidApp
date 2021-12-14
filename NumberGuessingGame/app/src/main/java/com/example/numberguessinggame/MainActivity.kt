package com.example.numberguessinggame


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.numberguessinggame.ui.login.LoginFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_preferences.*
import kotlinx.android.synthetic.main.activity_secondary.*
import kotlinx.android.synthetic.main.fragment_login.*
import java.io.FileOutputStream
import java.lang.Exception


// This program allows the user to enter a name for the game
class MainActivity : AppCompatActivity() {
    var file = "welcome_file"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Load the user's number of wins
        btnLoadName.setOnClickListener{
            try {
                val fin = openFileInput(file)
                var temp=""
                var bytes:ByteArray = fin.readBytes()

                for(byte in bytes){
                    temp +=byte.toChar()
                }
                editName.setText(temp)
            }
            catch (e: Exception){
                e.printStackTrace()
            }
        }

    }


    // Allows the user to go to the second activity
    fun sendMessage(view: View?) {
        try {
            var fOut: FileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fOut.write(editName.text.toString().toByteArray(Charsets.UTF_8))
            fOut.close()
        }
        catch (e: Exception){
            e.printStackTrace()
        }
        val intent = Intent(this, SecondaryActivity::class.java)
        // Allows the second activity to display user's name
        intent.putExtra("name", editName.text.toString())
        startActivity(intent)
    }

    // Goes to main
    fun goToMain(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    // Goes to game
    fun goToGame(view: View?) {
        val intent = Intent(this, SecondaryActivity::class.java)
        startActivity(intent)
    }

    // Goes to preferences
    fun goToPreferences(view: View?) {
        val intent = Intent(this, PreferencesActivity::class.java)
        startActivity(intent)
    }

    // Goes to help
    fun goToHelp(view: View?) {
        val intent = Intent(this, HelpActivity::class.java)
        startActivity(intent)
    }

}