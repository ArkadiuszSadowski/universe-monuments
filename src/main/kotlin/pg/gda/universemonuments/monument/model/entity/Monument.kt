package pg.gda.universemonuments.monument.model.entity

import org.springframework.format.annotation.DateTimeFormat
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
        val function: String,

        @Column(name = "creation_date")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        val creationDate: Date,

        @Column(name = "archival_source")
        val archivalSource: String?,

        @Column(name = "approved")
        var approved: Boolean,

        @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
        @JoinColumn(name = "coordinates_id", nullable = false)
        val coordinates: Coordinates,

        @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
        @JoinColumn(name = "address_id", nullable = false)
        val address: Address,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "author_id")
        val author: User,

        @OneToOne
        @JoinColumn(name = "legal_status")
        val status: Dictionary?,

        @OneToOne
        @JoinColumn(name = "monument_kind")
        val type: Dictionary?
) {
    companion object {
        fun from(monumentCreateRequest: MonumentCreateRequest, author: User): Monument {
            val (name, function, creationDate, archivalSource,
                    coordinatesCreateRequest, addressCreateRequest,
                    status, type) = monumentCreateRequest

            return Monument(
                    id = null,
                    name = name,
                    function = function,
                    creationDate = creationDate,
                    archivalSource = archivalSource,
                    approved = false,
                    coordinates = Coordinates.from(coordinatesCreateRequest),
                    address = Address.from(addressCreateRequest),
                    author = author,
                    status = Dictionary.fromStatus(status),
                    type = Dictionary.fromType(type))
        }
    }
}