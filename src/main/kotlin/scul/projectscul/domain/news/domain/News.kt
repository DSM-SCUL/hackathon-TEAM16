package scul.projectscul.domain.news.domain

import javax.persistence.*

@Entity
class News (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id : Long,

        @Column(columnDefinition = "VARCHAR(10)", nullable = false)
        val title: String,

        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        val email: String,

        @Column(columnDefinition = "VARCHAR(20)", nullable = false)
        val providerLinkPage: String,

)