package tech.noir.billsapp.user.receiver.application.mapper

import org.springframework.stereotype.Component
import tech.noir.billsapp.user.receiver.domain.model.Receiver
import tech.noir.billsapp.user.receiver.infrastructure.db.postgres.entity.ReceiverEntity

@Component
class ReceiverMapper {
    fun toEntity(receiver: Receiver): ReceiverEntity {
        return ReceiverEntity(
            uuid = receiver.uuid,
            firstName = receiver.firstName,
            lastName = receiver.lastName,
            cif = receiver.cif,
            address = receiver.address,
            postalCode = receiver.postalCode,
            city = receiver.city,
            province = receiver.province,
            country = receiver.country,
            active = receiver.active
        )
    }

    fun toDomain(receiverEntity: ReceiverEntity): Receiver {
        return Receiver(
            id = receiverEntity.id,
            uuid = receiverEntity.uuid,
            firstName = receiverEntity.firstName,
            lastName = receiverEntity.lastName,
            cif = receiverEntity.cif,
            address = receiverEntity.address,
            postalCode = receiverEntity.postalCode,
            city = receiverEntity.city,
            province = receiverEntity.province,
            country = receiverEntity.country,
            active = receiverEntity.active,
            createdAt = receiverEntity.createdAt.toString(),
            updatedAt = receiverEntity.updatedAt.toString(),
            deletedAt = receiverEntity.deletedAt.toString()
        )
    }
}