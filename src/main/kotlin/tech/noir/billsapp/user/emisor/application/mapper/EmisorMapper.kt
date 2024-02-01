package tech.noir.billsapp.user.emisor.application.mapper

import org.springframework.stereotype.Component
import tech.noir.billsapp.user.emisor.domain.model.Emisor
import tech.noir.billsapp.user.emisor.infrastructure.db.postgres.entity.EmisorEntity

@Component
class EmisorMapper {
    fun toEntity(emisor: Emisor): EmisorEntity {
        return EmisorEntity(
            uuid = emisor.uuid,
            firstName = emisor.firstName,
            lastName = emisor.lastName,
            cif = emisor.cif,
            address = emisor.address,
            postalCode = emisor.postalCode,
            city = emisor.city,
            province = emisor.province,
            country = emisor.country,
            active = emisor.active,
            createdAt = emisor.createdAt,
            updatedAt = emisor.updatedAt,
            deletedAt = emisor.deletedAt
        )
    }

    fun toDomain(emisorEntity: EmisorEntity): Emisor {
        return Emisor(
            id = emisorEntity.id,
            uuid = emisorEntity.uuid,
            firstName = emisorEntity.firstName,
            lastName = emisorEntity.lastName,
            cif = emisorEntity.cif,
            address = emisorEntity.address,
            postalCode = emisorEntity.postalCode,
            city = emisorEntity.city,
            province = emisorEntity.province,
            country = emisorEntity.country,
            active = emisorEntity.active,
            createdAt = emisorEntity.createdAt,
            updatedAt = emisorEntity.updatedAt,
            deletedAt = emisorEntity.deletedAt
        )
    }
}