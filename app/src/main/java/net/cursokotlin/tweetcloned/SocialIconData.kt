package net.cursokotlin.tweetcloned

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class SocialIconData(val description: String,
                          val filledImage: Painter,
                          val unfilledImage: Painter,
                          val filledColor: Color,
                          val unfilledColor: Color)

