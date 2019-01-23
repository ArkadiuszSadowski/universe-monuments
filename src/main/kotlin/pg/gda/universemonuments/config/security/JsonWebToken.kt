package pg.gda.universemonuments.config.security

data class JsonWebToken(
        val userType: Type,
        val userId: Long,
        val userLogin: String
) {
    companion object {
        val invalid
            get() = JsonWebToken(Type.INVALID, -1, "")
    }

    enum class Type {
        INVALID,
        USER
    }

    fun isValid(): Boolean {
        return userType != Type.INVALID
    }
}