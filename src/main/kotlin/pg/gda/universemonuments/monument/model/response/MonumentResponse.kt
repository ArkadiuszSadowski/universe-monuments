package pg.gda.universemonuments.monument.model.response

import pg.gda.universemonuments.monument.model.entity.Monument
import java.sql.Date

data class MonumentResponse(
        var name: String,
        val function: String,
        val creationDate: Date,
        val archivalSource: String?,
        var approved: Boolean,
        val coordinates: CoordinatesResponse,
        val address: AddressResponse,
        val author: UserResponse,
        val status: String?,
        val type: String?
) {
    companion object {
        infix fun from(monument: Monument): MonumentResponse {
            val (_, name, function, creationDate,
                    archivalSource, approved, coordinates,
                    address, author, statusDictionary, typeDictionary) = monument

            return MonumentResponse(
                    name = name,
                    function = function,
                    creationDate = creationDate,
                    archivalSource = archivalSource,
                    approved = approved,
                    coordinates = CoordinatesResponse from coordinates,
                    address = AddressResponse from address,
                    author = UserResponse from author,
                    status = statusDictionary?.kind,
                    type = typeDictionary?.kind
            )

        }
    }
}