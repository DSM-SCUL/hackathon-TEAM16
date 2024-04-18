package scul.projectscul.domain.culture.domain

import com.example.kotlinpractice.global.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import scul.projectscul.domain.culture.domain.enum.CultureType

@Entity
class Culture (
        id: Long,

        @Column(columnDefinition = "DOUBLE", nullable = false)
        val xCoordinate: Double,

        @Column(columnDefinition = "DOUBLE", nullable = false)
        val yCoordinate: Double,

        val cultureType: CultureType

) : BaseEntity(id)
