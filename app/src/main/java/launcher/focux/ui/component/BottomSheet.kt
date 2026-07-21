package launcher.focux.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import launcher.focux.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BottomSheet() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onSecondaryContainer)
//            .height(400.dp)
            .padding(horizontal = 12.dp, vertical = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 16.dp)
        ) {
            Button(
                onClick =  {},
                modifier = Modifier
                    .height(64.dp)
                    .weight(0.5f)
                    .padding(end = 6.dp),
                shape = RoundedCornerShape(
                    16.dp
                )
            ) {
                Icon(
                    painter = painterResource(R.drawable.activity),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(16.dp)
                )
                Text(
                    text = "App Info"
                )
            }
            Button(
                onClick =  {},
                shape = RoundedCornerShape(
                    16.dp
                ),
                modifier = Modifier
                    .height(64.dp)
                    .weight(0.5f)
                    .padding(start = 6.dp),
            ) {
                Icon(
                    painter = painterResource(R.drawable.activity),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(16.dp)
                )
                Text(
                    text = "Setting"
                )
            }
        }

        Button(
            onClick =  {},
            shape = RoundedCornerShape(
                16.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .height(54.dp)

        ) {
            Icon(
                painter = painterResource(R.drawable.activity),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(16.dp)
            )
            Text(
                text = "Hide App"
            )
        }

        Button(
            onClick =  {},
            shape = RoundedCornerShape(
                16.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .height(54.dp)

        ) {
            Icon(
                painter = painterResource(R.drawable.activity),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(16.dp)
            )
            Text(
                text = "App To Pinned Apps"
            )
        }

        Button(
            onClick =  {},
            shape = RoundedCornerShape(
                16.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .height(54.dp)

        ) {
            Icon(
                painter = painterResource(R.drawable.activity),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(16.dp)
            )
            Text(
                text = "Rename App"
            )
        }

        Button(
            onClick =  {},
            shape = RoundedCornerShape(
                16.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .height(54.dp)

        ) {
            Icon(
                painter = painterResource(R.drawable.activity),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(16.dp)
            )
            Text(
                text = "Delete App"
            )
        }
    }
}