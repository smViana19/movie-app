package com.samuel.movie_dimensa_app.data.mocks

import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieUpcomingService
import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieUpcomingResponse

class ApiMovieUpcomingServiceMock : ApiMovieUpcomingService{
  override suspend fun getMoviesUpcoming(): ApiMovieUpcomingResponse {
    TODO("Not yet implemented")
  }
}