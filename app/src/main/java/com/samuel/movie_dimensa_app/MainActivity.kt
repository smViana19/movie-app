package com.samuel.movie_dimensa_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.samuel.movie_dimensa_app.ui.screens.MovieDetailsScreen
import com.samuel.movie_dimensa_app.ui.screens.MoviesScreen
import com.samuel.movie_dimensa_app.ui.theme.MoviedimensaappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MoviedimensaappTheme {
        MovieDetailsScreen()
      }
    }
  }
}
