package scul.projectscul.domain.news.domain

import javax.persistence.*

@Entity
class News (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id : Long,

        @Column(columnDefinition = "VARCHAR(100)", nullable = false)
        val title: String,

        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        val provider: String,

        @Column(columnDefinition = "VARCHAR(1000)", nullable = false)
        val providerLinkPage: String,

)