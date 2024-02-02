package tech.noir.billsapp.user.infrastructure.db.postgres.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tech.noir.billsapp.user.infrastructure.db.postgres.entity.UserEntity

@Repository
interface IJpaUserRepository : JpaRepository<UserEntity, Long> {

    fun findByUuidAndActiveTrue(uuid: String): UserEntity?
}