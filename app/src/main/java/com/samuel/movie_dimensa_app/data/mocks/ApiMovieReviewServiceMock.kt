package com.samuel.movie_dimensa_app.data.mocks

import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieReviewService
import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieReviewsResponse

class ApiMovieReviewServiceMock : ApiMovieReviewService {
  override suspend fun getMovieReviews(movieId: Int): ApiMovieReviewsResponse {
    TODO("Not yet implemented")
  }
}