package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.foundation.Image
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
               LemonadeApp()
            }
        }
    }
}
@Composable
fun LemonadeApp(){
    var currentStep by remember { mutableStateOf(1) }

    var squeezeCount by remember { mutableStateOf(0)}

    when (currentStep) {
        1 -> {
            LemonTextAndImage(
                textLabelResourceId = R.string.select_a_lemon,
                drawableResourceId = R.drawable.lemon_tree,
                contentDescriptionResourceId = R.string.Lemon_tree,
                onImageClick = {
                    currentStep = 2
                    squeezeCount = (2..10).random()
                }
            )
        }
        2 -> {
            LemonTextAndImage(
                textLabelResourceId = R.string.squeeze_it,
                drawableResourceId = R.drawable.lemon_squeeze,
                contentDescriptionResourceId = R.string.Lemon,
                onImageClick = {
                    squeezeCount--
                    if (squeezeCount == 0) {
                        currentStep = 3
                    }
                }
            )
        }

        3 -> {
            LemonTextAndImage(
                textLabelResourceId = R.string.drink_it,
                drawableResourceId = R.drawable.lemon_drink,
                contentDescriptionResourceId = R.string.Glass_of_lemonade,
                onImageClick = {
                    currentStep = 4
                }
            )
        }
        4 -> {
            LemonTextAndImage(
                textLabelResourceId = R.string.start_again,
                drawableResourceId = R.drawable.lemon_restart,
                contentDescriptionResourceId = R.string.Empty_glass,
                onImageClick = {
                    currentStep = 1
                }
            )
        }
    }


}


@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = onImageClick,

        ) {
            Image(
                painter = painterResource(drawableResourceId),
                contentDescription = stringResource(contentDescriptionResourceId),

            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(textLabelResourceId),
        )
    }
}




@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}