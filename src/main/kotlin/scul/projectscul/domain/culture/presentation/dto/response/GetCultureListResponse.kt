package scul.projectscul.domain.culture.presentation.dto.response

data class GetCultureListResponse(
        val culture: List<CultureListResponse>
) {
    data class CultureListResponse (
            val title: String
    )
}
