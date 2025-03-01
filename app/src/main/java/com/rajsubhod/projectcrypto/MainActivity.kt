package com.rajsubhod.projectcrypto

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rajsubhod.projectcrypto.core.presentation.util.ObserveAsEvents
import com.rajsubhod.projectcrypto.core.presentation.util.toString
import com.rajsubhod.projectcrypto.crypto.presentation.coin_list.CoinListEvent
import com.rajsubhod.projectcrypto.crypto.presentation.coin_list.CoinListViewModel
import com.rajsubhod.projectcrypto.crypto.presentation.coin_list.components.CoinListScreen
import com.rajsubhod.projectcrypto.ui.theme.ProjectCryptoTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectCryptoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel = koinViewModel<CoinListViewModel>()
                    val state by viewModel.state.collectAsStateWithLifecycle()
                    val context = LocalContext.current
                    ObserveAsEvents(events = viewModel.events) { event ->
                        when(event) {
                            is CoinListEvent.Error -> {
                                Toast.makeText(
                                    context,
                                    event.error.toString(context),
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }
                    CoinListScreen(
                        state = state,
                        modifier = Modifier.padding(innerPadding),
                        onAction = viewModel::onAction
                    )
                }
            }
        }
    }
}
