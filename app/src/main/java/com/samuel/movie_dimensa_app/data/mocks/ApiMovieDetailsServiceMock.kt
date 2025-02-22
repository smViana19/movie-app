package com.samuel.movie_dimensa_app.data.mocks

import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieDetailsService
import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieDetailsResponse

class ApiMovieDetailsServiceMock : ApiMovieDetailsService {
  override suspend fun getMovieDetails(movieId: Int): ApiMovieDetailsResponse {
    TODO("Not yet implemented")
  }

}
