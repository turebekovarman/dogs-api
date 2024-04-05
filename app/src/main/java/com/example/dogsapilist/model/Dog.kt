package com.example.dogsapilist.model

import com.google.gson.annotations.SerializedName

data class Dog(
    val name: String,

    @SerializedName("image_link")
    val imageLink:String,

    @SerializedName("coat_length")
    val coatLength:Int,

    val energy: Int,

    @SerializedName("good_with_children")
    val goodWithChildren:Int,

    val grooming: Int
)

/*name, imageLink, coatLength, energy, goodWithChildren, grooming*/