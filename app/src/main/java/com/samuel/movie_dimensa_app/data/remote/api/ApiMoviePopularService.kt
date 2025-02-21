package com.samuel.movie_dimensa_app.data.remote.api

import com.samuel.movie_dimensa_app.data.remote.model.ApiMoviePopularResponse
import retrofit2.http.GET

interface ApiMoviePopularService {
  @GET("movie/popular")
  suspend fun getMoviesPopular(): ApiMoviePopularResponse
}