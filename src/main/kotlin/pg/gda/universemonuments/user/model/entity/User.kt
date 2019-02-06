package pg.gda.universemonuments.user.model.entity

import pg.gda.universemonuments.user.model.request.UserRegisterRequest
import javax.persistence.*

@Entity
@Table(name = "um_user")
data class User(
        @Id
        @Column(name = "user_id", nullable = false, unique = true, updatable = false)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
        @SequenceGenerator(name = "user_gen", sequenceName = "user_seq")
        val id: Long?,

        @Column(name = "login")
        val login: String,

        @Column(name = "password")
        val password: String,

        @Column(name = "name")
        val name: String,

        @Column(name = "surname")
        val surname: String,

        @Column(name = "usertype")
        val userType: String
) {
    companion object {
        fun from(userRegisterRequest: UserRegisterRequest): User {
            val (login, password, name, surname) = userRegisterRequest
            return User(
                    id = null,
                    login = login,
                    password = password,
                    name = name,
                    surname = surname,
                    userType = "USER"
            )
        }

    }
}