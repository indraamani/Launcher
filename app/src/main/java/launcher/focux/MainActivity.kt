package launcher.focux

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import launcher.focux.activity.DrawerActivity
import launcher.focux.activity.SettingActivity
import launcher.focux.ui.component.HiddenScreen
import launcher.focux.ui.theme.FocuxTheme
import launcher.focux.viewmodel.MainViewmodel
import androidx.compose.runtime.collectAsState
import launcher.focux.widget.BoxedClock
import launcher.focux.widget.Clock
import launcher.focux.widget.DateWidget
import launcher.focux.widget.DayWidget

class MainActivity : ComponentActivity() {

    private val viewModel : MainViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        val insetController = WindowCompat
            .getInsetsController(window, window.decorView)
        insetController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        insetController.hide(WindowInsetsCompat.Type.statusBars())

        setContent {
            FocuxTheme {
                if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
                    MainScreen(viewModel)
                else
                    HiddenScreen()
            }
        }

        onBackPressedDispatcher.addCallback(this@MainActivity, OnBackPressed)
    }

    object OnBackPressed: OnBackPressedCallback(enabled = true) {
        override fun handleOnBackPressed() {
            return
        }
    }
}

@Composable
fun MainScreen(viewmodel: MainViewmodel) {
    val pinnedAppList by viewmodel.pinnedApp.collectAsStateWithLifecycle()
    val ctx = LocalContext.current
    var hasTriggered by remember { mutableStateOf(false) }

    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
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
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = {
                        hasTriggered = false
                    },
                    onDrag = { change, dragAmount ->
                        if (!hasTriggered && change.previousPosition.y > change.position.y && dragAmount.y < 4) {
                            hasTriggered = true
                            context.startActivity(Intent(context, DrawerActivity::class.java))
                        }
                    }
                )
            }

    ) {
        // Mock Widget
        Box(
            modifier = Modifier
                .padding(top = 126.dp)
        ) {
            DateWidget(ctx)
        }

        Spacer(modifier = Modifier.weight(0.8f))
        LazyColumn(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(pinnedAppList) {
                Text(
                    maxLines = 1,
                    //overflow = TextOverflow.Ellipsis,
                    text = it.name,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 24.sp,
//                    fontFamily = FontFamily(
//                        Font( viewmodel.setting.collectAsState().value.font)
//                    ),
                    modifier = Modifier
                        .width(120.dp)
                        .padding(0.dp, 7.dp)
                        .combinedClickable(
                            interactionSource = null,
                            indication = null,
                            onClick = {
                                ctx.startActivity(
                                        ctx.packageManager.getLaunchIntentForPackage(it.packageName)
                                )
                            }
                        )
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "03 : 39",
            modifier = Modifier
                .padding(bottom = 40.dp)

                .background(Color(255f, 255f, 255f, 0.5f))
        )

    }
}