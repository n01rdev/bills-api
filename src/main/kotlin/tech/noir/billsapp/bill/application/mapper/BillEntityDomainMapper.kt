package tech.noir.billsapp.bill.application.mapper

import org.springframework.stereotype.Component
import tech.noir.billsapp.bill.domain.model.Bill
import tech.noir.billsapp.bill.infrastructure.db.postgres.entity.BillEntity
import tech.noir.billsapp.user.application.mapper.UserEntityDomainMapper
import tech.noir.billsapp.user.infrastructure.db.postgres.entity.UserEntity
import tech.noir.billsapp.user.infrastructure.db.postgres.repository.UserRepository

@Component
class BillEntityDomainMapper(
    private val userRepository: UserRepository,
    private val userEntityDomainMapper: UserEntityDomainMapper,
) {
    fun toEntity(bill: Bill): BillEntity {
        val emisorUuid = userRepository.findByUuid(bill.emisorUuid)?.let { userEntityDomainMapper.toEntity(it) } ?: UserEntity()
        val receiverUuid = userRepository.findByUuid(bill.receiverUuid)?.let { userEntityDomainMapper.toEntity(it) } ?: UserEntity()

        return BillEntity(
            uuid = bill.uuid,
            billNumber = bill.billNumber,
            expeditionDate = bill.expeditionDate,
            emisor = emisorUuid,
            receiver = receiverUuid,
            concept = bill.concept,
            base = bill.base,
            iva = bill.iva,
            total = bill.total,
            active = bill.active
        )
    }

    fun toDomain(billEntity: BillEntity): Bill {
        return Bill(
            id = billEntity.id,
            uuid = billEntity.uuid,
            billNumber = billEntity.billNumber,
            expeditionDate = billEntity.expeditionDate,
            emisorUuid = billEntity.emisor.uuid,
            receiverUuid = billEntity.receiver.uuid,
            concept = billEntity.concept,
            base = billEntity.base,
            iva = billEntity.iva,
            total = billEntity.total,
            active = billEntity.active,
            createdAt = billEntity.createdAt.toString(),
            updatedAt = billEntity.updatedAt.toString(),
            deletedAt = billEntity.deletedAt?.toString() ?: ""
        )
    }
}