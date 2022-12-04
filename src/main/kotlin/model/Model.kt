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
        simpsonsService.getQuote()?.let {
            simpsonsQuoteObservable.notify(it)
        }
    }
}