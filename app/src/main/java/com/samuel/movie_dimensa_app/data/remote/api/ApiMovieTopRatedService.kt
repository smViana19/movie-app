package com.samuel.movie_dimensa_app.data.remote.api

import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieTopRatedResponse
import retrofit2.http.GET

interface ApiMovieTopRatedService {
  @GET("movie/top_rated")
  suspend fun getMoviesTopRated(): ApiMovieTopRatedResponse
}