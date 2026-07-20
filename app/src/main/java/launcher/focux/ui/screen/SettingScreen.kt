package launcher.focux.ui.screen

import android.annotation.SuppressLint
import android.app.Activity
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import launcher.focux.R
import launcher.focux.ui.component.SettingButton
import launcher.focux.viewmodel.SettingViewmodel


@SuppressLint("ContextCastToActivity")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(
    viewmodel: SettingViewmodel,
    openFontScreen: () -> Unit,
    openTopwidgetScreen: () -> Unit
) {
    var context = LocalContext.current as? Activity
    var scrollState = rememberScrollState()
    val font = viewmodel.settings.collectAsStateWithLifecycle().value.font

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Settings",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 6.dp),
                        fontFamily = FontFamily(
                            Font(font)
                        )
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            context?.finish()
                        }
                    ) {
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
                text = "Customisations",
                fontFamily = FontFamily(
                    Font(font)
                )
            )
            SettingButton(
                "Choose Home Theme",
                painterResource(R.drawable.lucide_palette),
                font = font,
                onClick = {
                },
            )
            SettingButton(
                "Choose Font",
                painterResource(R.drawable.lucide_case_sensitive),
                font = font,
                onClick = {
                    openFontScreen()
                },
            )
            SettingButton(
                "Choose Top Widget",
                painterResource(R.drawable.lucide_chart_no_axes_gantt),
                font = font,
                onClick = {
                    openTopwidgetScreen()
                },
            )
            SettingButton(
                "Choose Bottom Widget",
                painterResource(R.drawable.lucide_list_end),
                font = font,
                onClick = { },
            )
            SettingButton(
                "Show Status Bar",
                painterResource(R.drawable.alarm_clock),
                font = font,
                isCheckable = true,
                onCheckChange = { }
            )
            SettingButton(
                "Enable Haptic Feedback",
                painterResource(R.drawable.lucide_blend),
                font = font,
                isCheckable = true,
                onCheckChange = { }
            )
            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
                text = "Swipe App Launch Customisations",
                fontFamily = FontFamily(
                    Font(font)
                )
            )
            SettingButton(
                "Enable Swipe to Launch app",
                painterResource(R.drawable.alarm_clock),
                font = font,
                isCheckable = true,
                onCheckChange = { }
            )
            SettingButton(
                "Enable Swipe Up To Open Search",
                painterResource(R.drawable.alarm_clock),
                font = font,
                isCheckable = true,
                onCheckChange = { }
            )
            SettingButton(
                "Choose Swipe Launch Apps",
                painterResource(R.drawable.activity),
                font = font,
                onClick = {

                }
            )
            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
                text = "Swipe App Launch Customisations",
                fontFamily = FontFamily(
                    Font(font)
                )
            )
            SettingButton(
                "Show Clock on Home",
                painterResource(R.drawable.alarm_clock),
                font = font,
                isCheckable = true,
                onCheckChange = { }
            )
            SettingButton(
                "12 Hr Format",
                painterResource(R.drawable.lucide_alarm_clock_off),
                font = font,
                isCheckable = true,
                onCheckChange = { }
            )
            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
                text = "Hidden Apps",
                fontFamily = FontFamily(
                    Font(font)
                )
            )
            SettingButton(
                "Modify Hidden Apps",
                painterResource(R.drawable.lucide_ban),
                font = font,
                onClick = {

                }
            )
            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
                text = "Renamed Apps",
                fontFamily = FontFamily(
                    Font(font)
                )
            )
            SettingButton(
                "Modify/View Renamed Apps",
                painterResource(R.drawable.lucide_route),
                font = font,
                onClick = {

                }
            )
            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
                text = "Pinned Apps Customization",
                fontFamily = FontFamily(
                    Font(font)
                )
            )
            SettingButton(
                "Modifed Pinned Apps",
                painterResource(R.drawable.lucide_grid),
                font = font,
                onClick = {

                }
            )
        }
    }
}