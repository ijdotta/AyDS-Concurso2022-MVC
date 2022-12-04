package main

import controller.ControllerInjector
import view.ViewInjector

fun main() {
    initGraph()
    ViewInjector.view.openView()
}

fun initGraph() {
    ControllerInjector.init()
}

