package tech.noir.billsapp.user.domain.service

import tech.noir.billsapp.user.domain.model.User

fun interface ICreateUserService {
    fun create(user: User): String
}