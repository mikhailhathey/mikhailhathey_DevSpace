package com.mikhailhathey.devspace;

import android.app.Instrumentation;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class CalcFragmentTest {

    /*@Rule
    public IntentsTestRule<Calculation> calculationIntentsRule
            = new IntentsTestRule<>(CalcFragment.class);*/

    @Test
    public void BackButton()
    {
       /* //Monitor activity after button is clicked
        Instrumentation.ActivityMonitor activity = getInstrumentation().addMonitor(MenuFragment.class.getName(), null, true);

        //Click button
        onView(withId(R.id.calcBackBtn))
                .perform(click());

        //Wait for activity
        activity.waitForActivityWithTimeout(5);

        //Test if MainActivity activity is opened
        assertEquals(1, activity.getHits());*/
    }
}