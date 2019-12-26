package com.example.investmentschemeeligibilitycalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val c: Calendar = Calendar.getInstance()
        val  tdy_Year = c.get(Calendar.YEAR)
        val tdy_Month = c.get(Calendar.MONTH)
        val  tdy_Day = c.get(Calendar.DAY_OF_MONTH)
        var age : Int = 0

        txtDOB.setOnClickListener {

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                    view, year, monthOfYear, dayOfMonth ->
                //Display Selected date in TextView
                txtDOB.setText("%d-%d-%d".format(dayOfMonth,monthOfYear+1,year))

                age =  tdy_Year - year
                txtage.setText(age.toString())
            }, tdy_Year, tdy_Month, tdy_Day)
            dpd.show()
        }

        btnok.setOnClickListener {
            val minSaving: Double
            val total: Double
            if(age >= 16 && age <= 20){
                minSaving = 5000.0
                total = minSaving * 0.3
                txtsaving.setText("RM " + minSaving)
                txtInvestment.setText("RM " + total)

            } else if (age >= 21 && age <= 25){
                minSaving = 14000.0
                total = minSaving * 0.3
                txtsaving.setText("RM " + minSaving)
                txtInvestment.setText("RM " + total)

            } else if (age >= 26 && age <= 30) {
                minSaving = 29000.0
                total = minSaving * 0.3
                txtsaving.setText("RM " + minSaving)
                txtInvestment.setText("RM " + total)

            } else if (age >= 31 && age <= 35) {
                minSaving = 50000.0
                total = minSaving * 0.3
                txtsaving.setText("RM " + minSaving)
                txtInvestment.setText("RM " + total)

            } else if (age >= 36 && age <= 40) {
                minSaving = 78000.0
                total = minSaving * 0.3
                txtsaving.setText("RM " + minSaving)
                txtInvestment.setText("RM " + total)

            } else if (age >= 41 && age <= 45) {
                minSaving = 116000.0
                total = minSaving * 0.3
                txtsaving.setText("RM " + minSaving)
                txtInvestment.setText("RM " + total)

            } else if (age >= 46 && age <= 50) {
                minSaving = 165000.0
                total = minSaving * 0.3
                txtsaving.setText("RM " + minSaving)
                txtInvestment.setText("RM " + total)

            } else if (age >= 51 && age <= 55) {
                minSaving = 228000.0
                total = minSaving * 0.3
                txtsaving.setText("RM " + minSaving)
                txtInvestment.setText("RM " + total)
            } else {
                txtDOB.setText("Please Select a Date")
                txtage.setText("")
                txtsaving.setText("RM 0.00")
                txtInvestment.setText("RM 0.00")
            }
        }




        btnreset.setOnClickListener {
            txtDOB.setText("Please Select a Date")
            txtage.setText("")
            txtsaving.setText("RM 0.00")
            txtInvestment.setText("RM 0.00")

        }

    }
}
