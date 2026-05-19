package minimal.launcher

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import minimal.launcher.ui.theme.LauncherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LauncherTheme {
                mainScreen()
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun mainScreen() {
    
    // temp variable
    val apps = arrayOf<String>(
        "Phone",
        "Whatsapp",
        "Gemini",
        "YouTube"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 82.dp)
        ) {
            Text(
                text = "May 19 2026",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "18 : 28",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }

        LazyColumn(
            userScrollEnabled = false,
            modifier = Modifier
        ) {
            items(count = apps.size, key = {
                it
            }){
                Text(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = apps[it]
                    
                )
            }

        }
        // widget
        Column(
            modifier = Modifier
                .padding(bottom = 32.dp)
        ) {
            Text(
                text = "6 hrs 45 min",
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
                    .background(Color.Red)
                    .padding(16.dp, 4.dp)
            )
        }
    }
}