package tech.noir.billsapp.user.receiver.infrastructure.db.postgres.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*

@Entity
@Table(name = "receivers")
data class ReceiverEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receivers_id_seq")
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
    val active: Boolean = false,

    @CreationTimestamp
    @Column(nullable = false)
    val createdAt: String = "",

    @UpdateTimestamp
    @Column(nullable = false)
    val updatedAt: String = "",

    @Column(nullable = false)
    val deletedAt: String = "",
)
