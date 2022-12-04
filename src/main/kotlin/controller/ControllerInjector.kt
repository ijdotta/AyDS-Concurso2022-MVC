package controller

import view.ViewInjector.view
import model.ModelInjector.model

object ControllerInjector {
    fun init() {
        ControllerImpl(view, model)
    }
}