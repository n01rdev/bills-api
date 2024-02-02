package tech.noir.billsapp.user.application.mapper

import org.springframework.stereotype.Component
import tech.noir.billsapp.user.domain.model.User
import tech.noir.billsapp.user.infrastructure.db.postgres.entity.UserEntity

@Component
class UserEntityDomainMapper {
    fun toEntity(user: User): UserEntity {
        return UserEntity(
            uuid = user.uuid,
            firstName = user.firstName,
            lastName = user.lastName,
            cif = user.cif,
            address = user.address,
            postalCode = user.postalCode,
            city = user.city,
            province = user.province,
            country = user.country,
            active = user.active
        )
    }

    fun toDomain(userEntity: UserEntity): User {
        return User(
            id = userEntity.id,
            uuid = userEntity.uuid,
            firstName = userEntity.firstName,
            lastName = userEntity.lastName,
            cif = userEntity.cif,
            address = userEntity.address,
            postalCode = userEntity.postalCode,
            city = userEntity.city,
            province = userEntity.province,
            country = userEntity.country,
            active = userEntity.active,
            createdAt = userEntity.createdAt.toString(),
            updatedAt = userEntity.updatedAt.toString(),
            deletedAt = userEntity.deletedAt.toString()
        )
    }
}