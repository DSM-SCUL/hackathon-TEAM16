package scul.projectscul.domain.user.domain

import com.example.kotlinpractice.global.entity.BaseUUIDEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import scul.projectscul.domain.user.domain.Enum.Tier
import java.time.LocalDate
import java.util.*

@Entity
class User(
        id : UUID?,

        @Column(columnDefinition = "VARCHAR(10)", nullable = false)
        val name: String,

        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        val email: String,

        @Column(columnDefinition = "VARCHAR(20)", nullable = false)
        val birth: LocalDate,

        @Column(columnDefinition = "VARCHAR(5000)", nullable = false)
        val profileImage: String,

        val todaySolvedCounts: Int = 0,

        val SolvedCounts: Int = 0,

        val score: Int = 0,

        @Enumerated(EnumType.STRING)
        val tier: Tier

        ) : BaseUUIDEntity(id)
