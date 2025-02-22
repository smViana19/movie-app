package com.samuel.movie_dimensa_app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.samuel.movie_dimensa_app.data.mocks.ApiMovieDetailsServiceMock
import com.samuel.movie_dimensa_app.data.mocks.ApiMovieReviewServiceMock
import com.samuel.movie_dimensa_app.data.mocks.ApiMovieSimilarServiceMock
import com.samuel.movie_dimensa_app.ui.theme.MoviedimensaappTheme
import com.samuel.movie_dimensa_app.ui.viewmodels.MovieDetailsScreenViewModel

@Composable
fun MovieDetailsScreen(
  movieDetailsScreenViewModel: MovieDetailsScreenViewModel = hiltViewModel()
) {
  Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
    Text("OII")
  }
}

@Preview
@Composable
private fun MovieDetailsScreenPreview() {
  MoviedimensaappTheme {
    val apiMoveDetailsService = ApiMovieDetailsServiceMock()
    val apiMovieSimilarService = ApiMovieSimilarServiceMock()
    val apiMovieReviewService = ApiMovieReviewServiceMock()
    val movieDetailsScreenViewModel = MovieDetailsScreenViewModel(apiMoveDetailsService, apiMovieSimilarService, apiMovieReviewService )
    MovieDetailsScreen(movieDetailsScreenViewModel)
  }
}