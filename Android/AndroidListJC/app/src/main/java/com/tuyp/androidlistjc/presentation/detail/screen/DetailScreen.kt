package com.tuyp.androidlistjc.presentation.detail.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tuyp.androidlistjc.presentation.detail.viewmodel.DetailViewModel
import com.tuyp.androidlistjc.presentation.ui.theme.AndroidListJCTheme


@Composable
fun DetailScreen(modifier: Modifier = Modifier,
title: String = "",
body: String = "") {
    Column(modifier = modifier.fillMaxSize()) {
        Spacer(modifier = modifier.height(10.dp))
        Text(text = title,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        fontSize = 18.sp,
        modifier = modifier.fillMaxWidth())
        Spacer(modifier = modifier.height(10.dp))
        Box(modifier = modifier
            .padding(horizontal = 15.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, MaterialTheme.colors.primary, RoundedCornerShape(10.dp))
            ) {
            Text(text = body,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Justify,
                fontSize = 12.sp,
                modifier = modifier.fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp))
        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun DetailScreenPreview() {
    AndroidListJCTheme {
        DetailScreen()
    }
}