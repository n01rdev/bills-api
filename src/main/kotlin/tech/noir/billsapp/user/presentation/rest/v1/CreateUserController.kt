package tech.noir.billsapp.user.presentation.rest.v1

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.noir.billsapp.user.application.mapper.UserDomainRequestMapper
import tech.noir.billsapp.user.application.mapper.UserDomainResponseMapper
import tech.noir.billsapp.user.application.request.UserRequest
import tech.noir.billsapp.user.application.response.UserResponse
import tech.noir.billsapp.user.application.service.CreateUserService

@RestController
@RequestMapping("/api/v1/users")
class CreateUserController(
    private val createUserService: CreateUserService,
    private val userDomainRequestMapper: UserDomainRequestMapper,
    private val userDomainResponseMapper: UserDomainResponseMapper
) {

    @PostMapping("/create")
    fun create(@RequestBody user: UserRequest)  : ResponseEntity<UserResponse> {
        return try {
            val userDomain = userDomainRequestMapper.toDomain(user)
            val uuid = createUserService.create(userDomain)
            val userResponse = userDomainResponseMapper.toResponse(uuid)

            ResponseEntity.status(HttpStatus.CREATED).body(userResponse)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}