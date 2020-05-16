package com.example.jobseeker.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.jobseeker.R
import com.example.jobseeker.database.JobRepository
import com.example.jobseeker.database.RoomJob
import com.example.jobseeker.database.RoomJobDatabase
import com.example.jobseeker.network.swagger.client.ApiException
import com.example.jobseeker.network.swagger.client.api.DefaultApi
import com.example.jobseeker.network.swagger.client.model.Job
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    public lateinit var jobs : List<Job>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val jobText: EditText = findViewById(R.id.job_keyword);
        val locationText = findViewById<EditText>(R.id.location);


        val defaultApi: DefaultApi = DefaultApi()

        val button: Button = findViewById<View>(R.id.search_button) as Button

        jobText.setOnClickListener{view ->
            println("job Text set")
        }

        button.setOnClickListener {
            println("Button pressed")

            println(jobText.getText().toString())
            println(locationText.getText().toString())

/*            Thread(Runnable {
                val roomJobDatabase = RoomJobDatabase.getInstance(this)

                roomJobDatabase.roomJobDao().addJob(RoomJob(
                    "id",
                    "type",
                    "url",
                    Date(2018,10,12),
                    "Ceg",
                    "www.google.com",
                    "Budapest",
                    "Angular",
                    "leiras",
                    "palyazas",
                    "cegLogo"
                ))

                val jobs = roomJobDatabase.roomJobDao().getAllJobs()

                println(jobs[0].company)
            }).start()*/



            Thread(Runnable {
                try {
                    //val jobs : List<Job> = defaultApi.positionsJsonGet(true, "python", "sf")

                    println("thread started")
                    val roomJobDatabase = RoomJobDatabase.getInstance(this)

                    roomJobDatabase.roomJobDao().clearTable()

                    println("Before network call")

                    jobs = defaultApi.positionsJsonGet(true,
                        jobText.getText().toString(), locationText.getText().toString())

                    println("first company name is " + jobs[0].company)

                    for(job in jobs) {
                        roomJobDatabase.roomJobDao().addJob(RoomJob(
                            job.id,
                            job.type,
                            job.url,
                            job.createdAt,
                            job.company,
                            job.companyUrl,
                            job.location,
                            job.title,
                            job.description,
                            job.howToApply
                        ))

                        JobRepository(this.application)

                    }
                    val i = Intent(this, ResultListActivity::class.java)
                    startActivity(i)
                }
                catch(apiE: ApiException) {
                    Toast.makeText(this, "This is my Toast message!",
                        Toast.LENGTH_LONG).show();
                }

            }).start()


        }


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home,
            R.id.nav_gallery,
            R.id.nav_slideshow
        ), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
/*        navView.setupWithNavController(navController)
        search_button.setOnClickListener { mainPresenter.showArtistsSearchList(etArtist.text.toString()) }*/

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
