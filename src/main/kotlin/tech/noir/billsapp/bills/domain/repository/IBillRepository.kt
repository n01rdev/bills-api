package tech.noir.billsapp.bills.domain.repository

import tech.noir.billsapp.bills.domain.model.Bill

interface IBillRepository {
    fun save(bill: Bill) : String
    fun delete(uuid: String)
    fun findByUuid(uuid: String) : Bill?
}