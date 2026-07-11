package launcher.focux

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import launcher.focux.ui.theme.FocuxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FocuxTheme {
                MainScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreen() {
    val pinnedAppList: List<String> = listOf(
        "Instagram",
        "Whatsapp",
        "Phone",
        "Gpay"
    )
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxSize()
            //.padding(top = 110.dp, bottom = 40.dp)
            .combinedClickable(
                indication = null,
                interactionSource = null,
                onLongClick = {
                    context.startActivity(
                        Intent(
                            context,
                            SettingActivity::class.java
                        )
                    )
                },
                onClick = {}
            )

    ) {
        // Mock Widget
        Text(
            text = "03 : 39",
            fontSize = 32.sp,
            modifier = Modifier.padding(top = 110.dp)
        )

        Spacer(modifier = Modifier.weight(0.8f))
        LazyColumn(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(pinnedAppList) {
                Text(
                    text = it,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .width(120.dp)
                        .padding(0.dp, 6.dp)
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "03 : 39",
            modifier = Modifier.padding(bottom = 40.dp)
        )

    }
}