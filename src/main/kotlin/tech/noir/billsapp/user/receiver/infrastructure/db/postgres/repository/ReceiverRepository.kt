package tech.noir.billsapp.user.receiver.infrastructure.db.postgres.repository

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository
import tech.noir.billsapp.user.receiver.domain.model.Receiver
import tech.noir.billsapp.user.receiver.domain.repository.IReceiverRepository
import tech.noir.billsapp.user.receiver.infrastructure.db.postgres.entity.ReceiverEntity

@Repository
class ReceiverRepository(
    @PersistenceContext
    private val entityManager: EntityManager,
    private val jpaRepository: IJpaReceiverRepository,
    private val receiverMapper: ReceiverMapper //TODO: Inject mapper
) : IReceiverRepository {

    override fun save(receiver: Receiver): String {
        val receiverEntity = receiverMapper.toEntity(receiver)
        entityManager.persist(receiverEntity)
        entityManager.flush()
        return receiverEntity.uuid
    }

    override fun delete(uuid: String) {
        val receiverEntity = jpaRepository.findByUuidAndActiveTrue(uuid)
        receiverEntity?.let {
            it.active = false
            entityManager.merge(it)
            entityManager.flush()
        }
    }

    override fun findByUuid(uuid: String): Receiver? {
        val receiverEntity = findByUuidEntity(uuid)
        return receiverEntity?.let { receiverMapper.toDomain(it) }
    }

    private fun findByUuidEntity(uuid: String): ReceiverEntity? {
        return jpaRepository.findByUuidAndActiveTrue(uuid)
    }
}