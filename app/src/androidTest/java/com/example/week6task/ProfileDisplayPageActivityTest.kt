package com.example.week6task

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ProfileDisplayPageActivityTest{

    @get:Rule
    val activityRule = ActivityScenarioRule(ProfileDisplayPageActivity::class.java)

    /** Test to verify activity is displayed*/
    @Test
    fun test_profileDisplayActivityInView() {
        onView(withId(R.id.profileDisplayActivity)).check(matches(isDisplayed()))
    }

    /** Test to verify background card view and profile image is displayed*/
    @Test
    fun test_backgroundView_cardView_profileImageIsDisplayed() {
        onView(withId(R.id.view)).check(matches(isDisplayed()))

        onView(withId(R.id.cardView)).check(matches(isDisplayed()))

        onView(withId(R.id.ivProfilePicture)).check(matches(isDisplayed()))
    }


    /** Test to verify all text views are displayed*/
    @Test
    fun test_textViewsDisplayed() {
        onView(withId(R.id.tvName)).check(matches(isDisplayed()))

        onView(withId(R.id.tvEmail)).check(matches(isDisplayed()))

        onView(withId(R.id.tvPhoneNumber)).check(matches(isDisplayed()))

        onView(withId(R.id.tvSex)).check(matches(isDisplayed()))
    }

    /**Test to verify sexes icon is displayed*/
    @Test
    fun test_sexesImageIcon() {
        onView(withId(R.id.profileSexesIcon)).check(matches(isDisplayed()))
    }



}