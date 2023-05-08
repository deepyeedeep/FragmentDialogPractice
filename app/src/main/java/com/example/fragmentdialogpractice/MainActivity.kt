package com.example.fragmentdialogpractice

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttAlert = findViewById<Button>(R.id.butt_alert)
        val buttCount = findViewById<Button>(R.id.butt_count)
        val buttRandom = findViewById<Button>(R.id.butt_random)
        val txvCnt = findViewById<TextView>(R.id.txv_count)

        var numCnt = 0
        val dlgCountInit: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity, R.style.Theme_FragmentDialogPractice)
        dlgCountInit.apply {
            setTitle(R.string.frg_title_count_init)
            setMessage(R.string.frg_txt_count_init)
            setPositiveButton(
                R.string.frg_butt_pos,
                DialogInterface.OnClickListener {
                        dialog,
                        which -> run {
                    numCnt = 0
                    txvCnt.text = numCnt.toString()
                } })
            setNeutralButton(
                R.string.frg_butt_neut,
                DialogInterface.OnClickListener{ dialog,
                                                 id -> run {
                    Toast.makeText(applicationContext, R.string.frg_neut_toast, Toast.LENGTH_SHORT ).show()
                }
                })
            setNegativeButton(R.string.frg_butt_neg, DialogInterface.OnClickListener{ dialog, id -> })
        }

        buttAlert.setOnClickListener {
            dlgCountInit.show()
        }

        buttCount.setOnClickListener {
            numCnt++
            txvCnt.text = numCnt.toString()
        }

        val fragmentRandomScreen = FragmentRandom()
        buttRandom.setOnClickListener {
            fragmentRandomScreen.arguments = Bundle().apply{"param1" to numCnt}
            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragment_container_view_random, fragmentRandomScreen)
                    .commit()
            }
        }
    }
}