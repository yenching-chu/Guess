package com.giant.guess

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_material.*
import kotlinx.android.synthetic.main.content_material.*

class MaterialActivity : AppCompatActivity() {

    val secretNumber = SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.replay_game))
                .setMessage(getString(R.string.are_you_sure))
                .setPositiveButton(getString(R.string.ok)) { _, _ ->
                    secretNumber.reset()
                    ed_number.setText("")
                }
                .setNeutralButton(getString(R.string.cancel), null)
                .show()
        }
    }

    fun check(view: View) {
        val n = ed_number.text.toString().toInt()
        val diff = secretNumber.validate(n)
        val times = secretNumber.count
        var message = getString(R.string.yes_you_got_it)
        if (diff > 0) {
            message = getString(R.string.smaller)
        } else if (diff < 0) {
            message = getString(R.string.bigger)
        } else if (diff == 0 && times < 3) {
            message = getString(R.string.excellent) + n
        }
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.message))
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}
