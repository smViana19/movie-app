package com.samuel.movie_dimensa_app.data.remote.model

import com.google.gson.annotations.SerializedName

data class ApiMovieReviewsResponse(
  val id: Int,
  val page: Int,
  val results: List<ReviewResults>,
  @SerializedName("total_pages")
  val totalPages: Int,
  @SerializedName("total_results")
  val totalResults: Int
)

data class ReviewResults(
  val author: String,
  @SerializedName("author_details")
  val authorDetails: Details,
  val content: String,
  val id: String,
  val url: String
)

data class Details(
  val name: String,
  val usernmae: String,
  @SerializedName("avatar_path")
  val avatarPath: String,
  val rating: Int,
)