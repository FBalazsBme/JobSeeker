package com.example.jobseeker.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.room.Room
import com.example.jobseeker.R
import com.example.jobseeker.database.JobRepository
import com.example.jobseeker.database.RoomJob
import com.example.jobseeker.model.Job
import com.example.jobseeker.ui.home.JobViewModel


class ResultListActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var jobViewModel: JobViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater =
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val resultsView: View = inflater.inflate(R.layout.activity_results, null)

        val sv = resultsView.findViewById(R.id.scrollViewResults) as ScrollView

        val llwrapper = layoutInflater.inflate(
            R.layout.result_list_item_wrapper,
            null,
            true
        ) as LinearLayout

        jobViewModel = ViewModelProvider(this)[JobViewModel::class.java]

        var jobs: List<RoomJob> = jobViewModel.getAllJobs()

        println("jobViewModel created " + jobs.size)

        for(job in jobs) {
            val ll = layoutInflater.inflate(
                R.layout.result_list_item,
                null,
                true
            ) as LinearLayout
            val text1 = TextView(this)
            text1.layoutParams =
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
            text1.textSize = 16.0F
            text1.text = job.title
            ll.addView(text1)
            val text2 = TextView(this)
            text2.layoutParams =
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
            text2.textSize = 16.0F
            text2.text = job.title
            ll.addView(text2)
            llwrapper.addView(ll)
        }


        /*println("first company name from DB is " + jobs!![0].company)*/

        sv.addView(llwrapper)
        setContentView(resultsView)
        val navController = findNavController(R.id.nav_host_fragment_results)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout_results)
        /*appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home,
            R.id.nav_gallery,
            R.id.nav_slideshow
        ), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)*/

    }
}