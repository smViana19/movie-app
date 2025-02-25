package com.samuel.movie_dimensa_app.handler

import java.io.IOException
import java.net.SocketTimeoutException

sealed class AppException(
  message: String? = null
) : Exception(message) {
  data object TimeoutException : AppException("Tempo limite excedido") {
    private fun readResolve(): Any = TimeoutException
  }

  data object NetworkException : AppException("Falha na conexão") {
    private fun readResolve(): Any = NetworkException
  }

  data object UnknownException : AppException("Erro desconhecido") {
    private fun readResolve(): Any = UnknownException
  }
}

object ExceptionMapper {
  fun mapException(e: Exception): AppException {
    return when (e) {
      is SocketTimeoutException -> AppException.TimeoutException
      is IOException -> AppException.NetworkException
      else -> AppException.UnknownException
    }
  }
}