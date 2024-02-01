package tech.noir.billsapp.user.emisor.domain.repository

import tech.noir.billsapp.user.emisor.domain.model.Emisor

interface IEmisorRepository {
    fun save(emisor: Emisor) : String
    fun delete(uuid: String)
    fun findByUuid(uuid: String) : Emisor?
}