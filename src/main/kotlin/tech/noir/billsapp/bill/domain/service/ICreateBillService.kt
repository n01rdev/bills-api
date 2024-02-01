package tech.noir.billsapp.bill.domain.service

import tech.noir.billsapp.bill.domain.model.Bill

fun interface ICreateBillService {
    fun create(bill: Bill): String
}