package scul.projectscul.domain.news.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.news.domain.News
import scul.projectscul.domain.news.domain.repository.NewsRepository
import scul.projectscul.domain.news.presentation.response.NewsListResponse

@Service
@Transactional(readOnly = true)
class GetNewsService (
        private val newsRepository: NewsRepository
) {

    fun execute(): NewsListResponse {
        return NewsListResponse(
                newsRepository.findAll()
                        .map { NewsListResponse.NewsResponse(it) }
        )
    }
}
