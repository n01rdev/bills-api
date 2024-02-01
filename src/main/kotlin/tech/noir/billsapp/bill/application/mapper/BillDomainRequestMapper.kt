package tech.noir.billsapp.bill.application.mapper

import org.springframework.stereotype.Component
import tech.noir.billsapp.bill.application.request.BillRequest
import tech.noir.billsapp.bill.domain.model.Bill

@Component
class BillDomainRequestMapper {
    fun toDomain(bill: BillRequest): Bill {
        return Bill(
            id = 0,
            uuid = "",
            billNumber = bill.billNumber,
            expeditionDate = bill.expeditionDate,
            emisorUuid = "",
            receiverUuid = "",
            concept = bill.concept,
            base = bill.base,
            iva = bill.iva,
            total = bill.base + (bill.base * bill.iva), //TODO: Move to VO
            active = true,
            createdAt = "",
            updatedAt = "",
            deletedAt = ""
        )
    }

    fun toRequest(bill: Bill): BillRequest {
        return BillRequest(
            billNumber = bill.billNumber,
            expeditionDate = bill.expeditionDate,
            concept = bill.concept,
            base = bill.base,
            iva = bill.iva,
        )
    }
}