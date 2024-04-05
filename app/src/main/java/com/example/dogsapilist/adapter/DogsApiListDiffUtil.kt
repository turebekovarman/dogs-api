package com.example.dogsapilist.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.dogsapilist.model.Dog

class DogsApiListDiffUtil: DiffUtil.ItemCallback<Dog>() {
    override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
        return oldItem == newItem
    }
}