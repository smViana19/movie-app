package com.samuel.movie_dimensa_app.data.remote.api

import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieNowPlayingResponse
import com.samuel.movie_dimensa_app.utils.ENGLISH
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiMovieNowPlayingService {
  @GET("movie/now_playing")
  suspend fun getMoviesNowPlaying(@Path("language") language: String = ENGLISH): ApiMovieNowPlayingResponse

}