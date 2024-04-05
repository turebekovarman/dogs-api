package com.example.dogsapilist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dogsapilist.adapter.DogsApiListAdapter
import com.example.dogsapilist.model.ApiClient
import com.example.dogsapilist.model.Dog
import com.example.dogsapilist.databinding.FragmentDogsApiListBinding
import retrofit2.Call
import retrofit2.Response

class DogsApiList : Fragment() {

    var dogs:List<Dog> = emptyList()

    companion object{
        fun newInstance() = DogsApiList()
    }

    private var _binding:FragmentDogsApiListBinding? = null

    private val binding
        get() = _binding!!

    private val adapter: DogsApiListAdapter by lazy{
        DogsApiListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDogsApiListBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dogsList.adapter = adapter
        binding.search.setOnClickListener{
            searchDog(binding.textField.text.toString())
        }

    }

    private fun searchDog(name: String){
        ApiClient.apiService.getDogsByName(name).enqueue(object : retrofit2.Callback<List<Dog>> {
            override fun onResponse(call: Call<List<Dog>>, response: Response<List<Dog>>) {
                if (response.isSuccessful) {
                    dogs = response.body() ?: emptyList()
                    adapter.submitList(dogs)

                } else {
                }
            }

            override fun onFailure(call: Call<List<Dog>>, t: Throwable) {
            }
        })
    }

}