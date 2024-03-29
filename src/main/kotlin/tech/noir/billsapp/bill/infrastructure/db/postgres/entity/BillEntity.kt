package tech.noir.billsapp.bill.infrastructure.db.postgres.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import tech.noir.billsapp.user.infrastructure.db.postgres.entity.UserEntity
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "bills")
data class BillEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bills_id_seq")
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val uuid: String = UUID.randomUUID().toString(), //TODO: Move to VO

    @Column(nullable = false)
    val billNumber : String = "",

    @Column(nullable = false)
    val expeditionDate : String = "",

    @ManyToOne
    @JoinColumn(name = "emisor_uuid", referencedColumnName = "uuid")
    val emisor: UserEntity = UserEntity(),

    @ManyToOne
    @JoinColumn(name = "receiver_uuid", referencedColumnName = "uuid")
    val receiver: UserEntity = UserEntity(),

    @Column(nullable = false)
    val concept : String = "",

    @Column(nullable = false)
    val base : Double = 0.0,

    @Column(nullable = false)
    val iva : Double = 0.0,

    @Column(nullable = false)
    val total : Double = 0.0,

    @Column(nullable = false)
    var active: Boolean = true,

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @Column
    var deletedAt: LocalDateTime? = null
)