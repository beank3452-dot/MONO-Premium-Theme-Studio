package com.umbrella.mono

import android.app.Activity
import android.app.WallpaperManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    private val ivory = 0xFFEEEAE3.toInt()
    private val ink = 0xFF242424.toInt()
    private val muted = 0xFF716C65.toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ivory
        window.navigationBarColor = 0xFF111111.toInt()
        window.decorView.systemUiVisibility = android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        val scroll = ScrollView(this)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(22), dp(26), dp(22), dp(28))
            setBackgroundColor(ivory)
        }
        scroll.addView(root)

        root.addView(label("MONO", 13, ink, true))
        root.addView(label("PREMIUM THEME STUDIO", 10, muted, false).apply { letterSpacing = 0.22f })
        root.addView(space(20))

        val preview = ImageView(this).apply {
            setImageResource(R.drawable.mono_misty_mountains)
            scaleType = ImageView.ScaleType.CENTER_CROP
            contentDescription = "Misty mountain forest wallpaper preview"
        }
        root.addView(preview, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(390)))
        root.addView(space(18))
        root.addView(label("A quieter screen.", 29, ink, true))
        root.addView(label("Misty landscapes · editorial type · monochrome details", 13, muted, false))
        root.addView(space(22))

        root.addView(section("01 / WALLPAPER"))
        root.addView(label("Apply the MONO misty mountain wallpaper to your Home screen, Lock screen, or both.", 14, ink, false))
        root.addView(space(10))
        root.addView(actionButton("SET WALLPAPER") { applyWallpaper() })
        root.addView(space(24))

        root.addView(section("02 / HOME-SCREEN WIDGET"))
        root.addView(label("Add the MONO Month & Clock widget from your phone's widget picker. It displays the current month, date and a 24-hour digital clock.", 14, ink, false))
        root.addView(space(10))
        root.addView(actionButton("HOW TO ADD WIDGET") {
            Toast.makeText(this, "Long-press Home screen → Widgets → MONO → Month & Clock → Add", Toast.LENGTH_LONG).show()
        })
        root.addView(space(24))

        root.addView(section("03 / MONOCHROME ICONS"))
        root.addView(label("Android apps cannot replace Samsung launcher icons directly. Use Samsung Good Lock → Theme Park to create and apply a compatible monochrome icon theme.", 14, ink, false))
        root.addView(space(10))
        root.addView(actionButton("ICON CUSTOMIZATION GUIDE") {
            Toast.makeText(this, "Open Galaxy Store → Good Lock → Theme Park → Icon → Create new", Toast.LENGTH_LONG).show()
        })
        root.addView(space(24))
        root.addView(label("MONO 1.0.0  ·  MADE FOR A CALMER HOME SCREEN", 9, muted, false).apply { gravity = Gravity.CENTER })
        setContentView(scroll)
    }

    private fun applyWallpaper() {
        try {
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.mono_misty_mountains)
            WallpaperManager.getInstance(this).setBitmap(bitmap)
            Toast.makeText(this, "Wallpaper applied. Choose Home or Lock screen in system wallpaper settings if prompted.", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Couldn't apply wallpaper: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
        }
    }

    private fun label(text: String, size: Int, color: Int, bold: Boolean) = TextView(this).apply {
        this.text = text; textSize = size.toFloat(); setTextColor(color)
        if (bold) setTypeface(typeface, android.graphics.Typeface.BOLD)
    }
    private fun section(text: String) = TextView(this).apply {
        this.text = text; textSize = 10f; setTextColor(muted); letterSpacing = 0.18f
        setPadding(0, 0, 0, dp(8))
    }
    private fun actionButton(text: String, action: () -> Unit) = Button(this).apply {
        this.text = text; setTextColor(0xFFFFFFFF.toInt()); setBackgroundColor(ink)
        setOnClickListener { action() }
    }
    private fun space(height: Int) = android.view.View(this).apply { layoutParams = LinearLayout.LayoutParams(1, dp(height)) }
    private fun dp(value: Int) = (value * resources.displayMetrics.density).toInt()
}
