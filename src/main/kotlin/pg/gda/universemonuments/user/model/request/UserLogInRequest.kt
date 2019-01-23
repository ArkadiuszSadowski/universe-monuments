package pg.gda.universemonuments.user.model.request

data class UserLogInRequest(
        val login: String,
        val password: String
)