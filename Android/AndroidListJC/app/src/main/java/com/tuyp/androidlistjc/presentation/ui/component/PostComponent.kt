package com.tuyp.androidlistjc.presentation.ui.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tuyp.androidlistjc.presentation.ui.theme.AndroidListJCTheme

//card click still on experimental
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostComponent(modifier: Modifier = Modifier,
title: String = "",
onClickData: () -> Unit = {}) {
    Card(
        onClick = onClickData,
        modifier = Modifier
            .padding(10.dp)
            .shadow(elevation = 5.dp, shape = RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colors.background),
        ) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp, vertical = 24.dp),
            text = title,
            fontWeight = FontWeight.Bold,

            )
    }



}

@Preview(showSystemUi = true)
@Composable
fun PostComponentPreview() {
    AndroidListJCTheme {
        PostComponent()
    }
}