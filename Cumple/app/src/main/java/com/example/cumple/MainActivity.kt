package com.example.cumple

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cumple.ui.theme.CumpleTheme
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CumpleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage("Happy Birthday Sam!", "- from Emma")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
@Composable
fun BirthdayGreetingWithImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)

    Box{
        Image(
            painter = image,
            contentDescription = null
        )
        BirthdayGreetingWithText(message = message, from = from)

    }



}


@Composable
fun BirthdayGreetingWithText(message: String, from: String,modifier: Modifier = Modifier) {

    Column(modifier = modifier){
            Text(
                text = message,
                fontSize = 36.sp,
            )
            Text(
                text = from,
                fontSize = 24.sp,
            )
        }

    }


@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    CumpleTheme {
        BirthdayGreetingWithImage("FElI CUMPLE jEURY", "- DE PARTE DE RAYSA")
    }
}
