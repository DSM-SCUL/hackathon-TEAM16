package scul.projectscul.domain.quiz.exception

import com.example.kotlinpractice.global.error.ErrorCode
import com.example.kotlinpractice.global.error.exception.BusinessException

object TodayQuizOverException : BusinessException(
        ErrorCode.PASSWORD_MIS_MATCH
)