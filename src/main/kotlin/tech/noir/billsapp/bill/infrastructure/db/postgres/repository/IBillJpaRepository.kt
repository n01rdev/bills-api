package tech.noir.billsapp.bill.infrastructure.db.postgres.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tech.noir.billsapp.bill.infrastructure.db.postgres.entity.BillEntity

@Repository
interface IBillJpaRepository : JpaRepository<BillEntity, Long> {
    fun findByUuidAndActiveTrue(uuid: String): BillEntity?
}