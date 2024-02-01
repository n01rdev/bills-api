package tech.noir.billsapp.user.receiver.domain.repository

import tech.noir.billsapp.user.receiver.domain.model.Receiver

interface IReceiverRepository {
    fun save(receiver: Receiver) : String
    fun delete(uuid: String)
    fun findByUuid(uuid: String) : Receiver?
}