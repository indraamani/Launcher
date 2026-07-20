package launcher.focux.ui.component.widget

import android.app.ApplicationErrorReport
import android.content.Context
import android.content.Context.BATTERY_SERVICE
import android.os.BatteryManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.LocaleList
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDateTime

@Composable
fun DayWidget() {
    val day = LocalDateTime.now().dayOfWeek.name

    Text(
        text = day.lowercase().replaceFirstChar { it.titlecase() },
        fontSize = 12.sp,
        modifier = Modifier
            .clip(
                RoundedCornerShape(12.dp)
            )
            .background(Color(254f, 254f, 254f, 0.8f))
            .padding(8.dp, 3.dp)
    )
}

@Composable
fun BatteryWidget(ctx : Context) {
    val manager = ctx.getSystemService(BATTERY_SERVICE) as BatteryManager
    val battery = manager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)

    Text(
        text = battery.toString(),
        fontSize = 12.sp,
        modifier = Modifier
            .clip(
                RoundedCornerShape(12.dp)
            )
            .background(Color(254f, 254f, 254f, 0.8f))
            .padding(8.dp, 3.dp)
    )
}