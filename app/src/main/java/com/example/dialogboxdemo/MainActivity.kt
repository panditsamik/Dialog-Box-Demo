package com.example.dialogboxdemo

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var snackbar = findViewById<Button>(R.id.snackbar)
        var custom = findViewById<Button>(R.id.custom)
        var dialog = findViewById<Button>(R.id.dialog)


        snackbar.setOnClickListener { view ->
            Snackbar.make(view,"This is Snackbar",Snackbar.ANIMATION_MODE_SLIDE).show()
        }

        custom.setOnClickListener { view ->
            alertDialogFunction()
        }

        dialog.setOnClickListener { view->
            val dialogbox = Dialog(this)
            dialogbox.setContentView(R.layout.dialog)
            dialogbox.setTitle("Types of 2 wheelers :")
            val cycle : ImageButton = findViewById(R.id.cycle)
            cycle.setOnClickListener { View.OnClickListener{
                Toast.makeText(applicationContext,"Cycle",Toast.LENGTH_LONG).show()
                dialogbox.dismiss()
            } }
            val scooter : ImageButton = findViewById(R.id.scooter)
            scooter.setOnClickListener { View.OnClickListener{
                Toast.makeText(applicationContext,"Scooter",Toast.LENGTH_LONG).show()
                dialogbox.dismiss()
            } }
            val ebike : ImageButton = findViewById(R.id.ebike)
            ebike.setOnClickListener { View.OnClickListener{
                Toast.makeText(applicationContext,"E-Bike",Toast.LENGTH_LONG).show()
                dialogbox.dismiss()
            } }
            dialogbox.show()
        }
    }

    private fun alertDialogFunction(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
            .setMessage("This is Alert Dialog which is used to show alerts in the App")
            .setIcon(R.drawable.ic_baseline_battery_alert_24)

            .setPositiveButton("Yes"){dialogInterface ,which->
                Toast.makeText(applicationContext,"Clicked Yes",Toast.LENGTH_LONG).show()
                dialogInterface.dismiss()
            }
            .setNeutralButton("OK"){dialogInterface,which ->
                Toast.makeText(applicationContext,"Clicked OK",Toast.LENGTH_LONG).show()
                dialogInterface.dismiss()
            }
            .setNegativeButton("Cancel"){dialogInterface,which ->
                Toast.makeText(applicationContext,"Clicked Cancel",Toast.LENGTH_LONG).show()
                dialogInterface.dismiss()
            }

        val alertdialog : AlertDialog = builder.create()
        alertdialog.setCancelable(true)
        alertdialog.show()
    }
}
