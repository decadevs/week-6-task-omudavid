package com.example.week6task

import org.junit.Test

import org.junit.Assert.*

class MainActivityUnitTest {

    private val mainActivity = MainActivity()

    /** Tests to verify validatePhoneNumber() */
    @Test
    fun test1_ValidatePhoneNumber() {
        assertEquals(mainActivity.validatePhoneNumber("08038491004"),true)
    }

    @Test
    fun test2_ValidatePhoneNumber() {
        assertEquals(mainActivity.validatePhoneNumber("080384910067"),false)
    }

    @Test
    fun test3_ValidatePhoneNumber() {
        assertEquals(mainActivity.validatePhoneNumber("+2348038491004"),true)
    }

    @Test
    fun test4_ValidatePhoneNumber() {
        assertEquals(mainActivity.validatePhoneNumber("07013024711"),true)
    }


    @Test
    fun test5_ValidatePhoneNumber() {
        assertEquals(mainActivity.validatePhoneNumber("6464728929"),false)
    }

    @Test
    fun test6_ValidatePhoneNumber() {
        assertEquals(mainActivity.validatePhoneNumber("04948472281"),true)
    }

    /** Tests to verify validateName() */
    @Test
    fun test1_NameNotEmpty() {
        assertEquals(mainActivity.validateName(""),false)
    }

    @Test
    fun test2_NameNotEmpty() {
        assertEquals(mainActivity.validateName("JACK"),true)
    }

    /** Test to verify validateEmail */
    @Test
    fun test1_validateEmail() {
        assertEquals(mainActivity.validateEmail("omudavid@gmail.com"),true)
    }
}