package com.example.jobseeker.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.jobseeker.R


class ResultListActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

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

        val ll = layoutInflater.inflate(
            R.layout.result_list_item,
            null,
            true
        ) as LinearLayout

        val ll2 = layoutInflater.inflate(
            R.layout.result_list_item,
            null,
            true
        ) as LinearLayout

        llwrapper.addView(ll)
        llwrapper.addView(ll2)
        sv.addView(llwrapper)
        setContentView(resultsView)


        val toolbar: Toolbar = findViewById(R.id.toolbarresults)
        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.nav_host_fragment)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home,
            R.id.nav_gallery,
            R.id.nav_slideshow
        ), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}