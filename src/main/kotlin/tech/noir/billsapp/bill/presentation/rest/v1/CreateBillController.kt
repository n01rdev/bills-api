package tech.noir.billsapp.bill.presentation.rest.v1

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.noir.billsapp.bill.application.mapper.BillDomainRequestMapper
import tech.noir.billsapp.bill.application.mapper.BillDomainResponseMapper
import tech.noir.billsapp.bill.application.request.BillRequest
import tech.noir.billsapp.bill.application.response.BillResponse
import tech.noir.billsapp.bill.application.service.CreateBillService

@RestController
@RequestMapping("/api/v1/bills")
class CreateBillController (
    private val createBillService: CreateBillService,
    private val billDomainRequestMapper: BillDomainRequestMapper,
    private val billDomainResponseMapper: BillDomainResponseMapper
) {
    @PostMapping
    fun create(@RequestBody bill: BillRequest) : ResponseEntity<BillResponse> {
        return try {
            val billDomain = billDomainRequestMapper.toDomain(bill)
            val uuid = createBillService.create(billDomain)
            val billResponse = billDomainResponseMapper.toResponse(uuid)
            ResponseEntity.status(HttpStatus.CREATED).body(billResponse)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}