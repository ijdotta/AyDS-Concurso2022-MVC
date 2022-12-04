package controller

import common.observer.Observer
import model.Model
import view.UiEvent
import view.View

interface Controller

internal class ControllerImpl(
    private val view: View,
    private val model: Model
) : Controller {

    private val observer: Observer<UiEvent> =
        Observer { value ->
            when (value) {
                UiEvent.AddItem -> addItem()
                UiEvent.CheckItem -> checkItem()
            }
        }

    init {
        view.uiEventObservable.subscribe(observer)
    }

    private fun addItem() {
        model.addItem(view.uiState.newItemDescription)
    }

    private fun checkItem() {
        TODO("Not yet implemented")
    }

}
