package com.example.galeriadearte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.galeriadearte.ui.theme.GaleriaDeArteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GaleriaDeArteTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArteApp()
                }
            }
        }
    }
}

@Composable
fun ArteApp(){
    var LugarActual by remember { mutableStateOf(1) }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
    when (LugarActual){
        1->{
            Arte(
               Imagen =  R.drawable.monalisa,
                Autor = R.string.da_Vinci,
                Titulo = R.string.Monalisa
            )
        }
        2->{
            Arte(
                Imagen =  R.drawable.la_noche_estrellada,
                Autor = R.string.Van_Gogh,
                Titulo = R.string.noche_estrellada
            )
        }
        3->{
            Arte(
                Imagen =  R.drawable.el_grito,
                Autor = R.string.Edvard_Munch,
                Titulo = R.string.El_grito
            )
        }
        4->{
            Arte(
                Imagen =  R.drawable.el_beso,
                Autor = R.string.Gustav_Klimt,
                Titulo = R.string.El_beso
            )
        }
    }


    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Boton(
            onclick = {
                if(LugarActual==1){
                    LugarActual=4
                }
                else{
                    LugarActual--
                }
            },
            text="Anterior",


        )
        Spacer(modifier = Modifier.width(16.dp))
        Boton(
            onclick = {
                if(LugarActual==4){
                    LugarActual=1
                }
                else{
                    LugarActual++
                }
            },
            text="Siguiente",


        )
    }

    }




}


@Composable
fun Arte(
    Imagen:Int,
    Autor:Int,
    Titulo:Int,
){


        Image(
            painter = painterResource(Imagen),
            contentDescription = stringResource(Titulo),
            )

        Spacer(modifier = Modifier.height(150.dp))

        Text(
            text = stringResource(Titulo),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = stringResource(Autor),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        )

    }
@Composable
fun Boton(
    onclick: ()-> Unit,
    text:String,
    modifier: Modifier = Modifier,
){
    Button(
        onClick = onclick,
        modifier = modifier,
    ) {
        Text(text = text)
    }
}



@Preview(showBackground = true)
@Composable
fun ArteAppPreview() {
    GaleriaDeArteTheme  {
        ArteApp()
    }
}