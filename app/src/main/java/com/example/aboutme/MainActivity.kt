package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aleks Haecky")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
//        val donebtn: Button = findViewById(R.id.done_button)
        val ne: TextView = findViewById(R.id.nickname_edit)
        val nt: TextView = findViewById(R.id.nickname_text)

        binding.doneButton.setOnClickListener() {
            addNickname(it)
            binding.nicknameText.text = binding.nicknameEdit.text


//            addNickname(it)
//            nt.text = ne.text
//            ne.visibility = View.GONE
//            donebtn.visibility = View.GONE
//            nt.visibility = View.VISIBLE   //old one

        }

//        binding.nicknameText.setOnClickListener(){
//            binding.nicknameEdit.visibility = View.VISIBLE
//            binding.doneButton.visibility = View.VISIBLE
//            binding.nicknameText.visibility = View.GONE
//
//        } fail
        nt.setOnClickListener(){
            ne.text = nt.text
            ne.visibility = View.VISIBLE
            binding.doneButton.visibility = View.VISIBLE
            nt.visibility = View.GONE
            updateNickname(it)

        }
    }

   private fun addNickname(it: View?) {
       binding.apply {
           myName?.nickname = nicknameEdit.text.toString()
           invalidateAll()
           nicknameEdit.visibility = View.GONE
           doneButton.visibility = View.GONE
           nicknameText.visibility = View.VISIBLE
       }
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(it?.windowToken,0)
    }

    private fun updateNickname(it: View?) {
        val ne: EditText = findViewById(R.id.nickname_edit)
        ne.requestFocus()
        ne.setSelection(ne.length())

        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        /* this can work too
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(ne, 0) //ne = nickname_edit
        */

    }
}

