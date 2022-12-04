package model

import model.external.SimpsonsModule

object ModelInjector {
    val model = ModelImpl(SimpsonsModule.simpsonsService)
}