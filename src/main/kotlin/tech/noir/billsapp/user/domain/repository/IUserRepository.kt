package tech.noir.billsapp.user.domain.repository

import tech.noir.billsapp.user.domain.model.User

interface IUserRepository {
    fun save(user: User) : String
    fun delete(uuid: String)
    fun findByUuid(uuid: String) : User?
}