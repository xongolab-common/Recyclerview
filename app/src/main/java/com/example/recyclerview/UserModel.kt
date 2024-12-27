package com.example.recyclerview


data class UserModel(

    var question: String = "",
    val options: ArrayList<OptionsModel> = ArrayList(),

    ){

    data class OptionsModel(
        var label: String = "",

        var isSelect: Boolean = false
    ){}

}