package com.example.dealsapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dealsapp.Card
import android.content.Context
import android.util.Log
import com.example.dealsapp.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    //To Populate static values from Code
   /* val dealList = listOf(
        Card("Deal 1", "Description for Deal 1"),
        Card("Deal 2", "Description for Deal 2"),
        Card("Deal 3", "Description for Deal 3")
    )*/

    private val jsonFileName = "deals_list.json"
     lateinit var deals :List<Card>
    fun getDealsList(context:Context) {
        val utils = Utils()
        val jsonFileString = utils.getJsonDataFromAsset(context,jsonFileName)
        if (jsonFileString != null) {
            Log.i("data",jsonFileString)
        }

        val gson = Gson()
        val dealList = object : TypeToken<List<Card>>() {}.type

        deals = gson.fromJson(jsonFileString, dealList)

        deals.forEachIndexed { idx, deals -> Log.i("data", "> Item $idx:\n$deals") }
         }

}