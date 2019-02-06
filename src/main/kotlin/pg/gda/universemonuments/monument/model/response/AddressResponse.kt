package pg.gda.universemonuments.monument.model.response

import pg.gda.universemonuments.monument.model.entity.Address

data class AddressResponse(
        val street: String,
        val houseNumber: String?,
        val flatNumber: String?,
        val postCode: String,
        val city: String,
        val country: String
) {
    companion object {
        infix fun from(address: Address): AddressResponse {
            val (_, street, houseNumber, flatNumber,
                    postCode, city, country) = address

            return AddressResponse(
                    street = street,
                    houseNumber = houseNumber,
                    flatNumber = flatNumber,
                    postCode = postCode,
                    city = city,
                    country = country
            )
        }
    }
}