package com.example.week6task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    private lateinit var wrongInputAnimation:Animation
    private lateinit var name:String
    private lateinit var email:String
    private lateinit var sex: String
    private lateinit var phoneNumber:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** Put the xml animation into a variable */
        wrongInputAnimation = AnimationUtils.loadAnimation(this,R.anim.shake)

        /** Setting on click listener for the sexes spinner  */
        spSexes.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                sex = adapterView?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //Nothing to do here
            }
        }

        /** Setting a click listener for the register button */
        btnRegister.setOnClickListener {
            validateInput()
        }


    }

    /** Function to validate the input of the user*/
     fun validateInput(){
        name = etName.text.toString()
        email = etMail.text.toString()
        phoneNumber = etPhone.text.toString()

        if(!validateName(name)) invalidInput(etName)
        if(!validateEmail(email)) invalidInput(etMail)
        if(!validatePhoneNumber(phoneNumber)) invalidInput(etPhone)

        if (validateName(name) && validateEmail(email) && validatePhoneNumber(phoneNumber) ){
            beginProfileActivity()
        }
    }

    /** Function to animate a view that has an invalid input*/
     fun invalidInput(view: View){
        view.startAnimation(wrongInputAnimation)
        view.setBackgroundResource(R.drawable.wrong_input)
        view.clearFocus()
        view.setOnFocusChangeListener { view, bool ->
            if(bool) view.setBackgroundResource(R.drawable.edit_text_states)
        }
    }

    /** Function to go to begin profile display activity */
     fun beginProfileActivity(){
        Intent(this,ProfileDisplayPageActivity::class.java).also {
            it.putExtra("NAME",name)
            it.putExtra("EMAIL",email)
            it.putExtra("PHONE_NO",phoneNumber)
            it.putExtra("SEX",sex)
            startActivity(it)
            etMail.text.clear()
            etName.text.clear()
            etPhone.text.clear()
        }
    }


    /** Function to validate phone number */
     fun validatePhoneNumber(phoneNumber:String):Boolean{
        val pattern1 = "^0".toRegex()
        val pattern2 = "^\\+234|^234".toRegex()
        val matchesPattern1 = pattern1.containsMatchIn(phoneNumber)
        val matchesPattern2 = pattern2.containsMatchIn(phoneNumber)

        when{
            matchesPattern1 && phoneNumber.length==11 -> return true
            matchesPattern2 && (phoneNumber.length==13|| phoneNumber.length==14) -> return true
        }
        return false
    }

    /** Function to validate name */
     fun validateName(name:String):Boolean{
        if(name.isEmpty())return false
        return true
    }

    /** Function to validate email */
     fun validateEmail(email : String):Boolean{
         var pattern: Pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})\$");
         var matcher: Matcher = pattern.matcher(email);
         val matchFound = matcher.matches()
         if(matchFound)return true
         return false
    }

}