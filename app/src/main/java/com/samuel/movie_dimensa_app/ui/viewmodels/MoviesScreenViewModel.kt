package com.samuel.movie_dimensa_app.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieNowPlayingService
import com.samuel.movie_dimensa_app.data.remote.api.ApiMoviePopularService
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieTopRatedService
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieUpcomingService
import com.samuel.movie_dimensa_app.data.remote.model.Result
import com.samuel.movie_dimensa_app.handler.ExceptionMapper
import com.samuel.movie_dimensa_app.ui.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
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

  private val _isLoading = mutableStateOf(false)
  val isLoading: MutableState<Boolean> = _isLoading

  private val _uiState = mutableStateOf(UiState())
  val uiState: State<UiState> = _uiState

  fun getAllMovies() {
    _uiState.value = UiState(
      isLoading = true
    )
    viewModelScope.launch {
      try {
        val nowPlayingMoviesRequest = async { getNowPlayingMovies() }
        val upcomingMoviesRequest = async { getUpComingMovies() }
        val popularMoviesRequest = async { getPopularMovies() }
        val topRatedMoviesRequest = async { getTopRatedMovies() }

        nowPlayingMoviesRequest.await()
        upcomingMoviesRequest.await()
        popularMoviesRequest.await()
        topRatedMoviesRequest.await()
      } catch (e: Exception) {
        val appException = ExceptionMapper.mapException(e)
        _uiState.value = UiState(
          isLoading = false,
          isError = true,
          errorMessage = appException.message
        )
        e.printStackTrace()
      } finally {
        _uiState.value = UiState(
          isLoading = false,
        )
      }
    }
  }

  private suspend fun getNowPlayingMovies() {
    val response = apiMovieNowPlayingService.getMoviesNowPlaying()
    _moviesNowPlaying.value = response.results
    if(!response.success) {
      _uiState.value = UiState(isError = true, errorMessage = response.statusMessage)
    }
  }

  private suspend fun getUpComingMovies() {
    val response = apiMovieUpcomingService.getMoviesUpcoming()
    _moviesUpComing.value = response.results

  }

  private suspend fun getPopularMovies() {
    val response = apiMoviePopularService.getMoviesPopular()
    _moviesPopular.value = response.results
  }

  private suspend fun getTopRatedMovies() {
    val response = apiMovieTopRatedService.getMoviesTopRated()
    _moviesTopRated.value = response.results
  }

}