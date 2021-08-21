package com.example.composedemo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo1.ui.theme.ComposeDemo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                    ){
                Greeting("Hello !")
                Greeting("Hey")
                Greeting("Everyone !!")
            }

        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Red,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = Color.Yellow)
            .border(2.dp, color = Color.Green)
            .padding(10.dp)
//            .fillMaxWidth()
//            .fillMaxHeight()
//            .fillMaxWidth(0.5f)
//            .fillMaxHeight(0.3f)


    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeDemo1Theme {
        Greeting("Android")
    }
}






