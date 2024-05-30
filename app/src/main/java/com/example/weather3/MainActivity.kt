package com.example.weather3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weather3.ui.theme.Weather3Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Weather3Theme {
                // A surface container using the 'background' color from the theme
                NavigationHost()
            }
        }
    }
}
//https://api.weatherbit.io/v2.0/forecast/daily?city=Raleigh,NC&key=eceff76f289a4da6a6eae5730c09d9b7
