package com.example.jobseeker.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.jobseeker.R
import com.example.jobseeker.database.RoomJob
import com.example.jobseeker.ui.home.JobViewModel


class ResultPageActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var jobViewModel: JobViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater =
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val detailsView: View = inflater.inflate(R.layout.activity_details, null)
        setContentView(detailsView)
        val mIntent = intent
        val intValue = mIntent.getIntExtra("index", 0)

        jobViewModel = ViewModelProvider(this)[JobViewModel::class.java]

        var jobs: List<RoomJob> = jobViewModel.getAllJobs()

        val toolbarResults =  detailsView.findViewById<TextView>(R.id.toolbarTextresults)
        val toolbarResults2 =  detailsView.findViewById<TextView>(R.id.toolbarTextresults2)
        val toolbarUrl =  detailsView.findViewById<TextView>(R.id.toolbarTextUrl)
        val toolbarEmail =  detailsView.findViewById<TextView>(R.id.toolbarTextemail)

        var jobdesc2 = jobs[intValue].description
            .replace("<p>", "")
            .replace("</p>", "")

        toolbarResults.setText(jobs[intValue].title)
        toolbarResults2.setText(jobdesc2.take(700))
        toolbarUrl.setText(jobs[intValue].companyUrl)

        println("company url is " + jobs[intValue].companyUrl)

        /*println("first company name from DB is " + jobs!![0].company)*/

    }

}