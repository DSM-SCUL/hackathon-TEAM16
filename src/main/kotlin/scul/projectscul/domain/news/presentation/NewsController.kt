package scul.projectscul.domain.news.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import scul.projectscul.domain.news.presentation.request.NewsListRequest
import scul.projectscul.domain.news.presentation.response.NewsListResponse
import scul.projectscul.domain.news.service.GetNewsService
import scul.projectscul.domain.news.service.UpdateNewsService

@RequestMapping("/scul/news")
@RestController
class NewsController (
        private val getNewsService: GetNewsService,
        private val updateNewsService: UpdateNewsService

) {

    @GetMapping("/list")
    fun newsList() : NewsListResponse {
        return getNewsService.execute()
    }

    @PostMapping("/update")
    fun updateNews(request: NewsListRequest) {
        updateNewsService.execute(request)
    }
}
