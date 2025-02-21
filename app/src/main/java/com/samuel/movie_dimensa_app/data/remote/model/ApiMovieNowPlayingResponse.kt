package com.samuel.movie_dimensa_app.data.remote.model

import com.google.gson.annotations.SerializedName

data class ApiMovieNowPlayingResponse(
  val dates: Dates,
  val page: Int,
  val results: List<Result>,
  @SerializedName("total_pages")
  val totalPageSize: Int,
  @SerializedName("total_results")
  val totalResults: Int
)

data class Dates(
  val maximum: String,
  val minimum: String
)

