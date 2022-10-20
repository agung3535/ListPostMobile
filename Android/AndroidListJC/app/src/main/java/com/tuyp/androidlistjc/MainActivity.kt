package com.tuyp.androidlistjc

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tuyp.androidlistjc.presentation.Route
import com.tuyp.androidlistjc.presentation.detail.DetailPage
import com.tuyp.androidlistjc.presentation.home.HomePage
import com.tuyp.androidlistjc.presentation.ui.theme.AndroidListJCTheme
import com.tuyp.androidlistjc.utils.ConstVal
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidListJCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainAppScreen()
                }
            }
        }
    }
}

@Composable
fun MainAppScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.Home.route) {
        composable(route = Route.Home.route) {
            HomePage(onClickData = { postId ->
                Log.d("dataaaaa","masuk click = ${postId}")
                navController.navigate(Route.Detail.createRoute(postId))
            })
        }
        composable(route = Route.Detail.route,
        arguments = listOf(
            navArgument(ConstVal.DETAIL_ARG_POST_ID) {
                type = NavType.IntType
            }
        )) { backStackEntry ->
            val postId = backStackEntry.arguments?.getInt(ConstVal.DETAIL_ARG_POST_ID)
            requireNotNull(postId) {"postId parameter not found"}
            DetailPage(postId =postId)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidListJCTheme {
        Greeting("Android")
    }
}