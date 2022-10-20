package com.tuyp.androidlistjc.utilstest

import com.tuyp.androidlistjc.entities.data.reponse.PostResponse

object DataDummy {
    fun generatePostDumy(): List<PostResponse> {
        val postList = ArrayList<PostResponse>()
        for (i in 0..99) {
            val post = PostResponse(
                userID = i, id = i, title = "post ${i}", body = "body description ${i}"
            )
            postList.add(post)
        }

        return postList
    }

    fun generateDetailPost(postID: Int): PostResponse {
        return PostResponse( userID = 1, id = postID, title = "post ${1}", body = "body description ${1}")
    }
}