package tech.noir.billsapp.user.emisor.infrastructure.db.postgres.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tech.noir.billsapp.user.emisor.infrastructure.db.postgres.entity.EmisorEntity

@Repository
interface IJpaEmisorRepository : JpaRepository<EmisorEntity, Long> {

    fun findByUuidAndActiveTrue(uuid: String): EmisorEntity?
}