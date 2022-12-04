package view

sealed class UiEvent {
    object AddItem : UiEvent()
    object CheckItem : UiEvent()
}