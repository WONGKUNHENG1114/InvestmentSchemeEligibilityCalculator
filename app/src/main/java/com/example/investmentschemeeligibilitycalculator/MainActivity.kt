package com.example.investmentschemeeligibilitycalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val c: Calendar = Calendar.getInstance()
        val tdy:Calendar=Calendar.getInstance()
        var  selectedYear=c.get(Calendar.YEAR)
        var selectedMonth= c.get(Calendar.MONTH)
        var  selectedDay=c.get(Calendar.DAY_OF_MONTH)
        var age :Int

        txtDOB.setOnClickListener {

            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener {
                    view, year, month, dayOfMonth ->
                c.set(year,month,dayOfMonth)
                selectedYear=year
                selectedMonth=month
                selectedDay=dayOfMonth
                txtDOB.setText("%d-%d-%d".format(dayOfMonth,month+1,year))
            }, selectedYear, selectedMonth,selectedDay)

            dpd.show()
        }

         fun  getAge():Int
         {
             age=tdy.get(Calendar.YEAR) -c.get(Calendar.YEAR)
             if(tdy.get(Calendar.DAY_OF_YEAR)<c.get(Calendar.DAY_OF_YEAR))
             {
                 age--
             }
             return age
        }

        btnok.setOnClickListener {
            age=getAge()
            txtage.setText(age.toString())
            when(age)
            {
                in 16..20 ->
                {
                    txtsaving.setText(String.format("RM %.2f",5000.00))
                    txtInvestment.setText(String.format("RM %.2f",5000.00 * 0.3))
                }
                in 21..25->
                {
                    txtsaving.setText(String.format("RM %.2f", 14000.00))
                    txtInvestment.setText(String.format("RM %.2f",14000.00 * 0.3))
                }
                in 26..30->
                {
                    txtsaving.setText(String.format("RM %.2f", 29000.00))
                    txtInvestment.setText(String.format("RM %.2f",29000.00 * 0.3))
                }
                in 31..35->
                {
                    txtsaving.setText(String.format("RM %.2f", 50000.00))
                    txtInvestment.setText(String.format("RM %.2f",50000.00 * 0.3))
                }
                in 36..40->
                {
                    txtsaving.setText(String.format("RM %.2f", 78000.00))
                    txtInvestment.setText(String.format("RM %.2f",78000.00 * 0.3))
                }
                in 41..45->
                {
                    txtsaving.setText(String.format("RM %.2f", 116000.00))
                    txtInvestment.setText(String.format("RM %.2f",116000.00 * 0.3))
                }
                in 46..50->
                {
                    txtsaving.setText(String.format("RM %.2f", 165000.00))
                    txtInvestment.setText(String.format("RM %.2f",165000.00 * 0.3))
                }
                in 51..55->
                {
                    txtsaving.setText(String.format("RM %.2f", 228000.00))
                    txtInvestment.setText(String.format("RM %.2f",228000.00 * 0.3))
                }
                else ->
                {
//                    txtDOB.setText("Please Select a Date that not exceed 55 age")
//                    txtage.setText("")
//                    txtsaving.setText("RM 0.00")
//                    txtInvestment.setText("RM 0.00")
                  val toast= Toast.makeText(applicationContext,"Please Select a Date that not exceed 55 age",Toast.LENGTH_SHORT)
                    toast.show()
                }
            }

        }




        btnreset.setOnClickListener {
            selectedYear=tdy.get(Calendar.YEAR)
             selectedMonth= tdy.get(Calendar.MONTH)
              selectedDay=tdy.get(Calendar.DAY_OF_MONTH)
            txtDOB.setText(R.string.selectDate)
            txtage.text=""
            txtsaving.setText(R.string.result)
            txtInvestment.setText(R.string.result)

        }

    }
}
