package scul.projectscul.domain.news.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import scul.projectscul.domain.news.presentation.response.NewsListResponse
import scul.projectscul.domain.news.service.GetNewsService
import scul.projectscul.domain.user.presentation.response.MyPageResponse

@RequestMapping("/scul/news")
@RestController
class NewsController (
        private val getNewsService: GetNewsService,

) {

    @GetMapping("/")
    fun newsList() : NewsListResponse {
        return getNewsService.execute()
    }
}