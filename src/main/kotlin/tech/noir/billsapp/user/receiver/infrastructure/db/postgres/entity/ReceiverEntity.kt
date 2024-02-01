package tech.noir.billsapp.user.receiver.infrastructure.db.postgres.entity

import jakarta.persistence.*

@Entity
@Table(name = "receivers")
data class ReceiverEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receivers_id_seq")
    val id: Long = 0,

    @Column(nullable = false)
    val name : String = "",

    @Column(nullable = false)
    val nif : String = "",

    @Column(nullable = false)
    val address : String = ""
)
