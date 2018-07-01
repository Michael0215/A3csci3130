package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;

public class espresso {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void createTest(){
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText("CaptainHuang"));
        onView(withId(R.id.email)).perform(typeText("CaptainHuang@dal.ca"));
        onView(withId(R.id.P)).perform(typeText("NS"),closeSoftKeyboard());
        onView(withId(R.id.BN)).perform(typeText("666666666"));
        onView(withId(R.id.PB)).perform(typeText("Fisher"),closeSoftKeyboard());
        onView(withId(R.id.Ad)).perform(typeText("1333 South Park St"),closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());

    }

}
