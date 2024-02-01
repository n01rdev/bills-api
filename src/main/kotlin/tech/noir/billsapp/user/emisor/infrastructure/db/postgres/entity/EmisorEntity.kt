package tech.noir.billsapp.user.emisor.infrastructure.db.postgres.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "emisors")
data class EmisorEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emisors_id_seq")
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val uuid: String = UUID.randomUUID().toString(), //TODO: Move to VO

    @Column(nullable = false)
    val firstName : String = "",

    @Column(nullable = false)
    val lastName : String = "",

    @Column(nullable = false)
    val cif : String = "",

    @Column(nullable = false)
    val address : String = "",

    @Column(nullable = false)
    val postalCode : String = "",

    @Column(nullable = false)
    val city : String = "",

    @Column(nullable = false)
    val province : String = "",

    @Column(nullable = false)
    val country : String = "",

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

