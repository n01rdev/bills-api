package tech.noir.billsapp.user.receiver.infrastructure.db.postgres.repository

import org.springframework.data.jpa.repository.JpaRepository
import tech.noir.billsapp.user.receiver.infrastructure.db.postgres.entity.ReceiverEntity

interface IJpaReceiverRepository : JpaRepository<ReceiverEntity, Long> {

    fun findByUuidAndActiveTrue(uuid: String): ReceiverEntity?
}