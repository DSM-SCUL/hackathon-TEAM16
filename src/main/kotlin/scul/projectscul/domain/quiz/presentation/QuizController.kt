package scul.projectscul.domain.quiz.presentation

import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import scul.projectscul.domain.quiz.service.GetQuizService
import java.util.*

@RequestMapping("/scul/user")
@RestController
class QuizController (
        private val getQuizService: GetQuizService
) {

    @GetMapping("/{quiz-id}")
    fun getQuiz(
            @PathVariable("quiz-id") @NotNull quizId: Long
    ) {
        getQuizService.execute(quizId)
    }

}
