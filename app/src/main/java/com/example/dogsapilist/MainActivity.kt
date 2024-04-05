package com.example.dogsapilist

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import com.example.dogsapilist.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, DogsApiList.newInstance())
            .commit()

    }
}

