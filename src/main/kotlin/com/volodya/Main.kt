package com.volodya

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.FontImageMap
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import java.awt.Toolkit

fun main() = application {
    configure {
        width = Toolkit.getDefaultToolkit().screenSize.width / 2
        height = Toolkit.getDefaultToolkit().screenSize.height / 2

    }

    program {

        val image = loadImage("file:data/images/pm5544.png")
        val font = FontImageMap.fromUrl("file:data/fonts/IBMPlexMono-Regular.ttf", 64.0)

        extend {
            drawer.drawStyle.colorMatrix = tint(ColorRGBa.WHITE.shade(0.2))
            drawer.image(image)

            drawer.fill = ColorRGBa.PINK
            drawer.circle(Math.cos(seconds)*width/2.0+width/2.0, Math.sin(0.5*seconds)*height/2.0 + height/2.0, 140.0)

            drawer.fontMap = font
            drawer.fill = ColorRGBa.WHITE
            drawer.text("OPENRNDR", width/2.0, height /2.0)
        }
    }
}