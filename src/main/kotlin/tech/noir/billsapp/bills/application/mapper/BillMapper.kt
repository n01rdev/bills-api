package tech.noir.billsapp.bills.application.mapper

import org.springframework.stereotype.Component
import tech.noir.billsapp.bills.domain.model.Bill
import tech.noir.billsapp.bills.infrastructure.db.postgres.entity.BillEntity
import tech.noir.billsapp.user.emisor.application.mapper.EmisorMapper
import tech.noir.billsapp.user.emisor.infrastructure.db.postgres.repository.EmisorRepository
import tech.noir.billsapp.user.receiver.application.mapper.ReceiverMapper
import tech.noir.billsapp.user.receiver.infrastructure.db.postgres.repository.ReceiverRepository

@Component
class BillMapper(
    private val emisorRepository: EmisorRepository,
    private val receiverRepository: ReceiverRepository,
    private val emisorMapper: EmisorMapper,
    private val receiverMapper: ReceiverMapper
) {
    fun toEntity(bill: Bill): BillEntity {
        val emisorEntity = emisorRepository.findByUuid(bill.emisorUuid)?.let { emisorMapper.toEntity(it) }
        val receiverEntity = receiverRepository.findByUuid(bill.receiverUuid)?.let { receiverMapper.toEntity(it) }

        return BillEntity(
            uuid = bill.uuid,
            billNumber = bill.billNumber,
            expeditionDate = bill.expeditionDate,
            emisor = emisorEntity,
            receiver = receiverEntity,
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
            emisorUuid = billEntity.emisor?.uuid ?: "",
            receiverUuid = billEntity.receiver?.uuid ?: "",
            concept = billEntity.concept,
            base = billEntity.base,
            iva = billEntity.iva,
            total = billEntity.total,
            createdAt = billEntity.createdAt.toString(),
            updatedAt = billEntity.updatedAt.toString(),
            deletedAt = billEntity.deletedAt?.toString() ?: "",
            active = billEntity.active
        )
    }
}