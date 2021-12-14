package com.example.numberguessinggame

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import kotlinx.android.synthetic.main.activity_preferences.*



// Preferences allows the user to view wins and change the difficulty
class PreferencesActivity : AppCompatActivity() {
    var diff = 0
    var file = "diff_file"
    val PREF_Name="myPrefs"
    var myPref: SharedPreferences?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)
    }

    // gets state of radio button
    override fun onStart() {
        super.onStart()
        var databack: SharedPreferences = getSharedPreferences(PREF_Name, 0)
        databack = getSharedPreferences(PREF_Name, 0)
        if (databack.contains("difficulty")) {
            easyB.isChecked = true
            diff = 25
        }

    }

    // Goes to main
    fun goToMain(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("difficulty", diff)
        startActivity(intent)
    }

    // Goes to game
    fun goToGame(view: View?) {
        val intent = Intent(this, SecondaryActivity::class.java)
        intent.putExtra("difficulty", diff)
        startActivity(intent)
    }

    // Goes to preferences
    fun goToPreferences(view: View?) {
        val intent = Intent(this, PreferencesActivity::class.java)
        intent.putExtra("difficulty", diff)
        startActivity(intent)
    }

    // Goes to help
    fun goToHelp(view: View?) {
        val intent = Intent(this, HelpActivity::class.java)
        intent.putExtra("difficulty", diff)
        startActivity(intent)
    }

    // Changes the difficulty of the game
    fun changeDifficulty(view: View?) {

        when {
            easyB.isChecked -> diff = 25
            normalB.isChecked -> diff = 50
            hardB.isChecked -> diff = 100
        }

    }

    // Saves the difficulty of the game
    fun saveChanges(view: View?) {
        if (easyB.isChecked) {
            myPref = getSharedPreferences(PREF_Name, 0)
            var editor: SharedPreferences.Editor = (myPref as SharedPreferences).edit()
            if (!TextUtils.isEmpty(diff.toString())) {
                //save key-value pair newHighScore and its value
                editor.putString("difficulty", diff.toString())
                editor.commit()
            }
        }
        else if (normalB.isChecked) {
            myPref = getSharedPreferences(PREF_Name, 0)
            var editor: SharedPreferences.Editor = (myPref as SharedPreferences).edit()
            if (!TextUtils.isEmpty(diff.toString())) {
                //save key-value pair newHighScore and its value
                editor.putString("difficulty", diff.toString())
                editor.commit()
            }
        }
        else if (hardB.isChecked) {
            myPref = getSharedPreferences(PREF_Name, 0)
            var editor: SharedPreferences.Editor = (myPref as SharedPreferences).edit()
            if (!TextUtils.isEmpty(diff.toString())) {
                //save key-value pair newHighScore and its value
                editor.putString("difficulty", diff.toString())
                editor.commit()
            }

        }

        // sends the max value to the game
        val intent = Intent(this, SecondaryActivity::class.java)
        intent.putExtra("difficulty", diff)
        startActivity(intent)
    }

}




