package com.example.dogsapilist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dogsapilist.model.Dog
import com.example.dogsapilist.databinding.DogItemBinding

class DogsApiListAdapter:ListAdapter<Dog, DogsApiListAdapter.ViewHolder>(DogsApiListDiffUtil()) {

    inner class ViewHolder(
        private val binding: DogItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val context = binding.root.context
        fun bind(dog: Dog) {
            with(binding){
                name.text = dog.name
                coat.text = dog.coatLength.toString()
                energy.text = dog.energy.toString()
                gwc.text = dog.goodWithChildren.toString()
                grooming.text = dog.grooming.toString()

                Glide.with(itemView.context)
                    .load(dog.imageLink)
                    .into(dogImg)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DogItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}