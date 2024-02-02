package tech.noir.billsapp.user.application.request

data class UserRequest(
    val firstName : String,
    val lastName : String,
    val cif : String,
    val address : String,
    val postalCode : String,
    val city : String,
    val province : String,
    val country : String
)
