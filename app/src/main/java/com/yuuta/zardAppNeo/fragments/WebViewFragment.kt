package com.yuuta.zardAppNeo.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.yuuta.zardAppNeo.R

class WebViewFragment : Fragment() {
    private val args: WebViewFragmentArgs by navArgs()
    private lateinit var webView: WebView
    private lateinit var urlText: TextView
    private lateinit var closeButton: ImageButton
    private lateinit var shareButton: ImageButton

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

        ViewCompat.setOnApplyWindowInsetsListener(view) { v, windowInsets ->
            val insets = windowInsets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            v.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                leftMargin = insets.left
                bottomMargin = insets.bottom
                topMargin = insets.top
                rightMargin = insets.right
            }
            WindowInsetsCompat.CONSUMED
        }

        webView = view.findViewById(R.id.webView)
        urlText = view.findViewById(R.id.url_text)
        closeButton = view.findViewById(R.id.close_button)
        shareButton = view.findViewById(R.id.share_button)
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        }
        webView.webViewClient = WebViewClient()
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
}
