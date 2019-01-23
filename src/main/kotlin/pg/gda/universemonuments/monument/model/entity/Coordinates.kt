package pg.gda.universemonuments.monument.model.entity

import pg.gda.universemonuments.monument.model.request.CoordinatesCreateRequest
import javax.persistence.*

@Entity
@Table(name = "um_coordinates")
data class Coordinates(

        @Id
        @Column(name = "coordinates_id", nullable = false, unique = true, updatable = false)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coordinates_gen")
        @SequenceGenerator(name = "coordinates_gen", sequenceName = "coordinates_seq")
        val id: Long?,

        @Column(name = "longitude")
        val longitude: Double,

        @Column(name = "latitude")
        val latitude: Double
) {
    companion object {
        fun from(coordinatesRequest: CoordinatesCreateRequest): Coordinates {
            val (longitude, latitude) = coordinatesRequest

            return Coordinates(
                    id = null,
                    longitude = longitude,
                    latitude = latitude)
        }
    }
}
