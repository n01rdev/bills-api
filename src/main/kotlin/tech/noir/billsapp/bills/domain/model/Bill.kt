package tech.noir.billsapp.bills.domain.model

data class Bill(
    val id: Int,
    val uuid: String,
    val billNumber : String,
    val expeditionDate : String,
    val emisor: Emisor, //TODO: Add Emisor Model
    val receiver: Receiver, //TODO: Add Receiver Model
    val concept : String,
    val base : Double,
    val iva : Double,
    val date : String,
    val createdAt: String,
    val updatedAt: String,
    val deletedAt: String,
    val active: Boolean
)