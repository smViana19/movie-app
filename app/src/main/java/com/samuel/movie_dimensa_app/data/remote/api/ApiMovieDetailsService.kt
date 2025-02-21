package com.samuel.movie_dimensa_app.data.remote.api

import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiMovieDetailsService {
  @GET("movie/{movie_id}")
  suspend fun getMovieDetails(@Path("movie_id") movieId: Int) : ApiMovieDetailsResponse
}