package com.example.kotlinpractice.global.error.exception


open class BusinessException(
        val errorProperty: ErrorProperty
): RuntimeException() {
}