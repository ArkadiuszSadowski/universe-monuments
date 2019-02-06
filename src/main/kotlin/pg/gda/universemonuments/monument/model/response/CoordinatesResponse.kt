package pg.gda.universemonuments.monument.model.response

import pg.gda.universemonuments.monument.model.entity.Coordinates

data class CoordinatesResponse(
        val longitude: Double,
        val latitude: Double
) {
    companion object {
        infix fun from(coordinates: Coordinates): CoordinatesResponse {
            val (_, longitude, latitude) = coordinates
            return CoordinatesResponse(longitude, latitude)
        }
    }
}