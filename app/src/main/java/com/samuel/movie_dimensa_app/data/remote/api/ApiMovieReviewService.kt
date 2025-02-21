package com.samuel.movie_dimensa_app.data.remote.api

import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieReviewsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiMovieReviewService {
  @GET("movie/{movie_id}/reviews")
  suspend fun getMovieReviews(@Path("movie_id") movieId: Int): ApiMovieReviewsResponse
}