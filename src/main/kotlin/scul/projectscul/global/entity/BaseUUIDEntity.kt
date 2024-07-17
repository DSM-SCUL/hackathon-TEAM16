package com.example.kotlinpractice.global.entity

import javax.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.*


@MappedSuperclass
abstract class BaseUUIDEntity (

        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Column(
                columnDefinition = "BINARY(16)",
                nullable = false
        )
    val id: UUID?

)
