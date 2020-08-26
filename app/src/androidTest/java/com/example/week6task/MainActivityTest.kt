package com.example.week6task

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.core.IsAnything.anything
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.core.AllOf.allOf


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    private val name = "Omu David"
    private val email = "omudavid@gmail.com"
    private val phone = "08038491002"
    private val sex = "Male"
    private val packageName = "com.example.week6task"

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    /** Test to verify the activity layout is displayed */
    @Test
    fun test_mainActivityInView() {

        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()))
    }

    /** Test to verify all edit texts are  displayed */
    @Test
    fun test_EditTextDisplayed() {
        onView(withId(R.id.etName)).check(matches(isDisplayed()))

        onView(withId(R.id.etMail)).check(matches(isDisplayed()))

        onView(withId(R.id.etPhone)).check(matches(isDisplayed()))
    }

    /** Test to verify spinner, register button and banner image views are  displayed */
    @Test
    fun test_spinner_imageIsDisplayed() {
        onView(withId(R.id.spSexes)).check(matches(isDisplayed()))

        onView(withId(R.id.btnRegister)).check(matches(isDisplayed()))

        onView(withId(R.id.ivBackgroundImage)).check(matches(isDisplayed()))
    }

    /** Test to verify the sexes icon is  displayed */
    @Test
    fun test_sexesIcon_HeaderDisplayed() {
        onView(withId(R.id.mainSexesIcon)).check(matches(isDisplayed()))
        onView(withId(R.id.tvHeader)).check(matches(isDisplayed()))

    }

    /** Test to verify header text view and button view display the expected text */
    @Test
    fun test_header_ButtonTextDisplayed() {
        onView(withId(R.id.tvHeader)).check(matches(withText(R.string.joinUs)))

        onView(withId(R.id.btnRegister)).check(matches(withText(R.string.register)))
    }

    /** Test to verify the edit texts display the expected texts */
    @Test
    fun test_textViewsShowCorrespondingHint() {
        onView(withId(R.id.etName)).check(matches(withHint(R.string.name)))

        onView(withId(R.id.etMail)).check(matches(withHint(R.string.email)))

        onView(withId(R.id.etPhone)).check(matches(withHint(R.string.phone)))
    }

    @get:Rule
    val intentTestRule = IntentsTestRule(MainActivity::class.java)

    /** Test to verify the activity passes the expected extra to the profile display activity */
    @Test
    fun test_verifyDataPassedToNextActivity() {
        onView(withId(R.id.etName)).perform(typeText(name), closeSoftKeyboard())

        onView(withId(R.id.etMail)).perform(typeText(email), closeSoftKeyboard())

        onView(withId(R.id.etPhone)).perform(typeText(phone), closeSoftKeyboard())

        onView(withId(R.id.spSexes)).perform(click())
        onData(anything()).atPosition(0).perform(click())

        onView(withId(R.id.btnRegister)).perform(click())

        intended(
            allOf(
                hasComponent(hasShortClassName(".ProfileDisplayPageActivity")),
                toPackage("com.example.week6task"),hasExtra("NAME",name)
            )
        )
        intended(
            allOf(
                hasComponent(hasShortClassName(".ProfileDisplayPageActivity")),
                toPackage("com.example.week6task"),hasExtra("EMAIL",email)
            )
        )

        intended(
            allOf(
                hasComponent(hasShortClassName(".ProfileDisplayPageActivity")),
                toPackage("com.example.week6task"),hasExtra("PHONE_NO",phone)
            )
        )

        intended(
            allOf(
                hasComponent(hasShortClassName(".ProfileDisplayPageActivity")),
                toPackage("com.example.week6task"),hasExtra("SEX",sex)
            )
        )




    }

    /** Test to verify the navigation from the main activity to the profile activity */
    @Test
    fun test_navigation() {
        onView(withId(R.id.etName)).perform(typeText("Omu David"), closeSoftKeyboard())

        onView(withId(R.id.etMail)).perform(typeText("omudavid@gmail.com"), closeSoftKeyboard())

        onView(withId(R.id.etPhone)).perform(typeText("07013024711"), closeSoftKeyboard())

        onView(withId(R.id.btnRegister)).perform(click())

        onView(withId(R.id.profileDisplayActivity)).check(matches(isDisplayed()))

    }
}