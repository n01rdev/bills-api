package tech.noir.billsapp.bills.infrastructure.db.postgres.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import tech.noir.billsapp.user.emisor.infrastructure.db.postgres.entity.EmisorEntity
import tech.noir.billsapp.user.receiver.infrastructure.db.postgres.entity.ReceiverEntity
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "bills")
data class BillEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bills_id_seq")
    private val id: Long = 0,

    @Column(nullable = false, unique = true)
    val uuid: String = UUID.randomUUID().toString(), //TODO: Move to VO

    @Column(nullable = false)
    val billNumber : String = "",

    @Column(nullable = false)
    val expeditionDate : String = "",

    @ManyToOne
    @JoinColumn(name = "emisor_uuid", nullable = false)
    val emisor: EmisorEntity? = null,

    @ManyToOne
    @JoinColumn(name = "receiver_uuid", nullable = false)
    val receiver: ReceiverEntity? = null,

    @Column(nullable = false)
    val concept : String = "",

    @Column(nullable = false)
    val base : Double = 0.0,

    @Column(nullable = false)
    val iva : Double = 0.0,

    @Column(nullable = false)
    val total : Double = 0.0,

    @Column(nullable = false)
    val active: Boolean = true,

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private val createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    @Column(nullable = false)
    private var updatedAt: LocalDateTime = LocalDateTime.now(),

    @Column
    var deletedAt: LocalDateTime? = null
)