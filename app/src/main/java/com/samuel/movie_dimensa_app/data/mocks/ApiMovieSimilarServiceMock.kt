package com.samuel.movie_dimensa_app.data.mocks

import com.samuel.movie_dimensa_app.data.remote.api.ApiMovieSimilarService
import com.samuel.movie_dimensa_app.data.remote.model.ApiMovieSimilarResponse

class ApiMovieSimilarServiceMock : ApiMovieSimilarService {

  override suspend fun getMovieSimilar(movieId: Int): ApiMovieSimilarResponse {
    TODO("Not yet implemented")
  }

}
