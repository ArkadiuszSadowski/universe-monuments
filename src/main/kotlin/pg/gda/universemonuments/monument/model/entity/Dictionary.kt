package pg.gda.universemonuments.monument.model.entity

import javax.persistence.*

@Entity
@Table(name = "UM_Dictionary")
data class Dictionary(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictionary_gen")
        @SequenceGenerator(name = "dictionary_gen", sequenceName = "dictionary_seq")
        @Column(name = "dictionary_id")
        val id: Long?,

        @Column(name = "type")
        val type: String,

        @Column(name = "kind")
        val kind: String,

        @Column(name = "description")
        val description: String?

) {

    companion object {
        infix fun fromStatus(status: String): Dictionary {
            return Dictionary(null, "STATUS PRAWNY", status, "")
        }

        infix fun fromType(type: String): Dictionary {
            return Dictionary(null, "RODZAJ", type, "")
        }

    }
}
