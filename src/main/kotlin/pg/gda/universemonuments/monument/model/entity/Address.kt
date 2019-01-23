package pg.gda.universemonuments.monument.model.entity

import pg.gda.universemonuments.monument.model.request.AddressCreateRequest
import javax.persistence.*

@Entity
@Table(name = "um_address")
data class Address(

        @Id
        @Column(name = "address_id", nullable = false, unique = true, updatable = false)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_gen")
        @SequenceGenerator(name = "address_gen", sequenceName = "address_seq")
        val id: Long?,

        @Column(name = "street")
        val street: String,

        @Column(name = "house_number")
        val houseNumber: String,

        @Column(name = "flat_number")
        val flatNumber: String?,

        @Column(name = "post_code")
        val postCode: String,

        @Column(name = "city")
        val city: String,

        @Column(name = "country")
        val country: String
) {
    companion object {
        fun from(addressCreateRequest: AddressCreateRequest): Address {
            val (street, houseNumber, flatNumber, postCode,
                    city, country) = addressCreateRequest

            return Address(
                    id = null,
                    street = street,
                    houseNumber = houseNumber,
                    flatNumber = flatNumber,
                    postCode = postCode,
                    city = city,
                    country = country)
        }
    }
}