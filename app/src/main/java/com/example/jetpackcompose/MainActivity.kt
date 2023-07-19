package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import coil.compose.AsyncImage
import com.shehatah.domain.models.Category
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MealsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            viewModel.getMeals()
        }
        setContent {


            var categories by remember {
                mutableStateOf(viewModel.categories.value)
            }
            val coroutineScope = rememberCoroutineScope()
            LaunchedEffect(key1 = "myKey") {
                coroutineScope.launch {
                    viewModel.categories.collect {
                        categories = it
                    }
                }
            }

            if (categories == null) {

                CircularProgressIndicator()

            } else
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    content = {

                        itemsIndexed(categories!!.categories) { _, category ->
                            CategoryItem(category = category)
                        }
                    },
                )

        }
    }
}

@Composable
fun CategoryItem(category: Category) {
    Row(Modifier.fillMaxWidth()) {

        AsyncImage(
            model = category.strCategoryThumb,
            contentDescription = null,
        )
        Column {
            Text(text = category.strCategory)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = category.strCategoryDescription)
        }

    }
}

