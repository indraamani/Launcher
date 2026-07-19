package launcher.focux.ui.component

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import launcher.focux.AppModel
import launcher.focux.datastore.pinnedapp.PinnedApp
import launcher.focux.datastore.pinnedapp.PinnedAppRepo
import java.util.Locale
import java.util.SortedMap

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NestedLazyColumn(modifier: Modifier, font: Int, apps: Map<String, List<AppModel>>) {
    // remove
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    LazyColumn(
        contentPadding = PaddingValues(bottom = 12.dp),
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        apps.forEach { (word, listOfApps) ->
            item (key = word){
                Text(
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(24.dp, 4.dp),
                    text = word,
                    fontFamily = FontFamily(
                        Font(font)
                    )
                )
            }

            items(
                items = listOfApps,
                key = { app -> app.packageName}
            ){
                Text(
                    text = it.name.capitalize(Locale.getDefault()),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(
                        Font(font)
                    ),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 12.dp)
                        .combinedClickable(
                            enabled = true,
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = {
                                context.startActivity(
                                    context.packageManager.getLaunchIntentForPackage(it.packageName)
                                )
                                (context as Activity).finish()
                            },
                            onLongClick = {
                                coroutineScope.launch {
                                    PinnedAppRepo(context).add(
                                        PinnedApp(
                                            it.name,
                                            it.packageName
                                        )
                                    )
                                }
                            }
                        )
                )
            }
        }
    }
}