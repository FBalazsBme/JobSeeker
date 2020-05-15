package com.example.jobseeker.ui.main

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.jobseeker.R
import com.example.jobseeker.database.RoomJob
import com.example.jobseeker.ui.home.JobViewModel


class ResultListActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var jobViewModel: JobViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater =
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val resultsView: View = inflater.inflate(R.layout.activity_results, null)
        setContentView(resultsView)
        val toolbar: Toolbar = findViewById(R.id.toolbarresults)
        setSupportActionBar(toolbar)

        val sv = resultsView.findViewById(R.id.scrollViewResults) as ScrollView



        val llwrapper = layoutInflater.inflate(
            R.layout.result_list_item_wrapper,
            null,
            true
        ) as LinearLayout

        jobViewModel = ViewModelProvider(this)[JobViewModel::class.java]

        var jobs: List<RoomJob> = jobViewModel.getAllJobs()

        println("jobViewModel created " + jobs.size)

        for((index, job) in jobs.withIndex()) {
            val ll = layoutInflater.inflate(
                R.layout.result_list_item,
                null,
                true
            ) as LinearLayout
            ll.setOrientation(LinearLayout.VERTICAL);
            val text1 = TextView(this)
            text1.layoutParams =
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
            text1.textSize = 16.0F
            text1.setTextIsSelectable(false)
            text1.isFocusableInTouchMode = false
            println(job.title)
            text1.setText(job.title)
            text1.setTextColor(Color.BLACK)
            text1.isClickable = false
            ll.addView(text1)
            val text2 = TextView(this)
            text2.layoutParams =
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
            text2.textSize = 16.0F
            text2.setTextIsSelectable(false)
            text2.isFocusableInTouchMode = false
            text2.isClickable = false
            var jobdesc2 = job.description
                .replace("<p>", "")
                .replace("</p>", "")
            text2.text = jobdesc2.take(12) + "..."
            text2.setTextColor(Color.BLACK)
            ll.addView(text2)
            ll.isClickable = true
            ll.setOnClickListener{
                    println("clicked layout")
                    println(index)
                    val myIntent = Intent(this, ResultPageActivity::class.java)
                    myIntent.putExtra("index", index)
                    startActivity(myIntent)
                }
            llwrapper.addView(ll)

        }

        llwrapper.isClickable = false
        llwrapper.setOnClickListener{
            println("clicked layout")
        }


        /*println("first company name from DB is " + jobs!![0].company)*/



        sv.addView(llwrapper)

        val navController = findNavController(R.id.nav_host_fragment_results)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout_results)
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home_results,
            R.id.nav_gallery_results,
            R.id.nav_slideshow_results
        ), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)



    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}