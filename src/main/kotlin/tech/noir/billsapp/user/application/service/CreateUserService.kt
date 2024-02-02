package tech.noir.billsapp.user.application.service

import org.springframework.stereotype.Service
import tech.noir.billsapp.user.domain.model.User
import tech.noir.billsapp.user.domain.service.ICreateUserService
import tech.noir.billsapp.user.infrastructure.db.postgres.repository.UserRepository

@Service
class CreateUserService(
    private val userRepository: UserRepository
) : ICreateUserService {
    override fun create(user: User): String {
        val uuid = userRepository.save(user)
        return uuid
    }
}