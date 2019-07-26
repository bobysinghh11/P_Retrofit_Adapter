package com.stuffshuf.p_retrofit_adapter



data class Address(
    val street:String,
    val suite:String,
    val city:String

)

data class Users(

val id:Int,
val name:String,
val username:String,
val email:String,
val address: Address
)
