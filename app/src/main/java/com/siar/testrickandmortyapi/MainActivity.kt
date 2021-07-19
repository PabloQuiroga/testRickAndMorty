package com.siar.testrickandmortyapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.siar.testrickandmortyapi.api.RickAndMortyApi
import com.siar.testrickandmortyapi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        getAll()
    }

    private fun getAll(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = retrofit.create(RickAndMortyApi::class.java).getAllCharacters()
            val personages = call.body()
            if(call.isSuccessful){
                Log.e("SUCCESS", call.body().toString())
            }else{
                Log.e("ERROR", call.errorBody().toString())
            }
        }
    }
}