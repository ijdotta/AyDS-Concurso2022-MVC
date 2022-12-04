package model.entities

data class ListItem(
    val id: Int,
    val description : String,
    var checked : Boolean
)