package com.samuel.movie_dimensa_app.data.remote.api

import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieUpcomingResponse
import retrofit2.http.GET

interface ApiMovieUpcomingService {
  @GET("movie/upcoming")
  suspend fun getMoviesUpcoming() : ApiMovieUpcomingResponse
}