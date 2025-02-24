package com.samuel.movie_dimensa_app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.samuel.movie_dimensa_app.ui.screens.MovieDetailsScreen
import com.samuel.movie_dimensa_app.ui.screens.MoviesScreen
import com.samuel.movie_dimensa_app.ui.viewmodels.MovieDetailsScreenViewModel
import com.samuel.movie_dimensa_app.ui.viewmodels.MoviesScreenViewModel

@Composable
fun MainNavigation() {
  val navController = rememberNavController()
  val moviesScreenViewModel: MoviesScreenViewModel = hiltViewModel()
  val movieDetailsScreenViewModel: MovieDetailsScreenViewModel = hiltViewModel()

  NavHost(
    navController = navController,
    startDestination = Screens.MOVIES_SCREEN.name
  ) {
    composable(route = Screens.MOVIES_SCREEN.name) {
      MoviesScreen(navController, moviesScreenViewModel)
    }

    composable(
      route = "${Screens.MOVIE_DETAILS_SCREEN.name}?movieId={movieId}",
      arguments = listOf(
        navArgument("movieId") {
          type = NavType.IntType
        }
      )
    ) { navBackStackEntry ->
      val movieId = navBackStackEntry.arguments?.getInt("movieId") ?: -1
      MovieDetailsScreen(movieId, navController, movieDetailsScreenViewModel)
    }
  }

}