package com.samuel.movie_dimensa_app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.samuel.movie_dimensa_app.data.mocks.ApiMoviePlayingNowMock
import com.samuel.movie_dimensa_app.data.mocks.ApiMoviePopularServiceMock
import com.samuel.movie_dimensa_app.data.mocks.ApiMovieTopRatedServiceMock
import com.samuel.movie_dimensa_app.data.mocks.ApiMovieUpcomingServiceMock
import com.samuel.movie_dimensa_app.data.remote.api.ApiMoviePopularService
import com.samuel.movie_dimensa_app.ui.theme.MoviedimensaappTheme
import com.samuel.movie_dimensa_app.ui.viewmodels.MovieDetailsScreenViewModel
import com.samuel.movie_dimensa_app.ui.viewmodels.MoviesScreenViewModel

@Composable
fun MoviesScreen(
  moviesScreenViewModel: MoviesScreenViewModel = hiltViewModel()
) {
  LaunchedEffect(Unit) {
    moviesScreenViewModel.getNowPlayingMovies()
  }
  Column {
    Text("TESTE VIEWMODELLL")
  }
}

@Preview
@Composable
private fun MoviesScreenPreview() {
  val apiMovieNowPlayingService = ApiMoviePlayingNowMock()
  val apiMovieUpcomingService = ApiMovieUpcomingServiceMock()
  val apiMoviePopularService = ApiMoviePopularServiceMock()
  val apiMovieTopRatedService = ApiMovieTopRatedServiceMock()
  val moviesScreenViewModel = MoviesScreenViewModel(
    apiMovieNowPlayingService,
    apiMovieUpcomingService,
    apiMoviePopularService,
    apiMovieTopRatedService
  )
  MoviedimensaappTheme {
    MoviesScreen(moviesScreenViewModel)
  }
}