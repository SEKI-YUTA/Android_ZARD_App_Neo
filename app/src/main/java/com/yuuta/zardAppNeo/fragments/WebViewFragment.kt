package com.yuuta.zardAppNeo.fragments

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.yuuta.resource.theme.ZARD_BLUE
import com.yuuta.zardAppNeo.R

class WebViewFragment : Fragment() {
    private val args: WebViewFragmentArgs by navArgs()
    private lateinit var webView: WebView
    private lateinit var imgFavicon: ImageView
    private lateinit var urlText: TextView
    private lateinit var closeButton: ImageButton
    private lateinit var shareButton: ImageButton
    private lateinit var loadingProgress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_webview, container, false)
        webView = view.findViewById(R.id.webView)
        imgFavicon = view.findViewById(R.id.img_favicon)
        urlText = view.findViewById(R.id.url_text)
        closeButton = view.findViewById(R.id.close_button)
        shareButton = view.findViewById(R.id.share_button)
        loadingProgress = view.findViewById(R.id.loading_progress)
        loadingProgress.progressTintList = ColorStateList.valueOf(colorToInt(ZARD_BLUE))
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        }
        val webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                loadingProgress.setProgress(newProgress, false)
            }
            override fun onReceivedIcon(view: WebView?, icon: Bitmap?) {
                super.onReceivedIcon(view, icon)
                if(icon != null) {
                    imgFavicon.setImageBitmap(icon)
                }
            }
        }
        webView.webChromeClient = webChromeClient
        webView.loadUrl(args.webUrl)
        return view
    }

    override fun onResume() {
        super.onResume()
        closeButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        shareButton.setOnClickListener {
            val shareIntent =
                Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, args.webUrl)
                }
            val chooserIntent = Intent.createChooser(shareIntent, "Share via")
            startActivity(chooserIntent)
        }
        urlText.text = args.webUrl
    }

    fun colorToInt(color: Color): Int {
        // 各コンポーネントを取得
        val alpha = (color.alpha * 255).toInt() and 0xFF
        val red = (color.red * 255).toInt() and 0xFF
        val green = (color.green * 255).toInt() and 0xFF
        val blue = (color.blue * 255).toInt() and 0xFF

        // 各コンポーネントをシフトして1つの整数に組み合わせる
        return (alpha shl 24) or (red shl 16) or (green shl 8) or blue
    }
}
