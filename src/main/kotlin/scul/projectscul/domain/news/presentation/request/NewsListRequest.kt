package scul.projectscul.domain.news.presentation.request

data class NewsListRequest(

        val documents: List<NewsRequest>
) {
    data class NewsRequest (
            val title: String,
            val provider: String,
            val provider_link_page : String
    )
}
