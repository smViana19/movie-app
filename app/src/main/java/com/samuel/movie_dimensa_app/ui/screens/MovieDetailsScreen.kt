package com.samuel.movie_dimensa_app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.samuel.movie_dimensa_app.R
import com.samuel.movie_dimensa_app.data.mocks.ApiMovieDetailsServiceMock
import com.samuel.movie_dimensa_app.data.mocks.ApiMovieReviewServiceMock
import com.samuel.movie_dimensa_app.data.mocks.ApiMovieSimilarServiceMock
import com.samuel.movie_dimensa_app.ui.components.AppLoader
import com.samuel.movie_dimensa_app.ui.navigation.Screens
import com.samuel.movie_dimensa_app.ui.theme.MoviedimensaappTheme
import com.samuel.movie_dimensa_app.ui.theme.openSansFontFamily
import com.samuel.movie_dimensa_app.ui.viewmodels.MovieDetailsScreenViewModel
import com.samuel.movie_dimensa_app.utils.BACKDROP_URL
import com.samuel.movie_dimensa_app.utils.POSTER_URL
import com.samuel.movie_dimensa_app.utils.minutesToHours

@Composable
fun MovieDetailsScreen(
  movieId: Int,
  navController: NavController,
  movieDetailsScreenViewModel: MovieDetailsScreenViewModel = hiltViewModel()
) {
  LaunchedEffect(Unit) {
    movieDetailsScreenViewModel.getAllMovieDetails(movieId)
  }
  Column(
    modifier = Modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState())
      .background(Color(0xFF1C1A29))
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(375.dp)
    ) {
      AsyncImage(
        modifier = Modifier
          .fillMaxSize()
          .clip(RoundedCornerShape(bottomStart = 27.dp, bottomEnd = 27.dp)),
        model = "$BACKDROP_URL${movieDetailsScreenViewModel.backdropPath.value}",
        contentDescription = "Movie backdrop",
        contentScale = ContentScale.Crop
      )
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding()
          .background(
            Color.Black.copy(alpha = 0.5f),
            RoundedCornerShape(bottomStart = 27.dp, bottomEnd = 27.dp)
          ),
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(start = 21.dp, top = 24.dp),
          verticalAlignment = Alignment.Bottom
        ) {
          IconButton(
            onClick = {
              navController.navigate(Screens.MOVIES_SCREEN.name)
            }
          ) {
            Icon(
              painter = painterResource(R.drawable.arrow_left),
              contentDescription = "icon back",
              tint = Color.Unspecified
            )
          }
        }
        Column(
          modifier = Modifier
            .fillMaxHeight()
            .padding(start = 20.dp, end = 20.dp, bottom = 18.dp),
          verticalArrangement = Arrangement.Bottom
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()

          ) {
            Column(
              modifier = Modifier.weight(1f)
            ) {
              Text(
                text = movieDetailsScreenViewModel.originalTitle.value,
                color = Color.White,
                fontFamily = openSansFontFamily,
                fontWeight = FontWeight(600),
                fontSize = 21.sp

              )
              Text(
                text = minutesToHours(movieDetailsScreenViewModel.runtime.value),
                color = Color(0XFFDEDDDF),
                fontFamily = openSansFontFamily,
                fontWeight = FontWeight(400),
                fontSize = 13.sp
              )
              Text(
                text = movieDetailsScreenViewModel.genreName.value,
                color = Color(0XFFDEDDDF),
                fontFamily = openSansFontFamily,
                fontWeight = FontWeight(400),
                fontSize = 13.sp
              )
              Row(
                verticalAlignment = Alignment.CenterVertically
              ) {
                Icon(
                  painterResource(R.drawable.star),
                  contentDescription = "star icon",
                  tint = Color.Unspecified
                )
                Text(
                  modifier = Modifier.padding(start = 4.dp),
                  text = "${movieDetailsScreenViewModel.voteAverage.value}/10 Média de votos",
                  color = Color(0xFF777777),
                  fontWeight = FontWeight(400),
                  fontSize = 13.sp
                )
              }
            }
            Column(
              modifier = Modifier
                .weight(1f),
              horizontalAlignment = Alignment.End
            ) {
              AsyncImage(
                modifier = Modifier
                  .size(width = 159.dp, height = 203.dp)
                  .clip(RoundedCornerShape(12.dp)),
                model = "$POSTER_URL${movieDetailsScreenViewModel.posterPath.value}",
                contentDescription = stringResource(R.string.movie_poster),
                contentScale = ContentScale.Crop
              )
            }
          }
        }
      }
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 13.dp, start = 20.dp, end = 20.dp)
    ) {
      Text(
        text = "Sinopse",
        color = Color(0xFFDEDDDF),
        fontFamily = openSansFontFamily,
        fontWeight = FontWeight(600),
        fontSize = 21.sp
      )
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp, start = 20.dp, end = 20.dp)
    ) {
      Text(
        text = movieDetailsScreenViewModel.overview.value,
        color = Color(0XFFDEDDDF),
        fontFamily = openSansFontFamily,
        lineHeight = 23.sp,
        fontWeight = FontWeight(400),
        fontSize = 13.sp
      )
    }

    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 18.dp, start = 20.dp, end = 20.dp)
    ) {
      Text(
        text = "Comentários",
        color = Color(0xFFDEDDDF),
        fontFamily = openSansFontFamily,
        fontWeight = FontWeight(600),
        fontSize = 21.sp
      )
    }
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(262.dp)
        .padding(top = 10.dp, start = 20.dp, end = 20.dp)
        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(12.dp))
    ) {
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .background(color = Color(0xFF242135), shape = RoundedCornerShape(12.dp))
      ) {
        items(movieDetailsScreenViewModel.movieReviews.value) { review ->
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(start = 14.dp, end = 14.dp, top = 20.dp)
          ) {
            Text(
              modifier = Modifier.padding(bottom = 12.dp),
              text = review.author,
              color = Color(0xFFDEDDDF),
              fontFamily = openSansFontFamily,
              fontWeight = FontWeight(600),
              fontSize = 13.sp
            )
            Text(
              modifier = Modifier.padding(bottom = 12.dp),
              text = review.content,
              color = Color(0xFFA4A3A9),
              lineHeight = 14.sp,
              fontFamily = openSansFontFamily,
              fontWeight = FontWeight(400),
              maxLines = 3,
              fontSize = 12.sp
            )
            HorizontalDivider(modifier = Modifier.height(1.dp), color = Color(0xFF413E50))
          }
        }
      }
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 18.dp, bottom = 10.dp, start = 20.dp)
    ) {
      Text(
        text = "Mais como este",
        color = Color(0xFFDEDDDF),
        fontFamily = openSansFontFamily,
        fontWeight = FontWeight(600),
        fontSize = 21.sp
      )
    }

    LazyRow(
      modifier = Modifier.padding(start = 20.dp, bottom = 28.dp),
      horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      items(movieDetailsScreenViewModel.movieSimilar.value) { similarMovie ->
        AsyncImage(
          modifier = Modifier
            .size(width = 150.dp, height = 200.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable {
              navController.navigate("${Screens.MOVIE_DETAILS_SCREEN.name}?movieId=${similarMovie.id}")
            },
          model = "$POSTER_URL${similarMovie.posterPath}",
          contentDescription = stringResource(R.string.movie_poster),
          contentScale = ContentScale.Crop
        )
      }
    }
  }
  if(movieDetailsScreenViewModel.uiState.value.isLoading) {
    AppLoader()
  }
}

@Preview(showBackground = true)
@Composable
private fun MovieDetailsScreenPreview() {
  MoviedimensaappTheme {
    val movieId = 1
    val navController = rememberNavController()
    val apiMoveDetailsService = ApiMovieDetailsServiceMock()
    val apiMovieSimilarService = ApiMovieSimilarServiceMock()
    val apiMovieReviewService = ApiMovieReviewServiceMock()
    val movieDetailsScreenViewModel = MovieDetailsScreenViewModel(
      apiMoveDetailsService,
      apiMovieSimilarService,
      apiMovieReviewService
    )
    MovieDetailsScreen(movieId, navController, movieDetailsScreenViewModel)
  }
}