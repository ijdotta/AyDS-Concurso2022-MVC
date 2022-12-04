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

    // TODO add UiEvent observer and model interaction

    init {
        // TODO suscribe observer
    }

}
