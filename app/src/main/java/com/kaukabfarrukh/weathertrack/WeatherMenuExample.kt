package com.kaukabfarrukh.weathertrack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable fun WeatherMenuExample() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Weather App",
            fontSize = 45.sp, textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.padding(vertical = 100.dp)
                //.background(Color.Green)
                .width(350.dp)
        )
        Column(modifier = Modifier.padding(horizontal = 75.dp).width(500.dp)) {
            Text(
                "Eslöv, ???",
                fontSize = 25.sp, textAlign = TextAlign.Center,
            )
            Text("12 degrees, ? high")
            Text("Weather is: Cloudy")
            Text("Air quality: Good (value)")
            Column(modifier = Modifier.padding(vertical = 50.dp)) {
                Text("MON TUES WED THU FRI SAT SUN",
                    fontSize = 15.sp
                )
                Text("Sun, cloud, thunder icons...")
                Text("Degrees Celsius")
                Text("Degrees Fahrenheit")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable fun WeatherMenuExamplePreview() {
    WeatherMenuExample()
}