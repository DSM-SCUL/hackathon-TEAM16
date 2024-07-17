package scul.projectscul.domain.news.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.news.domain.News
import scul.projectscul.domain.news.domain.repository.NewsRepository
import scul.projectscul.domain.news.presentation.request.NewsListRequest

@Service
@Transactional
class UpdateNewsService (
        private val newsRepository: NewsRepository
) {
    fun execute(request: NewsListRequest) {
        request.documents.forEach { newsRequest ->
            val news = News(
                    id = 0,
                    title = newsRequest.title,
                    provider = newsRequest.provider,
                    providerLinkPage = newsRequest.provider_link_page
            )
            newsRepository.save(news)
        }

    }
}
