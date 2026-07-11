package launcher.focux.component

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NestedLazyColumn(modifier: Modifier, apps: Map<String, Array<String>>) {

    val context = LocalContext.current

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        apps.forEach { (word, listOfApps) ->
            item {
                Text(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp, start = 12.dp),
                    text = word
                )
            }

            items(
                items = listOfApps
            ){
                Text(
                    text = it.capitalize(Locale.getDefault()),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                        .combinedClickable(
                            enabled = true,
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "App clicked",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            onLongClick = {
                                Toast.makeText(
                                    context,
                                    "App Long clicked",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        )
                )
            }
        }
    }
}