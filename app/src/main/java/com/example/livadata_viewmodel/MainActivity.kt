package com.example.livadata_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.livadata_viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() ,View.OnClickListener{
    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var myNumberViewModel : MyNumberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)
        myNumberViewModel.currentValue.observe(this,{
            Log.d("로그","변화")
            activityMainBinding.numberTextview.text = it.toString()
        })
        activityMainBinding.plusBtn.setOnClickListener(this)
        activityMainBinding.minusBtn.setOnClickListener(this)
    }
    override fun onClick(view : View?){
        val userInput = activityMainBinding.userinputEdittext.text.toString().toInt()
        when(view){
            activityMainBinding.plusBtn ->
                myNumberViewModel.updateValue(actionType = ActionType.PLUS,userInput)
            activityMainBinding.minusBtn ->
                myNumberViewModel.updateValue(actionType = ActionType.MINUS,userInput)
        }
    }
}