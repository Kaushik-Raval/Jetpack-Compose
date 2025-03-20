package com.demo.jetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.demo.jetpackcompose.AppDestination
import com.demo.jetpackcompose.R
import com.demo.jetpackcompose.model.CardData
import com.demo.jetpackcompose.ui.theme.JetpackComposeTheme

@Composable
fun ImageDetails(
    cardData: CardData,
    modifier: Modifier = Modifier,
    onClicked: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Card(modifier = modifier
            .padding(15.dp),
            onClick = {
                onClicked(AppDestination.Profile.name)
            }) {
            Column {
                AsyncImage(
                    modifier = Modifier.size(180.dp, 180.dp),
                    model = cardData.images,
                    placeholder = painterResource(R.drawable.img_2),
                    error = painterResource(R.drawable.img_3),
                    contentDescription = null,
                )

                Text(
                    cardData.title,
                    letterSpacing = TextUnit(.5f, TextUnitType.Sp),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(5.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
//        ImageDetails(CardData("fd", R.drawable.img_1),
//            onClicked = {})
        val sampleCardData = CardData(
            id = 1,
            title = "Sample Image",
            images = "https://example.com/sample.jpg"
        )

        // A simple onClicked action (can be empty for preview)
        ImageDetails(
            cardData = sampleCardData,
            onClicked = { destination ->
                // Handle click action, for preview it can be a no-op
            }
        )
    }
}

