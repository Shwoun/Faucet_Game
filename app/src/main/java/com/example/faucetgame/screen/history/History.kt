package com.example.faucetgame.screen.history

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.example.faucetgame.componanet.LocalDimensions
import com.example.faucetgame.ui.theme.black
import com.example.faucetgame.ui.theme.comla
import com.example.faucetgame.ui.theme.green


@Composable
fun HistoryScreen() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    var previousIndex by remember { mutableIntStateOf(0) }
    val options = listOf("Global", "My History")
    val respons = LocalDimensions.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(black)
            .padding(horizontal = respons.dp(8))
    ) {

        TabRow(
            selectedTabIndex = selectedIndex,
            contentColor = black,
            containerColor = comla, // Use your light white color
            modifier = Modifier
                .clip(RoundedCornerShape(respons.dp(8))),
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedIndex]),
                    height = respons.dp(4),
                    color = green
                )
            }
        ) {
            options.forEachIndexed { index, title ->
                Tab(
                    selected = selectedIndex == index,
                    onClick = {
                        previousIndex = selectedIndex
                        selectedIndex = index
                    },
                    text = {
                        Text(
                            text = title, fontSize = respons.sp(16f),
                            fontWeight = if (selectedIndex == index) FontWeight.Bold else FontWeight.Normal
                        )
                    },
                    selectedContentColor = green,
                    unselectedContentColor = black
                )
            }
        }

        AnimatedContent(
            targetState = selectedIndex,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = respons.dp(9)),
            transitionSpec = {
                val direction = if (targetState > initialState)
                    AnimatedContentTransitionScope.SlideDirection.Left
                else
                    AnimatedContentTransitionScope.SlideDirection.Right

                slideIntoContainer(direction) + fadeIn() togetherWith
                        slideOutOfContainer(direction) + fadeOut()
            }
        ) { index ->
            when (index) {
                0 -> GlobalHistoryView()
                1 -> MyHistoryView()
                else -> GlobalHistoryView()
            }
        }
    }
}