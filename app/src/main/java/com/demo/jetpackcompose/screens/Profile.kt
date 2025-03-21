package com.demo.jetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.jetpackcompose.ui.theme.JetpackComposeTheme


@Composable
fun ComposeProfile() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "Navigation without arguments",
                Modifier.padding(10.dp),
                color = Color.Black
            )
            Text(text = "Profile Screen", Modifier.padding(10.dp), color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    JetpackComposeTheme {
        ComposeProfile()
    }
}