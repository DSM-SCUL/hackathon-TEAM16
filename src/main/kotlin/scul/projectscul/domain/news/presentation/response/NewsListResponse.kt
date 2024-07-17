package scul.projectscul.domain.news.presentation.response

import scul.projectscul.domain.news.domain.News

data class NewsListResponse (

        val itemList: List<NewsResponse>
) {

    data class NewsResponse (
            val id : Long,
            val title : String,
            val email : String,
            val providerLinkPage : String
    ) {
        constructor(news: News): this(
                id = news.id,
                title = news.title,
                email = news.email,
                providerLinkPage = news.providerLinkPage
        )
    }
}
