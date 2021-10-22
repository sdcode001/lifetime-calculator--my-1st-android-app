package eu.tutorials.lifetimecalculator
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_dob.setOnClickListener {view ->
            clickdatepicker(view)
        }

        }
    fun clickdatepicker(view: View){
        val mycal=Calendar.getInstance()
        val year_now=mycal.get(Calendar.YEAR)
        val month_now=mycal.get(Calendar.MONTH)
        val day_now=mycal.get(Calendar.DAY_OF_MONTH)
       DatePickerDialog(this,
           DatePickerDialog.OnDateSetListener {view, year, month, day ->
         val date_dob="$day/${month+1}/$year"
         val date_now="$day_now/${month_now+1}/$year_now"
               select_date.setText(date_dob)
               result.setText("")

         val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
         val selected_date=sdf.parse(date_now)
         val date_of_birth=sdf.parse(date_dob)
         val dob_in_second=(date_of_birth!!.time)/1000   //returns total time between 1/1/1970 to dob in seconds
         val seclcted_date_in_second=(selected_date!!.time)/1000   //returns total time between 1/1/1970 to secleted date in seconds  
          val lifetime_seconds=seclcted_date_in_second - dob_in_second
          val lifetime_hours=lifetime_seconds/3600
          val lifetime_days=lifetime_hours/24

          button1.setOnClickListener {
              result.setText(lifetime_seconds.toString()+" Seconds")
          }
          button2.setOnClickListener {
              result.setText(lifetime_hours.toString()+" Hours")
          }
           button3.setOnClickListener {
               result.setText(lifetime_days.toString()+" Days")
           }
       },
           year_now,
           month_now,
           day_now).show()
    }
    }






