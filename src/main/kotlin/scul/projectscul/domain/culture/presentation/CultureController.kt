package scul.projectscul.domain.culture.presentation

import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import scul.projectscul.domain.culture.presentation.dto.response.GetCultureListResponse
import scul.projectscul.domain.culture.presentation.dto.response.GetCultureResponse
import scul.projectscul.domain.culture.service.GetCultureListService
import scul.projectscul.domain.culture.service.GetCultureService
import scul.projectscul.infra.open.OpenApiService
import java.util.*

@RequestMapping("/scul/cultures")
@RestController
class CultureController (
        private val openApiService: OpenApiService,
        private val getCultureListService: GetCultureListService,
        private val getCultureService: GetCultureService
) {

    @GetMapping
    fun getCultureList(
            @RequestParam(name = "title", required = false) title: String,
            @RequestParam(name = "wanted_people", required = false) wantedPeople: String
    ): GetCultureListResponse {
        return getCultureListService.execute(title, wantedPeople)
    }

    @GetMapping("/{culture-id}")
    fun getCulture(@PathVariable("culture-id") @NotNull cultureId: UUID): GetCultureResponse {
        return getCultureService.execute(cultureId)
    }

    @GetMapping("/api")
    suspend fun saveCultureData() {
        openApiService.execute()
    }
}
