package com.samuel.movie_dimensa_app.utils

fun minutesToHours(minutes: Int): String {
  val hours = minutes / 60
  val remainingMinutes = minutes % 60
  return when {
    hours == 0 && remainingMinutes == 0 -> "0 minuto(s)"
    hours == 0 -> "$remainingMinutes minuto(s)"
    remainingMinutes == 0 -> "$hours hora(s)"
    else -> "$hours hora(s) $remainingMinutes minuto(s)"
  }
}