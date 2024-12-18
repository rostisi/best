package com.example.tourisplace1

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tourisplace1.data.Destination
import com.example.tourisplace1.ui.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application()

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val destinations = listOf(
                Destination(1, "Odesa", "Odesa is a lively port city on the Black Sea, known for its beaches, opera house, and vibrant cultural life.", "https://omr.gov.ua/images/galleries/maxi/75027.jpg"),
                Destination(2, "Kharkiv", "Kharkiv is a cultural and educational center in northeastern Ukraine, known for its historic buildings, parks, and museums.", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/LopanStrelkaKharkov.jpg/1200px-LopanStrelkaKharkov.jpg"),
                Destination(3, "Ivano-Frankivsk", "Ivano-Frankivsk is a city in western Ukraine, known for its charming central square, nearby Carpathian Mountains, and vibrant atmosphere.", "https://etnotur.ua/wp-content/uploads/2016/04/Ivano-Frankovsk.jpg")
            )
            MaterialTheme {
                Navigation(destinations)
            }
        }
    }
}
