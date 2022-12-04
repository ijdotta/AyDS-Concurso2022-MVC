package view

import common.observer.Observable
import common.observer.Subject
import model.ModelInjector.model
import model.entities.ListItem

interface View {
    val uiEventObservable : Observable<UiEvent>
    val uiState : UiState

    fun openView()
}

class ViewImpl(private val uiComponents: UiComponents) : View {
    private val onActionSubject = Subject<UiEvent>()
    override val uiEventObservable = onActionSubject
    override var uiState: UiState = UiState()
    override fun openView() {
        uiComponents.openWindow()
    }

    init {
        initListeners()
        initObservers()
    }

    private fun initListeners() {
        with(uiComponents) {
            addItemButton.addActionListener { addItemAction() }
        }
    }

    private fun initObservers() {
        model.itemObservable.subscribe { value -> updateItemsList(value) }
    }

    private fun updateItemsList(item: ListItem) {

    }

    private fun addItemAction() {
        updateItemDescriptionState()
        notifyAddItemAction()
    }

    private fun updateItemDescriptionState() {
        uiComponents.itemDescriptionField.let {
            uiState = uiState.copy(newItemDescription = it.text)
            it.text = ""
        }

    }

    private fun notifyAddItemAction() {
        onActionSubject.notify(UiEvent.AddItem)
    }
}