package model.external

import model.entities.SimpsonsQuote

interface SimpsonsService {
    fun getQuote() : SimpsonsQuote?
}

internal class SimpsonsServiceImpl(
    private val simpsonsAPI: SimpsonsAPI,
    private val simpsonsToQuoteResolver: SimpsonsToQuoteResolver
) : SimpsonsService {

    override fun getQuote(): SimpsonsQuote? {
        val callResponse = getQuoteFromService()
        return simpsonsToQuoteResolver.getQuoteFromExternalData(callResponse.body())
    }

    private fun getQuoteFromService() = simpsonsAPI.getRandomQuote().execute()

}