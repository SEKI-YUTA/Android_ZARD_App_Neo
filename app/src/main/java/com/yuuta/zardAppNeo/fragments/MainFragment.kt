package com.yuuta.zardAppNeo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.NavHostFragment
import com.yuuta.zardAppNeo.R
import com.yuuta.zardAppNeo.ui.MainNavHost
import com.yuuta.zardAppNeo.ui.theme.ZARDAppNeoTheme
import com.yuuta.zardAppNeo.ui.viewmodel.ZARDAppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    lateinit var composeView: ComposeView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view =
            requireActivity().layoutInflater.inflate(R.layout.fragment_main, container, false)
        val navHostFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        composeView = view.findViewById(R.id.composeView)

        composeView.setContent {
            val zardAppViewModel: ZARDAppViewModel = viewModel()
            ZARDAppNeoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    MainNavHost(zardAppViewModel = zardAppViewModel)
                }
            }
        }

        return view
    }
}
