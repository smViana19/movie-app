package com.samuel.movie_dimensa_app.data.remote

import com.samuel.movie_dimensa_app.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class APIKeyInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val request = chain.request().newBuilder()
      .addHeader("Authorization", "Bearer ${BuildConfig.API_KEY}")
      .build()
    return chain.proceed(request)
  }

}