package com.example.livadata_viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType{
    PLUS,MINUS
}

class MyNumberViewModel : ViewModel(){
    // 라이브데이터는 변경가능한 뮤터블과 변경 불가능한 일반 라이브데이터(읽기전용) 이 존재함
    private val _currentValue = MutableLiveData<Int>()
    val currentValue: LiveData<Int>
        get() = _currentValue
    init{
        Log.d("로그","넘버뷰모델 생성")
        _currentValue.value = 0
    }

    fun updateValue(actionType : ActionType, input : Int){
        when(actionType){
            ActionType.PLUS ->
                _currentValue.value = _currentValue.value?.plus(input)
            ActionType.MINUS ->
                _currentValue.value = _currentValue.value?.minus(input)
        }
    }
}