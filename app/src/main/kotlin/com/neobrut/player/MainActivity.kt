package com.neobrut.player

import android.app.Activity
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowInsets
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val scroll = ScrollView(this).apply {
            isFillViewport = true
            setBackgroundColor(PAPER)
            if (Build.VERSION.SDK_INT >= 35) {
                setOnApplyWindowInsetsListener { view, insets ->
                    val bars = insets.getInsets(WindowInsets.Type.systemBars())
                    view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
                    insets
                }
            }
        }
        val page = column().apply { setPadding(dp(20), dp(20), dp(20), dp(28)) }
        scroll.addView(page)

        val header = LinearLayout(this).apply {
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(14), dp(12), dp(14), dp(12))
            setBackgroundColor(INK)
        }
        header.addView(text("NEOBRUT", 22, Color.WHITE, true), LinearLayout.LayoutParams(0, -2, 1f))
        header.addView(text("///", 25, LIME, true))
        page.addView(header, match())

        val eyebrow = text("YOUR MUSIC. YOUR RULES.", 12, INK, true).apply { letterSpacing = 0.12f }
        addWithTop(page, eyebrow, 30)

        val title = text("LOUD LOOKS.\nLOCAL SOUND.", 42, INK, true).apply { setLineSpacing(dp(-2).toFloat(), 1f) }
        addWithTop(page, title, 12)

        val intro = text("Welcome to NeoBrut Player — a music player made for your own collection.", 17, INK, false)
            .apply { setLineSpacing(dp(4).toFloat(), 1f) }
        addWithTop(page, intro, 16)

        val card = column().apply {
            setPadding(dp(18), dp(18), dp(18), dp(18))
            background = border(LIME, INK, 3)
        }
        card.addView(text("01 / GETTING STARTED", 12, INK, true).apply { letterSpacing = 0.08f })
        addWithTop(card, text("GOOD MUSIC\nLIVES HERE.", 28, INK, true), 14)
        val description = text("Your library, playlists and player controls are on the way.", 15, INK, false)
            .apply { setLineSpacing(dp(3).toFloat(), 1f) }
        addWithTop(card, description, 12)
        addWithTop(page, card, 30)

        val status = LinearLayout(this).apply {
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(14), dp(14), dp(14), dp(14))
            background = border(PAPER, INK, 3)
        }
        val statusText = text("UNDER CONSTRUCTION", 13, INK, true).apply { letterSpacing = 0.06f }
        status.addView(statusText, LinearLayout.LayoutParams(0, -2, 1f))
        status.addView(text("↗", 22, INK, true))
        addWithTop(page, status, 12)

        val footer = text("OFFLINE BY DESIGN  /  BUILT FOR YOUR MUSIC", 10, INK, true).apply { letterSpacing = 0.05f }
        addWithTop(page, footer, 30)
        setContentView(scroll)
    }

    private fun dp(value: Int): Int = (value * resources.displayMetrics.density + 0.5f).toInt()

    private fun column() = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }

    private fun text(value: String, size: Int, color: Int, bold: Boolean) = TextView(this).apply {
        text = value
        textSize = size.toFloat()
        setTextColor(color)
        typeface = if (bold) Typeface.create("sans-serif-condensed", Typeface.BOLD) else Typeface.create("sans-serif", Typeface.NORMAL)
    }

    private fun border(fill: Int, stroke: Int, width: Int) = GradientDrawable().apply {
        setColor(fill)
        setStroke(dp(width), stroke)
    }

    private fun match() = LinearLayout.LayoutParams(-1, -2)

    private fun addWithTop(parent: LinearLayout, child: View, margin: Int) {
        val params = match().apply { topMargin = dp(margin) }
        parent.addView(child, params)
    }

    companion object {
        private val INK = Color.rgb(17, 17, 17)
        private val PAPER = Color.rgb(247, 246, 237)
        private val LIME = Color.rgb(184, 255, 0)
    }
}
