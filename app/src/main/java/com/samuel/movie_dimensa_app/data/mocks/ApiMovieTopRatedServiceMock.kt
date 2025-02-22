package com.samuel.movie_dimensa_app.data.mocks

import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieTopRatedService
import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieTopRatedResponse

class ApiMovieTopRatedServiceMock : ApiMovieTopRatedService {
  override suspend fun getMoviesTopRated(): ApiMovieTopRatedResponse {
    TODO("Not yet implemented")
  }
}