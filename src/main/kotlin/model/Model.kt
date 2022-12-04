package model

import common.observer.*;
import model.entities.ListItem

interface Model {

    val itemObservable : Observable<ListItem>
    fun addItem(description: String)
    fun checkItem(id: Int)
}

class ModelImpl : Model {

    override val itemObservable = Subject<ListItem>()

    private var lastId = 0
    private val items = arrayListOf<ListItem>()

    override fun addItem(description: String) {
        ListItem(++lastId, description, false).let {
            items.add(it)
            itemObservable.notify(it)
        }
    }

    override fun checkItem(id: Int) {
        items
            .filter { it.id == id }
            .forEach {
                it.checked = true
                itemObservable.notify(it)
            }
    }

}