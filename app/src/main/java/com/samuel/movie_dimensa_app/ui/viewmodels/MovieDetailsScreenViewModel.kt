package com.samuel.movie_dimensa_app.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieDetailsService
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieReviewService
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieSimilarService
import com.samuel.movie_dimensa_app.data.remote.model.Result
import com.samuel.movie_dimensa_app.data.remote.model.ReviewResults
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsScreenViewModel @Inject constructor(
  private val apiMovieDetailsService: ApiMovieDetailsService,
  private val apiMovieSimilarService: ApiMovieSimilarService,
  private val apiMovieReviewService: ApiMovieReviewService
) : ViewModel() {

  private val _overview = mutableStateOf("")
  val overview: MutableState<String> = _overview
  private val _runtime = mutableIntStateOf(0)
  val runtime: MutableState<Int> = _runtime

  private val _originalTitle = mutableStateOf("")
  val originalTitle: MutableState<String> = _originalTitle

  private val _posterPath = mutableStateOf("")
  val posterPath: MutableState<String> = _posterPath

  private val _voteAverage = mutableDoubleStateOf(0.0)
  val voteAverage: MutableState<Double> = _voteAverage

  private val _genreName = mutableStateOf("")
  val genreName: MutableState<String> = _genreName

  private val _backdropPath = mutableStateOf("")
  val backdropPath: MutableState<String> = _backdropPath

  private val _movieReviews = mutableStateOf<List<ReviewResults>>(emptyList())
  val movieReviews: MutableState<List<ReviewResults>> = _movieReviews

  private val _movieSimilar = mutableStateOf<List<Result>>(emptyList())
  val movieSimilar: MutableState<List<Result>> = _movieSimilar


  fun getMovieDetails(movieId: Int) {
    try {
      viewModelScope.launch {
        val response = apiMovieDetailsService.getMovieDetails(movieId)
        _genreName.value = response.genres.joinToString(separator = " • ") { it.name }
        _originalTitle.value = response.originalTitle
        _overview.value = response.overview
        _posterPath.value = response.posterPath
        _runtime.value = response.runtime
        _voteAverage.value = response.voteAverage
        _backdropPath.value = response.backdropPath
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }

  fun getMovieReviews(movieId: Int) {
    try {
      viewModelScope.launch {
        val response = apiMovieReviewService.getMovieReviews(movieId)
        _movieReviews.value = response.results
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }

  fun getMovieSimilar(movieId: Int) {
    try {
      viewModelScope.launch {
        val response = apiMovieSimilarService.getMovieSimilar(movieId)
        _movieSimilar.value = response.results
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }


}