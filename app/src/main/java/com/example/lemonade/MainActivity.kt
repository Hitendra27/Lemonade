package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    TopBar(text = stringResource(R.string.app_name))
    LemonImageAndText(
        imagePainter = painterResource(R.drawable.lemon_tree),
        imageText = stringResource(R.string.lemon_tree) )
}

@Composable
fun TopBar(
    text: String,
    modifier: Modifier = Modifier) {
        Text(
        text = text,
            fontSize = 20.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.ExtraBold,
        textAlign = TextAlign.Center,
        modifier = modifier
            .background(Color.Yellow)
            .padding(top = 25.dp, bottom = 16.dp)
            .height(40.dp)
            .fillMaxWidth()
    )
}

//@Composable
//fun LemonadeImageClickable(modifier: Modifier = Modifier) {
//    var result by remember { mutableListOf(1) }
//    val imageResource = when (result) {
//        1 -> R.drawable.lemon_squeeze
//        2 -> R.drawable.lemon_drink
//        3. -> R.drawable.lemon_restart
//        else -> R.drawable.lemon_tree
//    }
//    Column(
//        modifier = modifier,
//        horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//        Image(
//            painter = painterResource(id = imageResource),
//            contentDescription = null,
//            Modifier.clickable { result }
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//
//    }
//
//}

@Composable
fun LemonadeImageClick(
    modifier: Modifier = Modifier,
) {
    var result by remember { mutableStateOf(1) }
    var imageResource = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = result.toString())
//        modifier = Modifier
//            .clickable {  }
    }
}

@Composable
fun LemonImageAndText(
    imagePainter: Painter,
    imageText: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null
        )
        Text(text = imageText)
        
    }
    
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}