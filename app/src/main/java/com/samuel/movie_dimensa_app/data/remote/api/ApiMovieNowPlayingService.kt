package com.samuel.movie_dimensa_app.data.remote.api

import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieNowPlayingResponse
import retrofit2.http.GET

interface ApiMovieNowPlayingService {
  @GET("movie/now_playing")
  suspend fun getMoviesNowPlaying(): ApiMovieNowPlayingResponse

}