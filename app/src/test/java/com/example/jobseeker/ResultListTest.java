package com.example.jobseeker;


import android.content.ComponentName;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import com.example.jobseeker.database.RoomJob;
import com.example.jobseeker.ui.home.JobViewModel;
import com.example.jobseeker.ui.main.MainActivity;
import com.example.jobseeker.ui.main.ResultListActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
public class ResultListTest {

    private ResultListActivity resultListActivity;
    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception
    {
        mainActivity = Robolectric.buildActivity( MainActivity.class )
                .create()
                .resume()
                .get();
    }

    @Test
    public void allTests() throws Exception
    {
        System.out.println("alltests called");

        EditText keyword = (EditText)mainActivity.findViewById(R.id.job_keyword);
        EditText location = (EditText)mainActivity.findViewById(R.id.location);
        Button buttonSearch=(Button)mainActivity.findViewById(R.id.search_button);
        keyword.requestFocus();
        keyword.setText("python");
        location.requestFocus();
        location.setText("sf");
        assertNotNull(buttonSearch); // will pass test ( ---> the view is a button and exists )
        assertTrue(buttonSearch.performClick());
    }

}
