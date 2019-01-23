package pg.gda.universemonuments.user.model.response

import pg.gda.universemonuments.user.model.entity.User

data class UserLoggedInResponse(
        val login: String,
        val name: String,
        val surname: String,
        val token: String
) {
    companion object {
        fun from(user: User, token: String): UserLoggedInResponse {
            val (_, login, _, name, surname) = user
            return UserLoggedInResponse(login, name, surname, token)
        }
    }
}