package net.cursokotlin.tweetcloned

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import kotlin.math.round


@Preview()
@Composable
fun TweetView() {
    Box(
        Modifier
            .fillMaxSize()

    ) {
        Column(Modifier.fillMaxWidth()) {
            Row() {
                Side()
                Body()
            }

            Divider(Modifier.background(color = Color.White))
        }

    }
}

@Composable
fun Body() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(end = 20.dp)
    ) {
        TwHeader()
        TwBody()
        TwFooter()

    }
}

@Composable
fun TwFooter() {
    var liked by remember { mutableStateOf(false) }
    var retwitted by remember { mutableStateOf(false) }
    var commented by remember { mutableStateOf(false) }

    var likes by remember { mutableStateOf(1) }
    var retwits by remember { mutableStateOf(1) }
    var comments by remember { mutableStateOf(1) }

    Row(Modifier.fillMaxWidth()) {
        IconButton(onClick = { commented = !commented }) {
            var image: Painter;
            var color: Color;
            Row() {
                if (commented) {
                    image = painterResource(id = R.drawable.ic_chat_filled)
                    color = Color.Gray
                    comments = 2
                } else {
                    image = painterResource(id = R.drawable.ic_chat)
                    color = Color.Gray
                    comments = 1
                }
                Icon(image, contentDescription = "chat icon", tint = color)
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = comments.toString(),
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }

        Spacer(modifier = Modifier.size(32.dp))

        IconButton(onClick = { retwitted = !retwitted }) {
            var image: Painter;
            var color: Color;
            Row() {
                if (retwitted) {
                    image = painterResource(id = R.drawable.ic_rt)
                    color = Color.Green
                    retwits = 2
                } else {
                    image = painterResource(id = R.drawable.ic_rt)
                    color = Color.Gray
                    retwits = 1
                }
                Icon(image, contentDescription = "retwitted icon", tint = color)
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = retwits.toString(),
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
        Spacer(modifier = Modifier.size(32.dp))
        IconButton(onClick = { liked = !liked }) {
            var image: Painter;
            var color: Color;
            Row() {
                if (liked) {
                    image = painterResource(id = R.drawable.ic_like_filled)
                    color = Color.Red
                    likes = 2
                } else {
                    image = painterResource(id = R.drawable.ic_like)
                    color = Color.Gray
                    likes = 1
                }
                Icon(image, contentDescription = "like icon", tint = color)
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = likes.toString(),
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }

        }


    }
}

@Composable
fun TwBody() {
    Column() {
        Spacer(modifier = Modifier.size(6.dp))
        Message()
        Spacer(modifier = Modifier.size(12.dp))
        ImageContent()

    }

}

@Composable
fun ImageContent() {

    Image(
        painter = painterResource(id = R.drawable.profile), contentDescription = "imagen del post",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp)
            .clip(RoundedCornerShape(16.dp))
    )


}

@Composable
fun Message() {
    Text(
        text = "La IA y otras tecnologías avanzadas tienen el potencial de ser extremadamente poderosas y tener un gran impacto en la sociedad, y existe la posibilidad de que si no se utilizan de manera responsable, se puedan causar daños significativos. Por ejemplo, la IA puede ser utilizada para la creación de armas autónomas",
        fontSize = 15.sp,
        textAlign = TextAlign.Left,
        color = Color.White
    )

}

@Composable
fun TwHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .size(width = 0.dp, height = 34.dp)
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        Row(
        ) {
            Text(
                text = "Aris",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                color = Color.White
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "@AristiDevs",
                fontSize = 14.sp,
                textAlign = TextAlign.Left,
                color = Color.Gray,
            )
            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = "4h",
                fontSize = 14.sp,
                textAlign = TextAlign.Left,
                color = Color.Gray,
            )
        }

        IconButton(onClick = {}, Modifier.size(28.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_dots),
                contentDescription = "icon dots",
                tint = Color.White,
                modifier = Modifier.scale(1.6f)
            )
        }
    }

}


@Composable
fun Side() {
    Column() {
        Box(Modifier.padding(16.dp)) {
            UserIcon()
        }

    }
}

@Composable
fun UserIcon() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "user icon",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(76.dp)
            .clip(CircleShape)
            .border(1.dp, Color.Black, CircleShape)
    )
}
