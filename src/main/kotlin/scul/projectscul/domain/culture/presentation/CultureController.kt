package scul.projectscul.domain.culture.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import scul.projectscul.domain.culture.presentation.dto.response.GetCultureListResponse
import scul.projectscul.domain.culture.service.GetCultureListService
import scul.projectscul.infra.open.OpenApiService
import java.util.*

@RequestMapping("/scul/cultures")
@RestController
class CultureController (
        private val openApiService: OpenApiService,
        private val getCultureListService: GetCultureListService,
) {

    @GetMapping
    fun getCultureList(
            @RequestParam(name = "title", required = false) title: String,
            @RequestParam(name = "wanted_people", required = false) wantedPeople: String
    ): GetCultureListResponse {
        return getCultureListService.execute(title, wantedPeople)
    }

    @GetMapping("/api")
    suspend fun saveCultureData() {
        openApiService.execute()
    }
}
