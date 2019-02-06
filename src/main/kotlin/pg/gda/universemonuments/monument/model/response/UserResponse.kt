package pg.gda.universemonuments.monument.model.response

import pg.gda.universemonuments.user.model.entity.User


data class UserResponse(
        val login: String,
        val name: String,
        val surname: String
) {
    companion object {
        infix fun from(user: User): UserResponse {
            val (_, login, _, name, surname) = user
            return UserResponse(login, name, surname)
        }
    }
}
