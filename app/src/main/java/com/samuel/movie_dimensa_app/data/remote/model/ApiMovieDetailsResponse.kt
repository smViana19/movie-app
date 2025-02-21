package com.samuel.movie_dimensa_app.data.remote.model

import com.google.gson.annotations.SerializedName

data class ApiMovieDetailsResponse(
  val adult: Boolean,
  @SerializedName("backdrop_path")
  val backdropPath: String,
  @SerializedName("belongs_to_collection")
  val belongsToCollection: Collection,
  val budget: Int,
  val genres: List<Genre>,
  val homepage: String,
  val id: Int,
  @SerializedName("imdb_id")
  val imdbId: String,
  @SerializedName("origin_country")
  val originCountry: List<String>,
  @SerializedName("original_language")
  val originalLanguage: String,
  @SerializedName("original_title")
  val originalTitle: String,
  val overview: String,
  val popularity: Double,
  @SerializedName("poster_path")
  val posterPath: String,
  @SerializedName("production_companies")
  val productionCompanies: List<ProductionCompanies>,
  @SerializedName("production_countries")
  val productionCountries: List<ProductionCountries>,
  @SerializedName("release_date")
  val releaseDate: String,
  val revenue: Int,
  val runtime: Int,
  @SerializedName("spoken_languages")
  val spokenLanguages: List<SpokenLanguages>,
  val status: String,
  val tagline: String,
  val title: String,
  val video: Boolean,
  @SerializedName("vote_average")
  val voteAverage: Double,
  @SerializedName("vote_count")
  val voteCount: Int
)

data class Collection(
  val id: Int,
  val name: String,
  @SerializedName("poster_path")
  val posterPath: String,
  @SerializedName("backdrop_path")
  val backdropPath: String
)

data class Genre(
  val id: Int,
  val name: String
)

data class ProductionCompanies(
  val id: Int,
  @SerializedName("logo_path")
  val logoPath: String?,
  val name: String,
  @SerializedName("origin_country")
  val originCountry: String
)

data class ProductionCountries(
  @SerializedName("iso_3166_1")
  val iso31661: String,
  val name: String,
)

data class SpokenLanguages(
  @SerializedName("english_name")
  val englishName: String,
  val name: String
)
