package com.samuel.movie_dimensa_app.di

import com.samuel.movie_dimensa_app.data.remote.APIKeyInterceptor
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieDetailsService
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieNowPlayingService
import com.samuel.movie_dimensa_app.data.remote.api.ApiMoviePopularService
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieReviewService
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieSimilarService
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieTopRatedService
import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieUpcomingService
import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieNowPlayingResponse
import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieReviewsResponse
import com.samuel.movie_dimensa_app.utils.API_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
  @Provides
  fun provideHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .addInterceptor(APIKeyInterceptor())
      .build()
  }

  @Provides
  fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .baseUrl(API_URL)
      .client(okHttpClient)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  @Provides
  fun provideApiMovieDetailsService(retrofit: Retrofit): ApiMovieDetailsService {
    return retrofit.create(ApiMovieDetailsService::class.java)
  }

  @Provides
  fun provideApiMovieNowPlayingService(retrofit: Retrofit): ApiMovieNowPlayingService {
    return retrofit.create(ApiMovieNowPlayingService::class.java)
  }

  @Provides
  fun provideApiMoviePopularService(retrofit: Retrofit): ApiMoviePopularService {
    return retrofit.create(ApiMoviePopularService::class.java)
  }

  @Provides
  fun provideApiMovieReviewService(retrofit: Retrofit): ApiMovieReviewService {
    return retrofit.create(ApiMovieReviewService::class.java)
  }

  @Provides
  fun provideApiMovieSimilarService(retrofit: Retrofit) : ApiMovieSimilarService {
    return retrofit.create(ApiMovieSimilarService::class.java)
  }

  @Provides
  fun provideApiMovieTopRatedService(retrofit: Retrofit): ApiMovieTopRatedService {
    return retrofit.create(ApiMovieTopRatedService::class.java)
  }

  @Provides
  fun provideApiMovieUpcomingService(retrofit: Retrofit): ApiMovieUpcomingService {
    return retrofit.create(ApiMovieUpcomingService::class.java)
  }

}