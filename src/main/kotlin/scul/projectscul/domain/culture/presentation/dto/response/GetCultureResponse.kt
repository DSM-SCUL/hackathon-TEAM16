package scul.projectscul.domain.culture.presentation.dto.response

import scul.projectscul.domain.culture.domain.Culture
import java.util.*

data class GetCultureResponse (
    val id: UUID?,
    val location: String,
    val placeName: String,
    val ticketPrice: String,
    val isBookMarked: Boolean,
    val imageUrl: String,
    val cultureName: String,
    val wantedPeople: String,
    val content: String,
    val phoneNumber: String,
    val applicationStartDate: String,
    val applicationEndDate: String,
    val serviceStartDate: String,
    val serviceEndDate: String,
    val cultureLink: String,
    val xCoordinate: Double,
    val yCoordinate: Double
) {
    companion object {
        fun of(culture: Culture, isBookMarked: Boolean): GetCultureResponse {
            return GetCultureResponse(
                    id = culture.id,
                    location = culture.location,
                    placeName = culture.placeName,
                    ticketPrice = culture.ticketPrice,
                    isBookMarked = isBookMarked,
                    imageUrl = culture.imageUrl,
                    cultureName = culture.cultureName,
                    wantedPeople = culture.wantedPeople,
                    content = culture.content,
                    phoneNumber = culture.phoneNumber,
                    applicationStartDate = culture.applicationStartDate,
                    applicationEndDate = culture.applicationEndDate,
                    serviceStartDate = culture.serviceStartDate,
                    serviceEndDate = culture.serviceEndDate,
                    cultureLink = culture.cultureLink,
                    xCoordinate = culture.xCoordinate,
                    yCoordinate = culture.yCoordinate
            )
        }
    }
}