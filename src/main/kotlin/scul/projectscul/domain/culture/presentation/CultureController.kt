package scul.projectscul.domain.culture.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import scul.projectscul.infra.open.OpenApiService
import java.util.*

@RequestMapping("/scul/cultures")
@RestController
class CultureController (
        private val openApiService: OpenApiService
) {
    @GetMapping("/api")
    suspend fun saveCultureData() {
        openApiService.execute()
    }
}
