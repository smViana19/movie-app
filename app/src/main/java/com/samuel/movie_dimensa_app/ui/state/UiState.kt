package com.samuel.movie_dimensa_app.ui.state

data class UiState(
  val isLoading: Boolean = false,
  val isError: Boolean = false,
  val errorMessage: String? = null
)