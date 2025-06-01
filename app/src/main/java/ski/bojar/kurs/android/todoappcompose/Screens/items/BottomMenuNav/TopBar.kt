package ski.bojar.kurs.android.todoappcompose.Screens.items.BottomMenuNav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar()
{
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Transparent)
        .height(50.dp)
        , contentAlignment = Alignment.CenterStart
    )
    {
        Text(text = "To Do App",Modifier.padding(start = 10.dp), fontSize = 30.sp, fontWeight = FontWeight.Bold)
    }
}

