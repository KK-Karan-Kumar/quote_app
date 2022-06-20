package com.example.quotes_app

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import kotlin.math.log

class MainViewModel(val context: Context) : ViewModel() {
    private  var quoteList : Array<quote> = emptyArray()
    private var index = 0

    init {
        quoteList  = loadquote()
    }

    private fun loadquote(): Array<quote> {
val inputStrem = context.assets.open("quotes.json")
        val size = inputStrem.available()
        var buffer = ByteArray(size)
        inputStrem.read(buffer)
       inputStrem.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()

        return gson.fromJson(json,Array<quote>::class.java)
    }

    fun getQuote() = quoteList[index]

    fun nexQuote(): quote {
        Log.v(TAG,index.toString() + " " + quoteList.size.toString())
        if(quoteList.size-1 > index) {
            return quoteList[++index]
        }else{
            return quoteList[index]
        }
    }

    fun preQuote(): quote {
        if(0<index){ return quoteList[--index]}else{
            return quoteList[index]
        }
    }

    fun getind() = index
//
//    fun getnexind ():Int {
//        if(quoteList.size-1 > index) {
//            return ++index
//        }else{
//            return index
//        }
//    }
//
//    fun getpreind():Int {
//        if(0<index){
//            return  --index
//        }
//        else{
//            return index
//        }
//    }
    fun getLen():Int{
        return quoteList.size
    }
}