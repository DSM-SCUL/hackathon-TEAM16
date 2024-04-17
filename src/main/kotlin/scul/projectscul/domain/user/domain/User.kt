package scul.projectscul.domain.user.domain

import com.example.kotlinpractice.global.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class User(
        id : Long,

        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        val name: String,

        @Column(columnDefinition = "VARCHAR(10)", nullable = false)
        val accountId: String,

        @Column(columnDefinition = "CHAR(60)", nullable = false)
        val password: String,

) : BaseEntity(id)
