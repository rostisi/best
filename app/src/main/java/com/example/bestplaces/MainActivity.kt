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
                Destination(1, "Odesa", "Odesa is a vibrant port city on the Black Sea, known for its stunning beaches, vibrant nightlife, and historic architecture.", "https://aws-travel-guide.s3.eu-west-1.amazonaws.com/default_image_size/603fbe7b33f8d_%D0%BE%D0%B4%D0%B5%D1%81%D0%B0.jpg"),
                Destination(2, "Kharkiv", "Kharkiv is a large city in northeastern Ukraine, known for its cultural scene, museums, and beautiful parks.", "https://turpoisk.ua/images/blog/kharkiv/kharkiv-1.jpg"),
                Destination(3, "Chernivtsi", "Chernivtsi is a city in western Ukraine, famous for its beautiful Austrian-era architecture and cultural diversity.", "https://timetotravel.in.ua/wp-content/uploads/2021/02/Chernivtsi-768x512.jpg")
            )
            MaterialTheme {
                Navigation(destinations)
            }
        }
    }
}
