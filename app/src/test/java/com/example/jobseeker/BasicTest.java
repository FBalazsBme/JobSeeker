package com.example.jobseeker;


import android.widget.Button;
import android.widget.EditText;

import com.example.jobseeker.network.swagger.client.api.DefaultApi;
import com.example.jobseeker.network.swagger.client.model.Job;
import com.example.jobseeker.ui.main.MainActivity;
import com.example.jobseeker.ui.main.ResultListActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class BasicTest {

    private ActivityController<ResultListActivity> resultListActivityController;
    private ResultListActivity resultListActivity;
    private ActivityController<MainActivity> mainActivityController;
    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception
    {
        mainActivityController = Robolectric.buildActivity( MainActivity.class);
        mainActivity = mainActivityController
                .create()
                .resume()
                .get();
        resultListActivityController = Robolectric.buildActivity( ResultListActivity.class );
        resultListActivity = resultListActivityController
                .create()
                .resume()
                .get();
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( mainActivity );
        assertNotNull( resultListActivity );
    }

    @After
    public void tearDown() throws Exception {
        //use the instance created in setUp() function to close the database
        mainActivityController = mainActivityController.pause().stop().destroy();
        resultListActivityController = resultListActivityController.pause().stop().destroy();
    }

}
