package tech.noir.billsapp.user.infrastructure.db.postgres.repository

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository
import tech.noir.billsapp.user.application.mapper.UserEntityDomainMapper
import tech.noir.billsapp.user.domain.model.User
import tech.noir.billsapp.user.domain.repository.IUserRepository
import tech.noir.billsapp.user.infrastructure.db.postgres.entity.UserEntity
import java.time.LocalDateTime

@Repository
class UserRepository(
    @PersistenceContext
    private val entityManager: EntityManager,
    private val jpaRepository: IJpaUserRepository,
    private val userEntityDomainMapper: UserEntityDomainMapper
) : IUserRepository {
    override fun save(user: User): String {
        val userEntity = userEntityDomainMapper.toEntity(user)
        entityManager.persist(userEntity)
        entityManager.flush()
        return userEntity.uuid
    }

    override fun delete(uuid: String) {
        val userEntity = findByUuidEntity(uuid)
        userEntity?.let {
            it.active = false
            it.deletedAt= LocalDateTime.now()
            entityManager.merge(it)
            entityManager.flush()
        }
    }

    override fun findByUuid(uuid: String): User? {
        val userEntity = findByUuidEntity(uuid)
        return userEntity?.let { userEntityDomainMapper.toDomain(it) }
    }

    private fun findByUuidEntity(uuid: String): UserEntity? {
        return jpaRepository.findByUuidAndActiveTrue(uuid)
    }
}