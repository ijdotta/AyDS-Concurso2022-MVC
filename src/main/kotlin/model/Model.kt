package model

import common.observer.*;
import model.entities.ListItem
import model.entities.SimpsonsQuote
import model.external.SimpsonsService

interface Model {

    val itemObservable : Observable<ListItem>
    val simpsonsQuoteObservable : Observable<SimpsonsQuote>
    fun addItem(description: String)
    fun checkItem(id: Int)
    fun fetchQuote()
}

class ModelImpl(private val simpsonsService: SimpsonsService) : Model {

    override val itemObservable = Subject<ListItem>()
    override val simpsonsQuoteObservable = Subject<SimpsonsQuote>()

    private var lastId = 0
    private val items = arrayListOf<ListItem>()

    override fun fetchQuote() {
        simpsonsService.getQuote()?.let {
            simpsonsQuoteObservable.notify(it)
        }
    }

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