package launcher.focux.activity

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import launcher.focux.utils.Packages
import launcher.focux.ui.component.NestedLazyColumn
import launcher.focux.ui.theme.FocuxTheme
import launcher.focux.utils.sort
import launcher.focux.viewmodel.DrawerViewmodel
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.compose.collectAsStateWithLifecycle

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

    override fun onPause() {
        super.onPause()
        finish()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DrawerScreen(ctx: Context, viewmodel: DrawerViewmodel) {
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
            apps = viewmodel.packages.collectAsStateWithLifecycle().value,
        )
    }
}