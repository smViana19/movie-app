package com.samuel.movie_dimensa_app.data.mocks

import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieNowPlayingService
import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieNowPlayingResponse

class ApiMoviePlayingNowMock: ApiMovieNowPlayingService {
  override suspend fun getMoviesNowPlaying(): ApiMovieNowPlayingResponse {
    TODO("Not yet implemented")
  }
}