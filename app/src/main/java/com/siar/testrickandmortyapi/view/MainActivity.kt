package com.siar.testrickandmortyapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.siar.testrickandmortyapi.api.service.ApiService
import com.siar.testrickandmortyapi.databinding.ActivityMainBinding
import com.siar.testrickandmortyapi.viewmodel.PersonageViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dataViewModel: PersonageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataViewModel.personageModel.observe(this, Observer {
            Log.e("DATA", it.body().toString())
        })

        dataViewModel.getAllData()
    }
}

