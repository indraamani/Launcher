package launcher.focux.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import launcher.focux.R
import launcher.focux.ui.widget.BoxedClock
import launcher.focux.ui.widget.Clock
import launcher.focux.ui.widget.DateClockWidget
import launcher.focux.ui.widget.DateWidget
import launcher.focux.ui.widget.DayClockWidget
import launcher.focux.ui.widget.DayWidget
import launcher.focux.ui.widget.HourGrid
import launcher.focux.ui.widget.MonthGrid
import launcher.focux.ui.widget.YearGrid

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopWidgetScreen(
    closeScreen: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = {
                            closeScreen()
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.arrow),
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Text(
                text = "Choose Top Widget",
                modifier = Modifier
                    .padding(horizontal = 12.dp, 30.dp),
                fontSize = 22.sp,
            )

            LazyColumn(
                contentPadding = PaddingValues(horizontal = 20.dp)
            ) {
                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .padding(vertical = 20.dp)
                            .clip(
                                RoundedCornerShape(120.dp)
                            )
                            .background(Color(255f, 255f, 255f, 0.5f))
                    ) {
                        BoxedClock(R.font.valorant)
                    }
                }

                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .padding(vertical = 20.dp)
                            .clip(
                                RoundedCornerShape(120.dp)
                            )
                            .background(Color(255f, 255f, 255f, 0.5f))
                    ) {
                        Clock(R.font.valorant)
                    }
                }

                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .padding(vertical = 20.dp)
                            .clip(
                                RoundedCornerShape(120.dp)
                            )
                            .background(Color(255f, 255f, 255f, 0.5f))
                    ) {
                        DayWidget(R.font.valorant)
                    }
                }

                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .padding(vertical = 20.dp)
                            .clip(
                                RoundedCornerShape(120.dp)
                            )
                            .background(Color(255f, 255f, 255f, 0.5f))
                    ) {
                        DateWidget(R.font.valorant)
                    }
                }

                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .padding(vertical = 20.dp)
                            .clip(
                                RoundedCornerShape(120.dp)
                            )
                            .background(Color(255f, 255f, 255f, 0.5f))
                    ) {
                        DayClockWidget(R.font.valorant)
                    }
                }

                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .padding(vertical = 20.dp)
                            .clip(
                                RoundedCornerShape(120.dp)
                            )
                            .background(Color(255f, 255f, 255f, 0.5f))
                    ) {
                        DateClockWidget(R.font.valorant)
                    }
                }

                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .padding(vertical = 20.dp)
                            .clip(
                                RoundedCornerShape(120.dp)
                            )
                            .background(Color(255f, 255f, 255f, 0.5f))
                    ) {
                        HourGrid()
                    }
                }

                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .padding(vertical = 20.dp)
                            .clip(
                                RoundedCornerShape(120.dp)
                            )
                            .background(Color(255f, 255f, 255f, 0.5f))
                    ) {
                        MonthGrid()
                    }
                }

                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .padding(vertical = 20.dp)
                            .clip(
                                RoundedCornerShape(120.dp)
                            )
                            .background(Color(255f, 255f, 255f, 0.5f))
                    ) {
                        YearGrid()
                    }
                }
            }

        }
    }
}