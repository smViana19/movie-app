plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
  alias(libs.plugins.ksp)
  id("com.google.dagger.hilt.android")

}

android {
  namespace = "com.samuel.movie_dimensa_app"
  compileSdk = 35
  android.buildFeatures.buildConfig = true
  defaultConfig {
    applicationId = "com.samuel.movie_dimensa_app"
    minSdk = 29
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"
    buildConfigField ("String", "API_KEY", "\"${project.findProperty("API_KEY") ?: ""}\"")
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = "11"
  }
  buildFeatures {
    compose = true
  }
}

dependencies {

  ksp(libs.hilt.android.compiler)

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.activity.compose)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.ui)
  implementation(libs.androidx.ui.graphics)
  implementation(libs.androidx.ui.tooling.preview)
  implementation(libs.androidx.material3)
  implementation ("androidx.core:core-splashscreen:1.0.1")
  implementation(libs.coil.compose)
  implementation(libs.coil.network.okhttp)

  implementation(libs.hilt.android)
  implementation(libs.hilt.compose.navigation)

  implementation(libs.retrofit)
  implementation(libs.retrofit.gson.convertor)

  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.ui.test.junit4)
  debugImplementation(libs.androidx.ui.tooling)
  debugImplementation(libs.androidx.ui.test.manifest)
}