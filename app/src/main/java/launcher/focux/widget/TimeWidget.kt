package launcher.focux.widget

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.collectLatest
import launcher.focux.datastore.userpreference.preferenceDatastore
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun BoxedClock() {
    val dateTime = LocalDateTime.now()
    val hour = DateTimeFormatter.ofPattern("HH")
    val minute = DateTimeFormatter.ofPattern("mm")

    Row(
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Clock(ctx: Context) {
    val dateTime = LocalDateTime.now()
    val hour = DateTimeFormatter.ofPattern("HH")
    val minute = DateTimeFormatter.ofPattern("mm")

    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            fontSize = 34.sp,
            text = dateTime.format(hour),
            color = Color.Green,
            fontFamily = FontFamily(
                Font(ctx.preferenceDatastore.data.collectAsState(initial = null).value!!.font)
            ),
            modifier = Modifier
                .clip(
                    RoundedCornerShape(6.dp)
                )
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
            fontFamily = FontFamily(
                Font(ctx.preferenceDatastore.data.collectAsState(initial = null).value!!.font)
            ),
            text = dateTime.format(minute),
            color = Color.White,
            modifier = Modifier
                .clip(
                    RoundedCornerShape(6.dp)
                )
                .padding(8.dp)
        )
    }
}