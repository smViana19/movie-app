package com.samuel.movie_dimensa_app.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieNowPlayingService
import com.samuel.movie_dimensa_app.data.remote.api.ApiMoviePopularService
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieTopRatedService
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieUpcomingService
import com.samuel.movie_dimensa_app.data.remote.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesScreenViewModel @Inject constructor(
  private val apiMovieNowPlayingService: ApiMovieNowPlayingService,
  private val apiMovieUpcomingService: ApiMovieUpcomingService,
  private val apiMoviePopularService: ApiMoviePopularService,
  private val apiMovieTopRatedService: ApiMovieTopRatedService
) : ViewModel() {

  private val _moviesNowPlaying = mutableStateOf<List<Result>>(emptyList())
  val moviesNowPlaying: MutableState<List<Result>> = _moviesNowPlaying

  private val _moviesUpComing = mutableStateOf<List<Result>>(emptyList())
  val moviesUpComing: MutableState<List<Result>> = _moviesUpComing

  private val _moviesPopular = mutableStateOf<List<Result>>(emptyList())
  val moviesPopular: MutableState<List<Result>> = _moviesPopular

  private val _moviesTopRated = mutableStateOf<List<Result>>(emptyList())
  val moviesTopRated: MutableState<List<Result>> = _moviesTopRated

  init {
    getNowPlayingMovies()
    getUpComingMovies()
    getPopularMovies()
    getTopRatedMovies()
  }

  fun getNowPlayingMovies() {
    viewModelScope.launch {
      try {
        val response = apiMovieNowPlayingService.getMoviesNowPlaying()
        _moviesNowPlaying.value = response.results
      } catch (e: Exception) {
        //TODO: EXCEPTIONS PERSONALIZADAS
        e.printStackTrace()
      }
    }

  }

  fun getUpComingMovies() {
    try {
      viewModelScope.launch {
        val response = apiMovieUpcomingService.getMoviesUpcoming()
        _moviesUpComing.value = response.results
        println("Upcoming movies: ${_moviesUpComing.value}")
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }

  fun getPopularMovies() {
    try {
      viewModelScope.launch {
        val response = apiMoviePopularService.getMoviesPopular()
        _moviesPopular.value = response.results
        println("popular: ${_moviesPopular.value}")
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }

  fun getTopRatedMovies() {
    try {
      viewModelScope.launch {
        val response = apiMovieTopRatedService.getMoviesTopRated()
        _moviesTopRated.value = response.results
        println("top rated: ${_moviesTopRated.value}")
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }
}