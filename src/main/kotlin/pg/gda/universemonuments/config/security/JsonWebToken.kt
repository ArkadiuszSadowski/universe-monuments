package pg.gda.universemonuments.config.security

data class JsonWebToken(
        val userType: Type,
        val userId: Int,
        val userLogin: String
) {
    companion object {
        val invalid
            get() = JsonWebToken(Type.INVALID, -1, "")
    }

    enum class Type {
        INVALID,
        USER,
        ADMIN
    }

    fun isValid(): Boolean {
        return userType != Type.INVALID
    }
}