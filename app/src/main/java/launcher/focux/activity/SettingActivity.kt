package launcher.focux.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import launcher.focux.R
import launcher.focux.ui.component.SettingButton
import launcher.focux.ui.screens.FontScreen
import launcher.focux.ui.theme.FocuxTheme
import launcher.focux.viewmodel.SettingViewmodel

class SettingActivity : ComponentActivity() {

    private val viewModel : SettingViewmodel by viewModels()

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
                modifier = Modifier.padding(start = 10.dp, top = 16.dp, bottom = 16.dp),
                text= "Customisations"
            )
            SettingButton(
                "Choose Home Theme",
                painterResource(R.drawable.lucide_palette),
                onClick = { },
            )
            SettingButton(
                "Choose Font",
                painterResource(R.drawable.lucide_case_sensitive),
                onClick = { },
            )
            SettingButton(
                "Choose Top Widget",
                painterResource(R.drawable.lucide_chart_no_axes_gantt),
                onClick = { },
            )
            SettingButton(
                "Choose Bottom Widget",
                painterResource(R.drawable.lucide_list_end),
                onClick = { },
            )
            SettingButton(
                "Show Status Bar",
                painterResource(R.drawable.alarm_clock),
                isCheckable = true,
                onCheckChange = { }
            )
            SettingButton(
                "Enable Haptic Feedback",
                painterResource(R.drawable.lucide_blend),
                isCheckable = true,
                onCheckChange = { }
            )
            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 10.dp, top = 16.dp, bottom = 16.dp),
                text= "Swipe App Launch Customisations"
            )
            SettingButton(
                "Enable Swipe to Launch app",
                painterResource(R.drawable.alarm_clock),
                isCheckable = true,
                onCheckChange = { }
            )
            SettingButton(
                "Enable Swipe Up To Open Search",
                painterResource(R.drawable.alarm_clock),
                isCheckable = true,
                onCheckChange = { }
            )
            SettingButton(
                "Choose Swipe Launch Apps",
                painterResource(R.drawable.activity),
                onClick = {

                }
            )
            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 10.dp, top = 16.dp, bottom = 16.dp),
                text= "Swipe App Launch Customisations"
            )
            SettingButton(
                "Show Clock on Home",
                painterResource(R.drawable.alarm_clock),
                isCheckable = true,
                onCheckChange = { }
            )
            SettingButton(
                "12 Hr Format",
                painterResource(R.drawable.lucide_alarm_clock_off),
                isCheckable = true,
                onCheckChange = { }
            )
            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 10.dp, top = 16.dp, bottom = 16.dp),
                text= "Hidden Apps"
            )
            SettingButton(
                "Modify Hidden Apps",
                painterResource(R.drawable.lucide_ban),
                onClick = {

                }
            )
            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 10.dp, top = 16.dp, bottom = 16.dp),
                text= "Renamed Apps"
            )
            SettingButton(
                "Modify/View Renamed Apps",
                painterResource(R.drawable.lucide_route),
                onClick = {

                }
            )
            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 10.dp, top = 16.dp, bottom = 16.dp),
                text= "Pinned Apps Customization"
            )
            SettingButton(
                "Modifed Pinned Apps",
                painterResource(R.drawable.lucide_grid),
                onClick = {

                }
            )
        }
    }
}