package tech.noir.billsapp.bill.domain.model

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
    val active: Boolean,
    val createdAt: String,
    val updatedAt: String,
    val deletedAt: String,
)