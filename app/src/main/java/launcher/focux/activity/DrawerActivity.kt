package launcher.focux.activity

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import launcher.focux.ui.component.NestedLazyColumn
import launcher.focux.ui.theme.FocuxTheme
import launcher.focux.viewmodel.DrawerViewmodel

class DrawerActivity : ComponentActivity() {

    private val viewModel : DrawerViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FocuxTheme {
                DrawerScreen(this@DrawerActivity, viewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerScreen(ctx: Context, viewmodel: DrawerViewmodel) {
    val nestedScroll = remember {
        object : NestedScrollConnection {
            override fun onPostScroll(
                consumed: Offset,
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                if (available.y > 100) {
                    (ctx as Activity).finish()
                }
                return super.onPostScroll(consumed, available, source)
            }
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScroll),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Applications",

                    )
                },
            )
        }
    ) { innerPadding ->
        NestedLazyColumn(
            modifier = Modifier
                .padding(innerPadding),
            apps = viewmodel.packages.collectAsStateWithLifecycle().value,
        )
    }
}