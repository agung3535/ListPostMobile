package com.tuyp.androidlistjc.presentation.home.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import com.tuyp.androidlistjc.presentation.ui.component.PostComponent
import com.tuyp.androidlistjc.presentation.ui.theme.AndroidListJCTheme



@Composable
fun PostScreen(postList: List<PostResponse>? = null,
state: MutableState<TextFieldValue>,
onClickData: (Int) -> Unit = {}) {
    var filteredPost: List<PostResponse>
    if (postList == null) return
    val searchText = state.value.text
    filteredPost = if (searchText.isEmpty()) {
        postList
    }else {
        var result = ArrayList<PostResponse>()
        for (data in postList) {
            if (data.title.lowercase().contains(searchText.lowercase())) {
                result.add(data)
            }
        }
        result
    }

    LazyColumn {

        items(filteredPost.size,
            key = {
                filteredPost[it].id
            },
            itemContent = { index ->
               filteredPost[index].let { postData ->
                   val title = postData.title
                   PostComponent(title = title, onClickData = {
                       postData.id?.let { onClickData.invoke(it) }
                   })
               }
            })
//        items(10,
//            itemContent = { index ->
//                Card(modifier = Modifier.
//                    padding(10.dp)
//                    .clip(RoundedCornerShape(10.dp))
////                    .border(1.dp,Color.White, RoundedCornerShape(10.dp))
//                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(10.dp))) {
//                    Text(text = "tessssss",
//                        fontWeight = FontWeight.Bold,
//                        color= Color.Gray,
//                        modifier = Modifier.fillMaxWidth()
//                            .padding(10.dp)
//                            .background(Color.White))
//                }
//            })
//        itemsIndexed(postList) { index, data ->
//            Text(text = data.title,
//                color= Color.White,
//                modifier = Modifier.fillMaxWidth()
//                    .padding(vertical = 24.dp)
//                    .background(Color.Blue))
//        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun PostScreenPreview() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    AndroidListJCTheme {
        PostScreen(state = textState)
    }
}