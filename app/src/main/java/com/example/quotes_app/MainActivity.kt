package com.example.quotes_app

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    public  val quoteText : TextView get() =  findViewById(R.id.textView2)
    public val nexBtn : Button get()  = findViewById(R.id.button2)
    public val preBtn : Button get() = findViewById(R.id.button)

    public  val index : TextView get() = findViewById(R.id.textView3)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(application)).get(MainViewModel::class.java)

        setQuote(mainViewModel.getQuote())
        setInd(mainViewModel.getind())

        nexBtn.setOnClickListener(){
            setQuote(mainViewModel.nexQuote())
            setInd(mainViewModel.getind())

        }

        preBtn.setOnClickListener(){
            setQuote(mainViewModel.preQuote())
            setInd(mainViewModel.getind())
        }


    }


    fun setQuote(quote: quote){
        quoteText.text = quote.desc
    }
    fun setInd(ind:Int){
        index.text = (ind+1).toString() + "/" + mainViewModel.getLen().toString()
    }
}