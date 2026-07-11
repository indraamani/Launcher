package launcher.focux

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import launcher.focux.component.NestedLazyColumn
import launcher.focux.ui.theme.FocuxTheme
import launcher.focux.utils.sort

class DrawerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FocuxTheme {
                DrawerScreen(this@DrawerActivity)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DrawerScreen(ctx: Context) {
    Scaffold(
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
            modifier = Modifier.padding(innerPadding),
            apps = Packages(ctx).fetchAllPackages().sort(),
        )
    }
}