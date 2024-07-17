package scul.projectscul.domain.solvedQuiz.presentation

import org.jetbrains.annotations.NotNull
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import scul.projectscul.domain.solvedQuiz.service.GetLastQuizListService
import scul.projectscul.domain.solvedQuiz.presentation.response.GetLastSolvedQuizResponse
import java.util.*

@RequestMapping("/scul/solved")
@RestController
class SolvedQuizController (
    private val getLastQuizListService: GetLastQuizListService
){
    @GetMapping("/{user-id}")
    fun getLastQuizList(
        @PathVariable("user-id") @NotNull userId: UUID
    ): ResponseEntity<GetLastSolvedQuizResponse> {
        val response = getLastQuizListService.execute(userId)
        return ResponseEntity.ok(response)
    }
}
