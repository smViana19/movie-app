package com.samuel.movie_dimensa_app.data.remote.api

import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieSimilarResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiMovieSimilarService {
  @GET("movie/{movie_id}/similar")
  suspend fun getMovieSimilar(@Path("movie_id") movieId: Int): ApiMovieSimilarResponse
}