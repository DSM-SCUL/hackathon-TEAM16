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
    ) {
        constructor(culture: Culture): this(
                id = culture.id,
                location = culture.location,
                placeName = culture.placeName,
                ticketPrice = culture.ticketPrice,
                isBookMarked = culture.isBookMarked,
                imageUrl = culture.imageUrl,
                cultureName = culture.cultureName,
                wantedPeople = culture.wantedPeople
        )
    }
}
