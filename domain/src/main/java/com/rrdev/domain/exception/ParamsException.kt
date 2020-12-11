package com.rrdev.domain.exception


class MissingParamsException : Exception("Params must not be null.")
class EmptyFieldException(fieldName: String) : Exception("$fieldName campo obrigatório.")