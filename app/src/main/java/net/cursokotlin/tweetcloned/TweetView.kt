package net.cursokotlin.tweetcloned

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    val socialIcon: List<SocialIconData> = listOf(
        SocialIconData(
            "chat icon",
            painterResource(id = R.drawable.ic_chat_filled),
            painterResource(id = R.drawable.ic_chat),
            Color.Gray,
            Color.Gray
        ),

        SocialIconData(
            "retwitted icon",
            painterResource(id = R.drawable.ic_rt),
            painterResource(id = R.drawable.ic_rt),
            Color.Green,
            Color.Gray
        ),
        SocialIconData(
            "like icon",
            painterResource(id = R.drawable.ic_like_filled),
            painterResource(id = R.drawable.ic_like),
            Color.Red,
            Color.Gray
        ),
        )

    Row(Modifier.fillMaxWidth()) {
        socialIcon.map {
            SocialIcon(socialData = it)
            Spacer(modifier = Modifier.size(32.dp))
        }
    }
}

@Composable
fun SocialIcon(
    socialData: SocialIconData
) {
    var clicked by rememberSaveable { mutableStateOf(false) }
    var clicks by rememberSaveable { mutableStateOf(1) }
    IconButton(onClick = { clicked = !clicked }) {
        var image: Painter;
        var color: Color;
        Row() {
            if (clicked) {
                image = socialData.filledImage
                color = socialData.filledColor
                clicks = 2
            } else {
                image = socialData.unfilledImage
                color = socialData.unfilledColor
                clicks = 1
            }
            Icon(image, contentDescription = socialData.description, tint = color)
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = clicks.toString(),
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
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
        painter = painterResource(id = R.drawable.mensaje), contentDescription = "imagen del post",
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
        text = "Es importante destacar que muchas personas y organizaciones trabajan actualmente para prohibir el desarrollo y uso de armas autónomas. En 2018, la comunidad internacional discutió la creación de una convención internacional que prohíba las armas autónomas, y en 2019, más de 1000 expertos en IA y robótica firmaron una carta abierta instando a la prohibición de estas armas.",
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
