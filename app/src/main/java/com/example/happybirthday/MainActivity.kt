package com.example.happybirthday


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage(message = getString(R.string.happy_birtyday_text), from = getString(
                                            R.string.from_text), greet = "Happy Birthday")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText (message:String, from: String, greet: String) {
//    Row(content = {
//        Text(text = message, fontSize = 36.sp)
//        Text(text = from, fontSize = 28.sp)
//    })
    Column{
        Text(text = message, fontSize = 36.sp, modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .padding(start = 16.dp, top = 16.dp))
        Text(text = from, fontSize = 30.sp, modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .padding(start = 16.dp, end = 16.dp))
        Text(text = greet, fontSize = 34.sp, modifier=Modifier
            .fillMaxWidth()
            .wrapContentWidth().padding(start = 16.dp, end = 16.dp, top = 18.dp))
    }
}

//Adding the composable image function
@Composable
fun BirthdayGreetingWithImage (message:String, from: String, greet: String) {
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(painter = image,
            contentDescription = null,
            modifier = Modifier .fillMaxHeight() .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText (message= message, from = from, greet = greet)
    }

}


@Preview(showBackground = false)
@Composable
fun BirthdayGreetingWithImagePreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWithImage(message = "Happy Birthday RAM", from = "- from Shubham", greet = "Happy Birthday")
    }
}