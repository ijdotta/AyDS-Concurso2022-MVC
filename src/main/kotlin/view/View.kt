package view

import common.observer.Observable
import common.observer.Subject
import model.ModelInjector.model
import model.entities.SimpsonsQuote

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
            fetchQuoteButton.addActionListener { notifyFetchQuoteAction() }
        }
    }

    private fun initObservers() {
        model.simpsonsQuoteObservable.subscribe { quote -> updateQuote(quote)}
    }

    private fun updateQuote(quote: SimpsonsQuote) {
        updateUiState(quote)
        updateUiComponents(quote)
    }

    private fun updateUiState(quote: SimpsonsQuote) {
        uiState = uiState.copy(quote = quote.quote, character = quote.character)
    }

    private fun updateUiComponents(quote: SimpsonsQuote) {
        with(uiComponents) {
            quoteTextArea.text = uiState.quote
            quoteCharacterField.text = uiState.character
        }
    }

    private fun notifyFetchQuoteAction() {
        onActionSubject.notify(UiEvent.FetchQuote)
    }
}