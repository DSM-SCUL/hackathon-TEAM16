package scul.projectscul.domain.culture.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import scul.projectscul.domain.culture.domain.Culture

interface CultureRepository: JpaRepository<Culture, Long> {
}