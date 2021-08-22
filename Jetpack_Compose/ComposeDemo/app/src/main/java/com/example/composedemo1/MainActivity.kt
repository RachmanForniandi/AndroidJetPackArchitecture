package com.example.composedemo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
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
            //column
//            Column (
//                modifier = Modifier
//                    .background(color = Color.LightGray)
//                    .fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                    )

            //row
//            Row(
//                modifier = Modifier
//                    .background(color = Color.LightGray)
//                    .fillMaxSize(),
//                verticalAlignment= Alignment.Bottom,
//                horizontalArrangement = Arrangement.SpaceEvenly
//            )
//
//            {
//                Greeting("Hello !")
//                Greeting("Hey")
//                Greeting("Everyone !!")
//            }
            BoxExample3()

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

@Composable
fun BoxExample1() {
    Box(modifier = Modifier
        .background(color = Color.Green)
        .size(180.dp, 300.dp)
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.Yellow)
                .size(125.dp, 100.dp)
                .align(Alignment.TopEnd)
        ){

        }
        Text(text = "Hey",
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .size(120.dp, 60.dp)
                .background(color = Color.White)
                .align(Alignment.BottomCenter)
        )
    }

}

@Composable
fun BoxExample2() {
    Box(modifier = Modifier
        .background(color = Color.LightGray)
        .fillMaxSize()
    ) {

        Text(text = "TopStart",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .padding(10.dp)
                .background(color = Color.Yellow)
                .align(Alignment.TopStart)
        )

        Text(text = "TopCenter",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .size(10.dp)
                .background(color = Color.Yellow)
                .align(Alignment.TopCenter)
        )
        Text(text = "TopEnd",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .size(10.dp)
                .background(color = Color.Yellow)
                .align(Alignment.TopEnd)
        )

        Text(text = "CenterStart",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .size(10.dp)
                .background(color = Color.Yellow)
                .align(Alignment.CenterStart)
        )

        Text(text = "Center",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .size(10.dp)
                .background(color = Color.Yellow)
                .align(Alignment.Center)
        )

        Text(text = "CenterEnd",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .size(10.dp)
                .background(color = Color.Yellow)
                .align(Alignment.CenterEnd)
        )

        Text(text = "BottomStart",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .size(10.dp)
                .background(color = Color.Yellow)
                .align(Alignment.BottomStart)
        )

        Text(text = "BottomCenter",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .size(10.dp)
                .background(color = Color.Yellow)
                .align(Alignment.BottomCenter)
        )

        Text(text = "BottomEnd",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .size(10.dp)
                .background(color = Color.Yellow)
                .align(Alignment.BottomEnd)
        )

    }

}

@Composable
fun BoxExample3() {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.mountain),
            contentDescription = "mountain view"
        )
        Text(text = "Mountain View",
            style = MaterialTheme.typography.h4,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.BottomStart)
        )
        Button(
            onClick = {},
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.White,
                contentColor = Color.DarkGray
            ),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
                .border(5.dp,Color.DarkGray, RectangleShape)

        ){
            Text("Add To Cart")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeDemo1Theme {
        Greeting("Android")
    }
}





