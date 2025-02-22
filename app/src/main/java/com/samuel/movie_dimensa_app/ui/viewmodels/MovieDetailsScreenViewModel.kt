package com.samuel.movie_dimensa_app.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieDetailsService
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieReviewService
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieSimilarService
import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieDetailsResponse
import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieReviewsResponse
import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieSimilarResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsScreenViewModel @Inject constructor(
  private val apiMovieDetailsService: ApiMovieDetailsService,
  private val apiMovieSimilarService: ApiMovieSimilarService,
  private val apiMovieReviewService: ApiMovieReviewService
) : ViewModel() {

  private val _movieDetails = mutableStateOf<ApiMovieDetailsResponse?>(null)
  val movieDetails: MutableState<ApiMovieDetailsResponse?> = _movieDetails

  private val _movieReviews = mutableStateOf<ApiMovieReviewsResponse?>(null)
  val movieReviews: MutableState<ApiMovieReviewsResponse?> = _movieReviews

  private val _movieSimilar = mutableStateOf<ApiMovieSimilarResponse?>(null)
  val movieSimilar: MutableState<ApiMovieSimilarResponse?> = _movieSimilar

  init {
    getMovieDetails(movieId = 939243)
    getMovieReviews(movieId = 939243)
    getMovieSimilar(movieId = 939243)
  }

  fun getMovieDetails(movieId: Int) {
    try {
      viewModelScope.launch {
        val response = apiMovieDetailsService.getMovieDetails(movieId)
        _movieDetails.value = response
        println("movie details: ${_movieDetails.value}")
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }

  fun getMovieReviews(movieId: Int) {
    try {
      viewModelScope.launch {
        val response = apiMovieReviewService.getMovieReviews(movieId)
        _movieReviews.value = response
        println("movie reviews: ${_movieReviews.value}")
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }

  fun getMovieSimilar(movieId: Int) {
    try {
      viewModelScope.launch {
        val response = apiMovieSimilarService.getMovieSimilar(movieId)
        _movieSimilar.value = response
        println("similar movies: ${_movieSimilar.value}")
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }


}