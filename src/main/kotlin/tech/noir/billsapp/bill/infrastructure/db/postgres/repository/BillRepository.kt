package tech.noir.billsapp.bill.infrastructure.db.postgres.repository

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository
import tech.noir.billsapp.bill.application.mapper.BillEntityDomainMapper
import tech.noir.billsapp.bill.domain.model.Bill
import tech.noir.billsapp.bill.domain.repository.IBillRepository
import tech.noir.billsapp.bill.infrastructure.db.postgres.entity.BillEntity
import java.time.LocalDateTime

@Repository
class BillRepository (
    @PersistenceContext
    private val entityManager: EntityManager,
    private val jpaRepository: IBillJpaRepository,
    private val billEntityDomainMapper: BillEntityDomainMapper
) : IBillRepository {
    override fun save(bill: Bill): String {
        val billEntity = billEntityDomainMapper.toEntity(bill)
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
        return billEntity?.let { billEntityDomainMapper.toDomain(it) }
    }

    private fun findByUuidEntity(uuid: String): BillEntity? {
        return jpaRepository.findByUuidAndActiveTrue(uuid)
    }
}
