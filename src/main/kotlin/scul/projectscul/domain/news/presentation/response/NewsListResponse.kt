package scul.projectscul.domain.news.presentation.response

import scul.projectscul.domain.news.domain.News

data class NewsListResponse (

        val newsList: List<NewsResponse>
) {
    data class NewsResponse (
            val id : Long,
            val title : String,
            val provider : String,
            val providerLinkPage : String
    ) {
        constructor(news: News): this(
                id = news.id,
                title = news.title,
                provider = news.provider,
                providerLinkPage = news.providerLinkPage
        )
    }
}
