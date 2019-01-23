package pg.gda.universemonuments.monument.model.entity

import pg.gda.universemonuments.monument.model.request.MonumentCreateRequest
import java.sql.Date
import javax.persistence.*


@Entity
@Table(name = "um_monument")
data class Monument(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "monument_gen")
        @SequenceGenerator(name = "monument_gen", sequenceName = "monument_seq")
        @Column(name = "monument_id")
        val id: Long?,

        @Column(name = "name")
        val name: String,

        @Column(name = "function")
        val function: String,

        @Column(name = "creation_date")
        val creationDate: Date,

        @Column(name = "archival_source")
        val archivalSource: String?,

        @Column(name = "approved")
        val approved: Boolean,

        @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
        @JoinColumn(name = "coordinates_id", nullable = false)
        val coordinates: Coordinates,

        @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
        @JoinColumn(name = "address_id", nullable = false)
        val address: Address

) {
    companion object {
        fun from(monumentCreateRequest: MonumentCreateRequest): Monument {
            val (name, function, creationDate, archivalSource,
                    coordinatesCreateRequest, addressCreateRequest) = monumentCreateRequest

            return Monument(
                    id = null,
                    name = name,
                    function = function,
                    creationDate = creationDate,
                    archivalSource = archivalSource,
                    approved = false,
                    coordinates = Coordinates.from(coordinatesCreateRequest),
                    address = Address.from(addressCreateRequest))
        }
    }
}