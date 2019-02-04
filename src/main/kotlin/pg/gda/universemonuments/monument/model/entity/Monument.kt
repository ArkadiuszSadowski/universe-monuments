package pg.gda.universemonuments.monument.model.entity

import pg.gda.universemonuments.monument.model.request.MonumentCreateRequest
import pg.gda.universemonuments.user.model.entity.User
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
        var name: String,

        @Column(name = "function")
        var function: String,

        @Column(name = "creation_date")
        var creationDate: Date,

        @Column(name = "archival_source")
        var archivalSource: String?,

        @Column(name = "approved")
        var approved: Boolean,

        @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
        @JoinColumn(name = "coordinates_id", nullable = false)
        var coordinates: Coordinates,

        @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
        @JoinColumn(name = "address_id", nullable = false)
        var address: Address,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "author_id")
        var author: User

) {
    companion object {
        fun from(monumentCreateRequest: MonumentCreateRequest, author: User): Monument {
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
                    address = Address.from(addressCreateRequest),
                    author = author)
        }
    }
}