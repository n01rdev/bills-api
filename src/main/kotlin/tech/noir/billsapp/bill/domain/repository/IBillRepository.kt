package tech.noir.billsapp.bill.domain.repository

import tech.noir.billsapp.bill.domain.model.Bill

interface IBillRepository {
    fun save(bill: Bill) : String
    fun delete(uuid: String)
    fun findByUuid(uuid: String) : Bill?
}