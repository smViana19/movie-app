package com.samuel.movie_dimensa_app.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.samuel.movie_dimensa_app.R
import com.samuel.movie_dimensa_app.data.mocks.ApiMoviePlayingNowMock
import com.samuel.movie_dimensa_app.data.mocks.ApiMoviePopularServiceMock
import com.samuel.movie_dimensa_app.data.mocks.ApiMovieTopRatedServiceMock
import com.samuel.movie_dimensa_app.data.mocks.ApiMovieUpcomingServiceMock
import com.samuel.movie_dimensa_app.ui.components.AppLoader
import com.samuel.movie_dimensa_app.ui.navigation.Screens
import com.samuel.movie_dimensa_app.ui.theme.MoviedimensaappTheme
import com.samuel.movie_dimensa_app.ui.theme.openSansFontFamily
import com.samuel.movie_dimensa_app.ui.viewmodels.MoviesScreenViewModel
import com.samuel.movie_dimensa_app.utils.POSTER_URL
import kotlin.system.exitProcess

@Composable
fun MoviesScreen(
  navController: NavController,
  moviesScreenViewModel: MoviesScreenViewModel = hiltViewModel()
) {
  LaunchedEffect(Unit) {
    moviesScreenViewModel.getNowPlayingMovies()
    moviesScreenViewModel.getUpComingMovies()
    moviesScreenViewModel.getPopularMovies()
    moviesScreenViewModel.getTopRatedMovies()
  }
  BackHandler {
    exitProcess(0)
  }
  Column(
    modifier = Modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState())
      .background(color = Color(0xFF1C1A29))
      .zIndex(0.5f)
  ) {

    Row(
      modifier = Modifier
        .fillMaxWidth(),
      horizontalArrangement = Arrangement.Center
    ) {
      Icon(
        painter = painterResource(R.drawable.logo),
        contentDescription = stringResource(R.string.app_logo),
        tint = Color.Unspecified
      )
    }
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, top = 16.dp)
    ) {
      Row(modifier = Modifier.fillMaxWidth()) {
        Text(
          text = stringResource(R.string.on_display),
          color = Color(0xFFDEDDDF),
          fontFamily = openSansFontFamily,
          fontWeight = FontWeight(600),
          fontSize = 21.sp
        )
      }
      Spacer(modifier = Modifier.height(10.dp))
      LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
      ) {
        items(moviesScreenViewModel.moviesNowPlaying.value) { movie ->
          AsyncImage(
            modifier = Modifier
              .size(width = 150.dp, height = 200.dp)
              .clip(RoundedCornerShape(12.dp))
              .clickable {
                navController.navigate("${Screens.MOVIE_DETAILS_SCREEN.name}?movieId=${movie.id}")
              },
            model = "$POSTER_URL${movie.posterPath}",
            contentDescription = stringResource(R.string.movie_poster),
            contentScale = ContentScale.Crop
          )
        }
      }
    }
    //FIM EXIBICAO
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, top = 16.dp)
    ) {
      Row(modifier = Modifier.fillMaxWidth()) {
        Text(
          text = stringResource(R.string.upcoming),
          color = Color(0xFFDEDDDF),
          fontSize = 21.sp,
          //todo adicionar font family open sans
        )
      }
      Spacer(modifier = Modifier.height(10.dp))
      LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
      ) {
        items(moviesScreenViewModel.moviesUpComing.value) { movie ->
          AsyncImage(
            modifier = Modifier
              .size(width = 150.dp, height = 225.dp)
              .clip(RoundedCornerShape(12.dp))
              .clickable {
                navController.navigate("${Screens.MOVIE_DETAILS_SCREEN.name}?movieId=${movie.id}")
              },
            model = "$POSTER_URL${movie.posterPath}",
            contentDescription = stringResource(R.string.movie_poster),
            contentScale = ContentScale.Crop
          )
        }
      }
    }
    //FIM EMBREVE
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, top = 16.dp)
    ) {
      Row(modifier = Modifier.fillMaxWidth()) {
        Text(
          text = stringResource(R.string.most_popular),
          color = Color(0xFFDEDDDF),
          fontSize = 21.sp,
          //todo adicionar font family open sans
        )
      }
      Spacer(modifier = Modifier.height(10.dp))
      LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
      ) {
        items(moviesScreenViewModel.moviesPopular.value) { movie ->
          AsyncImage(
            modifier = Modifier
              .size(width = 150.dp, height = 225.dp)
              .clip(RoundedCornerShape(12.dp))
              .clickable {
                navController.navigate("${Screens.MOVIE_DETAILS_SCREEN.name}?movieId=${movie.id}")
              },
            model = "$POSTER_URL${movie.posterPath}",
            contentDescription = stringResource(R.string.movie_poster),
            contentScale = ContentScale.Crop
          )
        }
      }
    }
    //FIM populares
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, top = 16.dp, bottom = 28.dp)
    ) {
      Row(modifier = Modifier.fillMaxWidth()) {
        Text(
          text = stringResource(R.string.top_rated),
          color = Color(0xFFDEDDDF),
          fontSize = 21.sp,
          //todo adicionar font family open sans
        )
      }
      Spacer(modifier = Modifier.height(10.dp))
      LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
      ) {
        items(moviesScreenViewModel.moviesTopRated.value) { movie ->
          AsyncImage(
            modifier = Modifier
              .size(width = 150.dp, height = 225.dp)
              .clip(RoundedCornerShape(12.dp))
              .clickable {
                navController.navigate("${Screens.MOVIE_DETAILS_SCREEN.name}?movieId=${movie.id}")
              },
            model = "$POSTER_URL${movie.posterPath}",
            contentDescription = stringResource(R.string.movie_poster),
            contentScale = ContentScale.Crop
          )
        }
      }
    }

    if(moviesScreenViewModel.isLoading.value) {
      AppLoader()
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun MoviesScreenPreview() {
  val navController = rememberNavController()
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
    MoviesScreen(navController, moviesScreenViewModel)
  }
}