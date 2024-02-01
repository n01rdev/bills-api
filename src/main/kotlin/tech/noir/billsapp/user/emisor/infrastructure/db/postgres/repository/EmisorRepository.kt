package tech.noir.billsapp.user.emisor.infrastructure.db.postgres.repository

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository
import tech.noir.billsapp.user.emisor.application.mapper.EmisorMapper
import tech.noir.billsapp.user.emisor.domain.model.Emisor
import tech.noir.billsapp.user.emisor.domain.repository.IEmisorRepository
import tech.noir.billsapp.user.emisor.infrastructure.db.postgres.entity.EmisorEntity
import java.time.LocalDateTime

@Repository
class EmisorRepository(
    @PersistenceContext
    private val entityManager: EntityManager,
    private val jpaRepository: IJpaEmisorRepository,
    private val emisorMapper: EmisorMapper
) : IEmisorRepository {
    override fun save(emisor: Emisor): String {
        val emisorEntity = emisorMapper.toEntity(emisor)
        entityManager.persist(emisorEntity)
        entityManager.flush()
        return emisorEntity.uuid
    }

    override fun delete(uuid: String) {
        val emisorEntity = findByUuidEntity(uuid)
        emisorEntity?.let {
            it.active = false
            it.deletedAt= LocalDateTime.now()
            entityManager.merge(it)
            entityManager.flush()
        }
    }

    override fun findByUuid(uuid: String): Emisor? {
        val emisorEntity = findByUuidEntity(uuid)
        return emisorEntity?.let { emisorMapper.toDomain(it) }
    }

    private fun findByUuidEntity(uuid: String): EmisorEntity? {
        return jpaRepository.findByUuidAndActiveTrue(uuid)
    }
}