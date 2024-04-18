package scul.projectscul.domain.user.exception

import com.example.kotlinpractice.global.error.ErrorCode
import com.example.kotlinpractice.global.error.exception.BusinessException

object PasswordMisMatchException : BusinessException(
        ErrorCode.PASSWORD_MIS_MATCH
)