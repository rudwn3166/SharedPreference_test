package com.example.sharedpreference_test.contextutils

import android.content.Context

class ContextUtils {

    companion object{
//         아래는 메모장의 파일명 같은 개념임
        private val prefName ="TestPref"

//        어떤 항목을 저장할지 항목 이름을 지어줌,자동완성을 활용해 실수를 줄이려고 함
        private val AUTO_LOGIN="AUTO_LOGIN"

//        실제로 저장할 기능과 저장된 값이 무엇인지 확인하는 setter와 getter를 작업

//        setter작업이다,현재 화면에서 값이 저장되었는지 확인하고 값은 돌려주지 않는다
        fun setAutoLogn (context: Context, autoLogin: Boolean){

//    메모장 열어서 pref라는 변수에 저장함,저장되어 있는 값을 얻어옴
            val pref = context.getSharedPreferences(prefName,Context.MODE_PRIVATE)
//    자동로그인 상태 저장
            pref.edit().putBoolean(AUTO_LOGIN,autoLogin).apply()

        }

//        메모장 열고 값이 필요없어서 컨텍스트만 넣음,단 결과 값이 뭐로 내보내야 하는지 확인 해야함
        fun getAutoLogin(context: Context) : Boolean{

    val pref = context.getSharedPreferences(prefName,Context.MODE_PRIVATE)
    return pref.getBoolean(AUTO_LOGIN,false)

        }
    }

}