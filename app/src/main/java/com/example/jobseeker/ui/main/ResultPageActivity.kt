package com.example.jobseeker.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
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

        val detailsView


        /*println("first company name from DB is " + jobs!![0].company)*/

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