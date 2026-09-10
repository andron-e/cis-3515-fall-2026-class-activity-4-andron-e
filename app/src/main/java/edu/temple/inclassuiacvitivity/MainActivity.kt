package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.*
import android.widget.ArrayAdapter
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* TODO Step 2: Populate this array with multiples of 5 from 5 - 100*/
        //val numberArray = Array Of Numbers
        //val numberArray = (5..100 step 5).toList()
        val numberArray = Array(20) {(it + 1) * 5}
        val exArray = Array(20) {inde -> (inde + 1) * 5}
        val inArray = IntArray(20) {(it + 1) * 5}


        /* TODO Step 3: Create adapter to display items from array in Spinner */
        //spinner.adapter = ArrayAdapter...
        val ArrayAdapter = ArrayAdapter(            // this points at activity (context object)
            this,
            android.R.layout.simple_spinner_item,
            numberArray.asList()
        )
        spinner.adapter = ArrayAdapter

        // TODO Step 4: Change TextView's text size to the number selected in the Spinner */
        //spinner.onItemSelectedListener = object: ...

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                displayTextView.textSize = parent?.getItemAtPosition(position).toString().toFloat()
                // TODO("Not yet implemented")
                // low coupling, high cohesion design (DISL -> AV (spinner) -> (A) -> (D], so how the data is being stored and where is not the listener's concern, long route
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // TODO("Not yet implemented")
            }
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent:AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedSizeString = parent?.getItemAtPosition(position).toString()
                val selectedSizeFloat = selectedSizeString.toFloatOrNull() ?: 16f
                displayTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,selectedSizeFloat)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // TODO("Default state not yet implemented")
            }
        }
    }
}