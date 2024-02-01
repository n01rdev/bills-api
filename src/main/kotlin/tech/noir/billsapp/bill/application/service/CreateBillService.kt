package tech.noir.billsapp.bill.application.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import tech.noir.billsapp.bill.domain.model.Bill
import tech.noir.billsapp.bill.domain.service.ICreateBillService
import tech.noir.billsapp.bill.infrastructure.db.postgres.repository.BillRepository

@Service
class CreateBillService(
    private val billRepository: BillRepository
) : ICreateBillService {
    @Transactional
    override fun create(bill: Bill): String {
        val uuid = billRepository.save(bill)
        return uuid
    }
}