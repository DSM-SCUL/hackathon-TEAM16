package scul.projectscul.domain.news.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import scul.projectscul.domain.news.domain.News

interface NewsRepository : JpaRepository<News, Long> {
}