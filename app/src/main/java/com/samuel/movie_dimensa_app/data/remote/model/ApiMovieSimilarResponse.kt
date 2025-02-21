package com.samuel.movie_dimensa_app.data.remote.model

import com.google.gson.annotations.SerializedName

data class ApiMovieSimilarResponse(
  val page: Int,
  val results: List<Result>,
  @SerializedName("total_pages")
  val totalPages: Int,
  @SerializedName("total_results")
  val totalResults: Int
)
