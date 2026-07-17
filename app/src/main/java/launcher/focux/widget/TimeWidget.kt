package launcher.focux.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun BoxedClock() {
    val dateTime = LocalDateTime.now()
    val hour = DateTimeFormatter.ofPattern("HH")
    val minute = DateTimeFormatter.ofPattern("mm")

    Row(
        modifier = Modifier
        ,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            fontSize = 34.sp,
            text = dateTime.format(hour),
            modifier = Modifier
                .clip(
                    RoundedCornerShape(6.dp)
                )
                .background(Color.Green)
                .padding(8.dp)
        )
        Box (
            modifier = Modifier
                .clip(
                    RoundedCornerShape(2.dp)
                )
                .size(6.dp)
                .background(Color.LightGray)
        )
        Text(
            fontSize = 34.sp,
            text = dateTime.format(minute),
            modifier = Modifier
                .clip(
                    RoundedCornerShape(6.dp)
                )
                .background(Color.Green)
                .padding(8.dp)
        )
    }
}