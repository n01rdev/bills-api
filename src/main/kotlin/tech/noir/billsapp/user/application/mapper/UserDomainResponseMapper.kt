package tech.noir.billsapp.user.application.mapper

import org.springframework.stereotype.Component
import tech.noir.billsapp.user.application.response.UserResponse

@Component
class UserDomainResponseMapper {
    fun toResponse(uuid: String): UserResponse {
        return UserResponse(
            uuid = uuid
        )
    }
}