package scul.projectscul.domain.culture.presentation.dto.response

import scul.projectscul.domain.culture.domain.Culture
import java.util.UUID

data class GetCultureListResponse(
        val culture: List<CultureListResponse>
) {
    data class CultureListResponse (
            val id: UUID?,
            val location: String,
            val placeName: String,
            val ticketPrice: String,
            val isBookMarked: Boolean,
            val imageUrl: String,
            val cultureName: String,
            val wantedPeople: String
    )
}
