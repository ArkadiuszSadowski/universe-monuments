package pg.gda.universemonuments.monument.model.request

import java.sql.Date

data class MonumentCreateRequest(
        val name: String,
        val function: String,
        val creationDate: Date,
        val archivalSource: String?,
        val coordinates: CoordinatesCreateRequest,
        val address: AddressCreateRequest,
        val status: String,
        val type: String
)

data class CoordinatesCreateRequest(
        val longitude: Double,
        val latitude: Double
)

data class AddressCreateRequest(
        val street: String,
        val houseNumber: String?,
        val flatNumber: String?,
        val postCode: String,
        val city: String,
        val country: String
)

