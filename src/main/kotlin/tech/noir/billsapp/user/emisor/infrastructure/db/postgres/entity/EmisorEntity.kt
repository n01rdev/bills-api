package tech.noir.billsapp.user.emisor.infrastructure.db.postgres.entity

import jakarta.persistence.*

@Entity
@Table(name = "emisors")
data class EmisorEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emisors_id_seq")
    val id: Long = 0,

    @Column(nullable = false)
    val name : String = "",

    @Column(nullable = false)
    val nif : String = "",

    @Column(nullable = false)
    val address : String = ""
)

