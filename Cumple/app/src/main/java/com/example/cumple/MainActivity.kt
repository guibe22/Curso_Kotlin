package com.example.cumple

import android.os.Bundle
import android.provider.Settings.Global.getString
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cumple.ui.theme.CumpleTheme
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


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
                    BirthdayGreetingWithImage(getString(R.string.Feliz_Cumple_Mallimy), getString(R.string.De_parte_de_Wilber))
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
    val image = painterResource(R.drawable.androidparty2)

    Box{
        Image(
            painter = image,
            contentDescription = null ,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        BirthdayGreetingWithText(message = message, from = from)

    }



}


@Composable
fun BirthdayGreetingWithText(message: String, from: String,modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ){

            Text(
                text = message,
                fontSize = 50.sp,
                lineHeight = 70.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = from,
                fontSize = 26.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }

    }


@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    CumpleTheme {
        BirthdayGreetingWithImage(stringResource(R.string.Feliz_Cumple_Mallimy), stringResource(R.string.De_parte_de_Wilber))
    }
}


