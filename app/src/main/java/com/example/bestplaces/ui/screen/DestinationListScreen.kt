package com.example.tourisplace1.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.tourisplace1.data.Destination

@Composable
fun DestinationListScreen(
    destinations: List<Destination>,
    onDestinationClick: (Destination) -> Unit
) {
    LazyColumn {
        items(destinations) { destination ->
            DestinationListItem(destination, onDestinationClick)
        }
    }
}

@Composable
fun DestinationListItem(
    destination: Destination,
    onClick: (Destination) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)  // Зменшений відступ
            .clickable { onClick(destination) },
        shape = MaterialTheme.shapes.medium, // Округлені кути
    ) {
        Column {
            // Зображення
            Image(
                painter = rememberImagePainter(destination.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            // Назва місця
            Text(
                text = destination.name,
                style = MaterialTheme.typography.bodyLarge, // Збільшений шрифт
                modifier = Modifier.padding(12.dp)  // Відступи з усіх боків
            )
        }
    }
}
