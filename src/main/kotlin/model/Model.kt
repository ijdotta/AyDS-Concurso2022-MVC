package model

import common.observer.*
import model.entities.SimpsonsQuote
import model.external.SimpsonsService

interface Model {

    val simpsonsQuoteObservable : Observable<SimpsonsQuote>
    fun fetchQuote()
}

class ModelImpl(private val simpsonsService: SimpsonsService) : Model {

    override val simpsonsQuoteObservable = Subject<SimpsonsQuote>()

    override fun fetchQuote() {
        TODO("get quote and notify about model change")
    }
}