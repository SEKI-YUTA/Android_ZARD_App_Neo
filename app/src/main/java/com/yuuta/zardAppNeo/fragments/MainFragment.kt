package com.yuuta.zardAppNeo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.yuuta.zardAppNeo.R
import com.yuuta.zardAppNeo.ui.theme.ZARDAppNeoTheme

class MainFragment : Fragment() {
    lateinit var composeView: ComposeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        composeView = view.findViewById(R.id.composeView)

        composeView.setContent {
            ZARDAppNeoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Text("HomeFragment")
                        Spacer(modifier = Modifier.size(16.dp))
                        Button(onClick = {
                            val direction = MainFragmentDirections.actionMainFragmentToWebviewFragment("https://www.google.com")
                            navController.navigate(direction)
                        }) {
                            Text("Navigate to WebViewFragment")
                        }
                    }
                }
            }
        }

        return view
    }
}
