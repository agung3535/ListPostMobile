package com.tuyp.androidlistjc.presentation

sealed class Route(val route: String) {
    object Home: Route("Home")
    object Detail: Route("Detail/{postId}") {
        fun createRoute(postId: Int) = "Detail/$postId"
    }
}
