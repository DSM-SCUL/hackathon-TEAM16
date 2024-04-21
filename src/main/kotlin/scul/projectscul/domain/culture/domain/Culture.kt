package scul.projectscul.domain.culture.domain

import com.example.kotlinpractice.global.entity.BaseUUIDEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import scul.projectscul.domain.culture.domain.enum.CultureType
import java.util.*

@Entity
class Culture (
        id: UUID?,

        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        val title: String,

        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        val phoneNumber: String,

        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        val availableTime: String,

        @Column(nullable = true)
        val tickerPrice: Int,

        @Column(columnDefinition = "VARCHAR(100)", nullable = false)
        val cultureLink: String,

        @Column(columnDefinition = "DOUBLE", nullable = false)
        val xCoordinate: Double,

        @Column(columnDefinition = "DOUBLE", nullable = false)
        val yCoordinate: Double,

        @Column
        val cultureType: CultureType,

        @Column
        val isBookMarked: Boolean = false

) : BaseUUIDEntity(id)
