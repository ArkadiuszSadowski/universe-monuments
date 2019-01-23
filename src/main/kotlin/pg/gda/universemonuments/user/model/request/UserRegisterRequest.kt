package pg.gda.universemonuments.user.model.request

data class UserRegisterRequest(
        val login: String,
        val password: String,
        val name: String,
        val surname: String)