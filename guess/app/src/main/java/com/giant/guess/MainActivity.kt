package com.giant.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val secretNumber = SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun check(view: View) {
        val n = ed_number.text.toString().toInt()
        val diff = secretNumber.validate(n)
        var message = getString(R.string.yes_you_got_it)
        if (diff > 0) {
            message = getString(R.string.smaller)
        } else if (diff < 0) {
            message = getString(R.string.bigger)
        }
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.message))
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}
