package tech.noir.billsapp.user.application.mapper

import org.springframework.stereotype.Component
import tech.noir.billsapp.user.application.request.UserRequest
import tech.noir.billsapp.user.domain.model.User

@Component
class UserDomainRequestMapper {
    fun toDomain(user: UserRequest): User {
        return User(
            id = 0,
            uuid = "",
            firstName = user.firstName,
            lastName = user.lastName,
            cif = user.cif,
            address = user.address,
            postalCode = user.postalCode,
            city = user.city,
            province = user.province,
            country = user.country,
            active = true,
            createdAt = "",
            updatedAt = "",
            deletedAt = ""
        )
    }
}