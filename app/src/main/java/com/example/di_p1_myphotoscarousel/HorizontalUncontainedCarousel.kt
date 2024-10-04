package com.example.di_p1_myphotoscarousel

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.di_p1_myphotoscarousel.R

data class CarouselItem(
    val id: Int,
    val imageResId: Int,
    val contentDescriptionResId: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HorizontalUncontainedCarouselEjemplo(modifier: Modifier) {
    var fotoSeleccionada by remember { mutableStateOf<Int?>(null) }

    val items = listOf(
        CarouselItem(1, R.drawable.image1, R.string.carousel_image_1_description),
        CarouselItem(2, R.drawable.image2, R.string.carousel_image_2_description),
        CarouselItem(3, R.drawable.image3, R.string.carousel_image_3_description),
        CarouselItem(4, R.drawable.image4, R.string.carousel_image_4_description),
        CarouselItem(5, R.drawable.image5, R.string.carousel_image_5_description),
        CarouselItem(6, R.drawable.image6, R.string.carousel_image_5_description),
        CarouselItem(7, R.drawable.image7, R.string.carousel_image_5_description),
        CarouselItem(8, R.drawable.image8, R.string.carousel_image_5_description),
        )

    Column (modifier.fillMaxSize()) {
        HorizontalUncontainedCarousel(
            state = rememberCarouselState { items.count() },
            modifier = Modifier.width(412.dp).height(221.dp),
            itemWidth = 186.dp,
            itemSpacing = 8.dp,
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) { i ->
            val item = items[i]
            Image(
                painter = painterResource(item.imageResId),
                contentDescription = stringResource(item.contentDescriptionResId),
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .height(205.dp)
                    .maskClip(MaterialTheme.shapes.extraLarge)
                    .clickable { fotoSeleccionada = item.imageResId }
            )
        }

        HorizontalDivider()

        if (fotoSeleccionada != null) {
            Image(
                painter = painterResource(fotoSeleccionada!!),
                contentDescription = "",
                Modifier.size(1000.dp)
            )
        }
    }

}