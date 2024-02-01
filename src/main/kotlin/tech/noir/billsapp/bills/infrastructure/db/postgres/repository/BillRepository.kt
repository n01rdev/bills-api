package tech.noir.billsapp.bills.infrastructure.db.postgres.repository

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository
import tech.noir.billsapp.bills.application.mapper.BillMapper
import tech.noir.billsapp.bills.domain.model.Bill
import tech.noir.billsapp.bills.domain.repository.IBillRepository
import tech.noir.billsapp.bills.infrastructure.db.postgres.entity.BillEntity
import java.time.LocalDateTime

@Repository
class BillRepository (
    @PersistenceContext
    private val entityManager: EntityManager,
    private val jpaRepository: IBillJpaRepository,
    private val billMapper: BillMapper
) : IBillRepository {
    override fun save(bill: Bill): String {
        val billEntity = billMapper.toEntity(bill)
        entityManager.persist(billEntity)
        entityManager.flush()
        return billEntity.uuid
    }

    override fun delete(uuid: String) {
        val billEntity = jpaRepository.findByUuidAndActiveTrue(uuid)
        billEntity?.let {
            it.active = false
            it.deletedAt = LocalDateTime.now()
            entityManager.merge(it)
            entityManager.flush()
        }
    }

    override fun findByUuid(uuid: String): Bill? {
        val billEntity = findByUuidEntity(uuid)
        return billEntity?.let { billMapper.toDomain(it) }
    }

    private fun findByUuidEntity(uuid: String): BillEntity? {
        return jpaRepository.findByUuidAndActiveTrue(uuid)
    }
}
