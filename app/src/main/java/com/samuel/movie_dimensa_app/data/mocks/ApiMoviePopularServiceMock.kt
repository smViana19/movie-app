package com.samuel.movie_dimensa_app.data.mocks

import com.samuel.movie_dimensa_app.data.remote.api.ApiMoviePopularService
import com.samuel.movie_dimensa_app.data.remote.model.ApiMoviePopularResponse

class ApiMoviePopularServiceMock: ApiMoviePopularService {
  override suspend fun getMoviesPopular(): ApiMoviePopularResponse {
    TODO("Not yet implemented")
  }
}