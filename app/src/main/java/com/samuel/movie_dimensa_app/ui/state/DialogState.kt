package com.samuel.movie_dimensa_app.ui.state

data class DialogState (
  val isOpen: Boolean = false,
  val title: String? = "Erro",
  val message: String? = null,
  val onDismiss: () -> Unit = {}
)