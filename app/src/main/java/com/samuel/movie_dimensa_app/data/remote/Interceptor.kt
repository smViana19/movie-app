package com.samuel.movie_dimensa_app.data.remote

import com.samuel.movie_dimensa_app.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class APIKeyInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val originalRequest = chain.request()
    val originalUrl = originalRequest.url

    val newUrl = originalUrl.newBuilder()
      .addQueryParameter("api_key", "dea3c9e13466693df3ee618d614ed5d1")
      .build()

    val newRequest = originalRequest.newBuilder()
      .url(newUrl)
      .build()
    return chain.proceed(newRequest)
  }

}