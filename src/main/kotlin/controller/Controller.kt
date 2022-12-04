package controller

import common.observer.Observer
import model.Model
import view.UiEvent
import view.View

interface Controller

internal class ControllerImpl(
    view: View,
    private val model: Model
) : Controller {

    private val observer: Observer<UiEvent> =
        Observer { value ->
            when (value) {
                UiEvent.FetchQuote -> randomQuote()
            }
        }

    init {
        view.uiEventObservable.subscribe(observer)
    }

    private fun randomQuote() {
        model.fetchQuote()
    }
}
