package pg.gda.universemonuments.user.model.response

import pg.gda.universemonuments.user.model.entity.User

data class UserLoggedInResponse(
        val login: String,
        val name: String,
        val surname: String,
        val token: String,
        val isSuperUser: Boolean
) {

    companion object {
        fun from(user: User, token: String): UserLoggedInResponse {
            val (_, login, _, name, surname, userType) = user
            val isSuperUser = userType == "ADMIN"
            return UserLoggedInResponse(login, name, surname, token, isSuperUser)
        }
    }
}

enum class UserTypeResponse {
    USER, ADMIN, INVALID;

    companion object {
        infix fun from(userType: String): UserTypeResponse {
            return when (userType) {
                "ADMIN" -> ADMIN
                "USER" -> USER
                else -> INVALID
            }
        }
    }
}