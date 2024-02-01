package tech.noir.billsapp.user.receiver.domain.model

data class Receiver(
    val id: Long,
    val uuid: String,
    val firstName : String,
    val lastName : String,
    val cif : String,
    val address : String,
    val postalCode : String,
    val city : String,
    val province : String,
    val country : String,
    val active: Boolean,
    val createdAt: String,
    val updatedAt: String,
    val deletedAt: String,
)
