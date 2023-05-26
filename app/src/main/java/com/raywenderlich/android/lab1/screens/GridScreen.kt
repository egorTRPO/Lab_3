package com.raywenderlich.android.lab1.screens

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import kotlin.math.ceil

private val items = listOf(
    Icons.Filled.Check,
    Icons.Filled.Close,
    Icons.Filled.ThumbUp,
    Icons.Filled.Build,
    Icons.Filled.Delete,
    Icons.Filled.Home,
    Icons.Filled.Close,
    Icons.Filled.ThumbUp,
    Icons.Filled.Build,
    Icons.Filled.ThumbUp,
)

@Composable
fun GridScreen(){
    GridView(columnCount = 3)
}

@Composable
fun GridView(columnCount:Int) { val itemSize = items.size
    val rowCount = ceil(itemSize.toFloat() / columnCount).toInt()
    val gridItems = mutableListOf<List<IconResource>>()
    var position = 0

    for (i in 0 until rowCount) {
        val rowItem = mutableListOf<IconResource>()
        for (j in 0 until columnCount) {
            if (position.inc() <= itemSize) {
                rowItem.add(IconResource(items[position++], true))
            }
        }
        // here
        val itemsToFill = columnCount - rowItem.size

        for (j in 0 until itemsToFill) {
            rowItem.add(IconResource(Icons.Filled.Delete, false))
        }
        gridItems.add(rowItem)
    }
    // here
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(gridItems) { items ->
            RowItem(items)
        }
    }

}

@Composable
fun RowItem(rowItems: List<IconResource>) {

}

@Composable
fun RowScope.GridIcon(iconResource: IconResource){

}

data class IconResource(val imageVector: ImageVector, val isVisible: Boolean)