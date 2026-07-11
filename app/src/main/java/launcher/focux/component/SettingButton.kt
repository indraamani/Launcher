package launcher.focux.component

import android.widget.Checkable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import launcher.focux.R


@Composable
fun SettingButton(
    settingName: String,
    logo: Painter,
    isCheckable: Boolean,
    onCheckChange: () -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .combinedClickable(
                onClick= { onClick() }
            ),
        shape = CardDefaults.elevatedShape
    ) {
        Row (
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(16.dp),
                painter = logo,
                contentDescription = null
            )
            Text(
                text = settingName
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
            if (isCheckable) {
                Switch(
                    modifier = Modifier
                        .scale(0.7f)
                        .padding(8.dp),
                    checked = true,
                    onCheckedChange = {
                        onCheckChange()
                    }
                )
            } else {
                Icon(
                    modifier = Modifier
                        .padding(16.dp),
                    painter = painterResource(R.drawable.chevron_right),
                    contentDescription = null
                )
            }
        }
    }
}