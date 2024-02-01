package tech.noir.billsapp.bill.application.mapper

import org.springframework.stereotype.Component
import tech.noir.billsapp.bill.application.response.BillResponse

@Component
class BillDomainResponseMapper {
    fun toResponse(uuid: String): BillResponse {
        return BillResponse(uuid)
    }
}