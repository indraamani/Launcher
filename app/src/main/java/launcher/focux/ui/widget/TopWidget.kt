package launcher.focux.ui.widget

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import launcher.focux.datastore.app.applicationDatastore
import java.time.LocalDateTime
import java.time.Year
import java.time.format.DateTimeFormatter

@Composable
fun BoxedClock(font: Int) {
    val dateTime = LocalDateTime.now()
    val hour = DateTimeFormatter.ofPattern("HH")
    val minute = DateTimeFormatter.ofPattern("mm")

    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = dateTime.format(hour),
            fontFamily = FontFamily(
                Font(font)
            ),
            maxLines = 1,
            modifier = Modifier
                .clip(
                    RoundedCornerShape(12.dp)
                )
                .background(MaterialTheme.colorScheme.primary)
                .wrapContentHeight(Alignment.CenterVertically)
                .width(62.dp)
                .padding(vertical = 10.dp),
            fontSize = 34.sp,
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
        Box(

        ) { }
        Text(
            text = dateTime.format(minute),
            fontFamily = FontFamily(
                Font(font)
            ),
            maxLines = 1,
            modifier = Modifier
                .clip(
                    RoundedCornerShape(12.dp)
                )
                .background(MaterialTheme.colorScheme.primary)
                .wrapContentHeight(Alignment.CenterVertically)
                .width(62.dp)
                .padding(vertical = 10.dp),
            fontSize = 34.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Clock(font: Int) {
    val dateTime = LocalDateTime.now()
    val hour = DateTimeFormatter.ofPattern("HH")
    val minute = DateTimeFormatter.ofPattern("mm")

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            fontSize = 34.sp,
            maxLines = 1,
            text = dateTime.format(hour),
            color = MaterialTheme.colorScheme.primary,
            fontFamily = FontFamily(
                Font(font)
            ),
            modifier = Modifier
                .clip(
                    RoundedCornerShape(6.dp)
                )
        )
        Column {
            Box (
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(4.dp)
                    )
                    .size(4.dp)
                    .background(Color.LightGray)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Box (
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(4.dp)
                    )
                    .size(4.dp)
                    .background(Color.LightGray)
            )
        }
        Text(
            fontSize = 34.sp,
            maxLines = 1,
            text = dateTime.format(minute),
            color = Color.White,
            fontFamily = FontFamily(
                Font(font)
            ),
            modifier = Modifier
                .clip(
                    RoundedCornerShape(6.dp)
                )
        )
    }
}

@Composable
fun DayWidget(font: Int) {
    val dateTime = LocalDateTime.now()
    val day = DateTimeFormatter.ofPattern("EEEE")

    Text(
        text = dateTime.format(day),
        fontSize = 20.sp,
        color = MaterialTheme.colorScheme.primary,
        letterSpacing = 1.sp,
        fontFamily = FontFamily(
            Font(font)
        )
    )
}

@Composable
fun DateWidget(font: Int) {
    val dateTime = LocalDateTime.now()
    val formate = DateTimeFormatter.ofPattern("EEE MMMM dd")

    Text(
        text = dateTime.format(formate),
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.primary,
        letterSpacing = 1.sp,
        fontFamily = FontFamily(
            Font(font)
        )
    )
}

@Composable
fun DayClockWidget(font: Int) {
    val dateTime = LocalDateTime.now()
    val hour = DateTimeFormatter.ofPattern("HH")
    val minute = DateTimeFormatter.ofPattern("mm")
    val day = DateTimeFormatter.ofPattern("EEEE")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = dateTime.format(day),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.primary,
            letterSpacing = 1.sp,
            fontFamily = FontFamily(
                Font(font)
            ),
            modifier = Modifier
                .padding(bottom = 4.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                fontSize = 34.sp,
                text = dateTime.format(hour),
                color = MaterialTheme.colorScheme.primary,
                fontFamily = FontFamily(
                    Font(font)
                ),
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(6.dp)
                    )
            )
            Column {
                Box (
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(4.dp)
                        )
                        .size(4.dp)
                        .background(Color.LightGray)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Box (
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(4.dp)
                        )
                        .size(4.dp)
                        .background(Color.LightGray)
                )
            }
            Text(
                fontSize = 34.sp,
                text = dateTime.format(minute),
                color = Color.White,
                fontFamily = FontFamily(
                    Font(font)
                ),
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(6.dp)
                    )
            )
        }
    }
}

@Composable
fun DateClockWidget(font: Int) {
    val dateTime = LocalDateTime.now()
    val hour = DateTimeFormatter.ofPattern("HH")
    val minute = DateTimeFormatter.ofPattern("mm")
    val formate = DateTimeFormatter.ofPattern("EEE MMMM dd")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = dateTime.format(formate),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.primary,
            letterSpacing = 1.sp,
            fontFamily = FontFamily(
                Font(font)
            ),
            modifier = Modifier
                .padding(bottom = 4.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                fontSize = 34.sp,
                text = dateTime.format(hour),
                color = MaterialTheme.colorScheme.primary,
                fontFamily = FontFamily(
                    Font(font)
                ),
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(6.dp)
                    )
            )
            Column {
                Box (
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(4.dp)
                        )
                        .size(4.dp)
                        .background(Color.LightGray)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Box (
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(4.dp)
                        )
                        .size(4.dp)
                        .background(Color.LightGray)
                )
            }
            Text(
                fontSize = 34.sp,
                text = dateTime.format(minute),
                color = Color.White,
                fontFamily = FontFamily(
                    Font(font)
                ),
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(6.dp)
                    )
            )
        }
    }
}

@Composable
fun HourGrid() {
    val hour = LocalDateTime.now().hour

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth(0.4f),
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
            .fillMaxWidth(0.4f),
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
            .fillMaxWidth(0.3f),
        columns = GridCells.Fixed(12),
    ) {
        items(
            count = 12,
        ) { index ->
            Box (
                modifier = Modifier
                    .aspectRatio(1f)
                    .padding(2.dp)
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