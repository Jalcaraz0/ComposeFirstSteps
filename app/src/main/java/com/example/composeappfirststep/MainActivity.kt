package com.example.composeappfirststep

import android.content.res.Configuration
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
            ComposeAppFirstStepTheme{
                MessageCARD(MessageInformation("Juan","Using Material design"))
            }
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
            .clip(CircleShape)
            .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape))

    
    Spacer(modifier = Modifier.width(8.dp))
    Column() {
        Text(text = msg.author, color=MaterialTheme.colors.secondaryVariant,
            style = MaterialTheme.typography.subtitle2
        )
        Spacer(modifier = Modifier.height(4.dp))
        Surface(shape = MaterialTheme.shapes.medium, elevation =1.dp){
        Text(text = msg.body,color=MaterialTheme.colors.secondaryVariant,
            style = MaterialTheme.typography.subtitle2)
        }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard(){
    ComposeAppFirstStepTheme() {
        MessageCARD(msg = MessageInformation("Manuel", "Hey this is my first application with Compose"))
    }
}
