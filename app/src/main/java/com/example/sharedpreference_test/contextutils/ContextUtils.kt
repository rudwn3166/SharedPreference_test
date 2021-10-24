package com.example.sharedpreference_test.contextutils

import android.content.Context

class ContextUtils {

/*  companion object를 사용하게 되면 메인액티비티에서
*   val main = ContextUtils()
*   main.prefName이런식으로 사용하던 것을
*   클래스인 ContextUtils자체를 가져와 해당 클래스의 기능을 바로 사용할 수 있다
*   ContextUtils.prefName이렇게 사용가능함
*
*  */
    companion object{
//         아래는 메모장의 파일명 같은 개념임
        private val prefName ="TestPref"
        private val saveId = "saveId"

//        어떤 항목을 저장할지 항목 이름을 지어줌,자동완성을 활용해 실수를 줄이려고 함
        private val AUTO_LOGIN="AUTO_LOGIN"
        private val SAVE_ID="SAVE_ID"

//        실제로 저장할 기능과 저장된 값이 무엇인지 확인하는 setter와 getter를 작업


        fun setSaveId(context: Context,value: String){

            val saveid = context.getSharedPreferences(saveId,Context.MODE_PRIVATE)

            saveid.edit().putString(SAVE_ID,value).apply()
        }

        fun getSaveId(context: Context){

            val readid =context.getSharedPreferences(SAVE_ID,Context.MODE_PRIVATE)


        }



//        setter작업이다,현재 화면에서 값이 저장되었는지 확인하고 값은 저장되었는지 안되었는지 확인하기 위해 불린사용
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