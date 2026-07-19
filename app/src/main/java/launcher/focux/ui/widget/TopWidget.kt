package launcher.focux.ui.widget

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDateTime
import java.time.Year
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
            fontSize = 44.sp,
            text = dateTime.format(hour),
            modifier = Modifier
                .clip(
                    RoundedCornerShape(12.dp)
                )
                .background(MaterialTheme.colorScheme.primary)
                .width(60.dp)
                .padding(vertical = 10.dp),
            textAlign = TextAlign.Center
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
            fontSize = 44.sp,
            text = dateTime.format(minute),
            modifier = Modifier
                .clip(
                    RoundedCornerShape(12.dp)
                )
                .background(MaterialTheme.colorScheme.primary)
                .width(60.dp)
                .padding(vertical = 10.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Clock(ctx: Context) {
    val dateTime = LocalDateTime.now()
    val hour = DateTimeFormatter.ofPattern("HH")
    val minute = DateTimeFormatter.ofPattern("mm")

    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            fontSize = 44.sp,
            text = dateTime.format(hour),
            color = MaterialTheme.colorScheme.primary,
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
            fontSize = 44.sp,
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

@Composable
fun DayWidget(ctx: Context) {
    val dateTime = LocalDateTime.now()
    val day = DateTimeFormatter.ofPattern("EEEE")

    Text(
        text = dateTime.format(day),
        fontSize = 32.sp,
        color = MaterialTheme.colorScheme.primary,
        letterSpacing = 1.sp,
    )
}

@Composable
fun DateWidget(ctx: Context) {
    val dateTime = LocalDateTime.now()
    val formate = DateTimeFormatter.ofPattern("EEE MMMM dd")

    Text(
        text = dateTime.format(formate),
        fontSize = 32.sp,
        color = MaterialTheme.colorScheme.primary,
        letterSpacing = 1.sp,
    )
}

@Composable
fun DayClockWidget() {
    val dateTime = LocalDateTime.now()
    val hour = DateTimeFormatter.ofPattern("HH")
    val minute = DateTimeFormatter.ofPattern("mm")
    val day = DateTimeFormatter.ofPattern("EEEE")

    Column(

    ) {
        Text(
            text = dateTime.format(day),
            fontSize = 32.sp,
            color = MaterialTheme.colorScheme.primary,
            letterSpacing = 1.sp,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                fontSize = 44.sp,
                text = dateTime.format(hour),
                color = MaterialTheme.colorScheme.primary,
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
                fontSize = 44.sp,
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
}

@Composable
fun DateClockWidget() {
    val dateTime = LocalDateTime.now()
    val hour = DateTimeFormatter.ofPattern("HH")
    val minute = DateTimeFormatter.ofPattern("mm")
    val formate = DateTimeFormatter.ofPattern("EEE MMMM dd")

    Column {
        Text(
            text = dateTime.format(formate),
            fontSize = 32.sp,
            color = MaterialTheme.colorScheme.primary,
            letterSpacing = 1.sp,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                fontSize = 44.sp,
                text = dateTime.format(hour),
                color = MaterialTheme.colorScheme.primary,
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
                fontSize = 44.sp,
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
}

@Composable
fun HourGrid() {
    val hour = LocalDateTime.now().hour

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth(0.5f),
        columns = GridCells.Fixed(12),
    ) {
        items(
            count = 24,
        ) { index ->
            Box (
                modifier = Modifier
                    .aspectRatio(1f)
                    .padding(4.dp)
                    .clip(
                        RoundedCornerShape(24.dp)
                    )
                    .background(
                        if (index < hour) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            Color.LightGray
                        }
                    )
            )
        }
    }
}

@Composable
fun MonthGrid() {
    val month = LocalDateTime.now().month.value
    val date = LocalDateTime.now().dayOfMonth
    val year = LocalDateTime.now().year.toLong()

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth(0.5f),
        columns = GridCells.Fixed(12),
    ) {
        items(
            count =
                if ((month % 2) == 0) {
                    30
                } else if (month == 2) {
                    if (Year.isLeap(year)) {
                        29
                    } else {
                        28
                    }
                } else {
                    31
                },
        ) { index ->
            Box (
                modifier = Modifier
                    .aspectRatio(1f)
                    .padding(4.dp)
                    .clip(
                        RoundedCornerShape(24.dp)
                    )
                    .background(
                        if (index <= date) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            Color.LightGray
                        }
                    )
            )
        }
    }
}


@Composable
fun YearGrid() {
    val month = LocalDateTime.now().month.value

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth(0.5f),
        columns = GridCells.Fixed(12),
    ) {
        items(
            count = 12,
        ) { index ->
            Box (
                modifier = Modifier
                    .aspectRatio(1f)
                    .padding(4.dp)
                    .clip(
                        RoundedCornerShape(24.dp)
                    )
                    .background(
                        if (index <= month) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            Color.LightGray
                        }
                    )
            )
        }
    }
}