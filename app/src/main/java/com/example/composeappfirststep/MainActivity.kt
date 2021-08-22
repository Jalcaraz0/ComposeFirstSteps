package com.example.composeappfirststep

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeappfirststep.ui.theme.ComposeAppFirstStepTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("Hello world")
        }
    }
}

data class MessageInformation(val author: String,val body: String)
@Composable
fun MessageCARD (msg:MessageInformation){
    Row(modifier= Modifier.padding(all = 8.dp)) {
        Image(painter = painterResource(R.drawable.profile), contentDescription = "Contact profile picture",
        modifier= Modifier
            .size(40.dp)
            .clip(CircleShape))

    
    Spacer(modifier = Modifier.width(8.dp))
    Column() {
        Text(text = msg.author)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = msg.body)
        }
    }
}
@Preview
@Composable
fun PreviewMessageCard(){
    MessageCARD(msg = MessageInformation("Juan","This is my first compose application"))
}
