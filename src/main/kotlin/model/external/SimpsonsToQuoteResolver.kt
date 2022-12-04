package model.external

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import model.entities.SimpsonsQuote

interface SimpsonsToQuoteResolver {
    fun getQuoteFromExternalData(serviceData: String?): SimpsonsQuote?
}

private const val QUOTE = "quote"
private const val CHARACTER = "character"

internal class JsonToQuoteResolver : SimpsonsToQuoteResolver {
    override fun getQuoteFromExternalData(serviceData: String?): SimpsonsQuote? =
        try {
            serviceData?.getFirstItem()?.let {
                SimpsonsQuote(it.getQuote(), it.getCharacter())
            }
        } catch (e: Exception) {
            null
        }

    private fun String?.getFirstItem(): JsonObject? {
        val jobj = Gson().fromJson(this, JsonArray::class.java)
        return jobj[0]?.asJsonObject
    }

    private fun JsonObject.getQuote() : String {
        return this.get(QUOTE)?.asString ?: ""
    }

    private fun JsonObject.getCharacter() : String {
        return this.get(CHARACTER)?.asString ?: ""
    }
}