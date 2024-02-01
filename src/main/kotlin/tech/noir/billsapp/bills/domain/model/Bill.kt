package tech.noir.billsapp.bills.domain.model

data class Bill(
    val id: Long,
    val uuid: String,
    val billNumber: String,
    val expeditionDate: String,
    val emisorUuid: String,
    val receiverUuid: String,
    val concept: String,
    val base: Double,
    val iva: Double,
    val total: Double,
    val createdAt: String,
    val updatedAt: String,
    val deletedAt: String,
    val active: Boolean
)