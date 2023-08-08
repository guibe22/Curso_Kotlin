package com.example.tarjetaproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetaproject.ui.theme.TarjetaProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetaProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Tarjeta("Wilber Galvez","Kotlin Devolper","+1 (829)-673-9398","@galvez.wilber","galvezwilber22@gmail.com")
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
fun Tarjeta(Nombre:String,Titulo:String,Numero: String,Red:String,Correo:String,modifier: Modifier = Modifier){

    val fondo= painterResource( R.drawable.androidparty__1_)
    Box{
        Image(
            painter = fondo,
            contentDescription =null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F

        )
        Column(modifier.fillMaxSize()) {
            Top(Nombre, Titulo)
            Spacer(modifier = Modifier.weight(1f))
            Info(Numero, Red, Correo, modifier)
            }
        }


    }

@Composable
fun Top(Nombre: String, Titulo: String,modifier: Modifier = Modifier){
    val kotlin= painterResource( R.drawable.kotlin_logo_svg)

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(top = 150.dp)
    ) {
        Image(
            painter = kotlin,
            contentDescription = null,
        )
        Text(
            text = Nombre,
            fontSize = 40.sp,
            lineHeight = 70.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = Titulo,
            fontSize = 26.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }


}
@Composable
fun Info(Numero: String,Red:String,Correo:String,modifier: Modifier = Modifier){
    val numeroImg = painterResource(R.drawable.llamada_telefonica)
    val redImg = painterResource(R.drawable.logotipo_de_instagram)
    val correoImg = painterResource(R.drawable.correo)
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
    ){

      Row {
          Icon(
              painter = numeroImg,
              contentDescription = null ,
              modifier = Modifier.size(32.dp)
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
              text = Numero,
              fontSize = 20.sp,
              textAlign = TextAlign.End
          )
      }
        Spacer(modifier = Modifier.width(8.dp))
        Row{
            Icon(
                painter = redImg,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = Red,
                fontSize = 20.sp,
                textAlign = TextAlign.End
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Row {
            Icon(
                painter = correoImg,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = Correo,
                fontSize = 20.sp,
                textAlign = TextAlign.End
            )
        }
        
    }

}






@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TarjetaProjectTheme {
        Tarjeta("Wilber Galvez","Kotlin Devolper","+1 (829)-673-9398","@galvez.wilber","galvezwilber22@gmail.com")
    }
}