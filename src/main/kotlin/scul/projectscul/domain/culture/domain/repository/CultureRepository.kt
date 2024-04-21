package scul.projectscul.domain.culture.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import scul.projectscul.domain.culture.domain.Culture
import java.util.*

interface CultureRepository: JpaRepository<Culture, UUID> {

    fun findCultureById(cultureId: UUID) : Culture

}