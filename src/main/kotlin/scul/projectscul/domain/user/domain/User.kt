package scul.projectscul.domain.user.domain

import com.example.kotlinpractice.global.entity.BaseUUIDEntity
import scul.projectscul.domain.user.domain.Enum.Tier
import java.time.LocalDate
import java.util.*
import javax.persistence.*

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
        var profileImage: String,

        val todaySolvedCounts: Int = 0,

        val solvedCounts: Int = 0,

        val score: Int = 0,

        @Enumerated(EnumType.STRING)
        var tier: Tier

) : BaseUUIDEntity(id) {

        fun updateImage(image: String) {
                this.profileImage = image
        }
}

