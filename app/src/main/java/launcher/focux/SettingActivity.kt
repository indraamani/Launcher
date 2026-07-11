package launcher.focux

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import launcher.focux.component.SettingButton
import launcher.focux.ui.theme.FocuxTheme

class SettingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FocuxTheme {
                SettingScreen()
            }
        }
    }
}

@SuppressLint("ContextCastToActivity")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingScreen() {
    var context = LocalContext.current as? Activity
    var scrollState = rememberScrollState()
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Settings",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 6.dp)
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            context?.finish()
                        }
                    )  {
                        Icon(painter = painterResource(R.drawable.arrow), contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
        ) {
            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 10.dp),
                text= "Customisations"
            )
            SettingButton("Change theme", painterResource(R.drawable.arrow), isCheckable = false, onClick = { }, onCheckChange = { })
            SettingButton("Change theme", painterResource(R.drawable.arrow), isCheckable = false, onClick = { }, onCheckChange = { })
            SettingButton("Change theme", painterResource(R.drawable.arrow), isCheckable = true, onClick = { }, onCheckChange = { })


            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                text= "Customisations"
            )
            SettingButton("Change theme", painterResource(R.drawable.arrow), isCheckable = true, onClick = { }, onCheckChange = { })
            SettingButton("Change theme", painterResource(R.drawable.arrow), isCheckable = true, onClick = { }, onCheckChange = { })
            SettingButton("Change theme", painterResource(R.drawable.arrow), isCheckable = false, onClick = { }, onCheckChange = { })
        }
    }
}