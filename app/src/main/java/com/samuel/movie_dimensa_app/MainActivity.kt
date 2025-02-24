package com.samuel.movie_dimensa_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.samuel.movie_dimensa_app.ui.navigation.MainNavigation
import com.samuel.movie_dimensa_app.ui.theme.MoviedimensaappTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    val splashScreen = installSplashScreen()
    var keepSplashScreenVisible = true
    splashScreen.setKeepOnScreenCondition {
      keepSplashScreenVisible
    }

    runBlocking {
      delay(2000)
      keepSplashScreenVisible = false
    }
    super.onCreate(savedInstanceState)
    setContent {
      MoviedimensaappTheme {
        MainNavigation()
      }
    }
  }
}

