package tech.noir.billsapp.bill.application.request

data class BillRequest(
    val billNumber: String,
    val expeditionDate: String,
    val concept: String,
    val base: Double,
    val iva: Double,
)
