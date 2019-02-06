package pg.gda.universemonuments.user

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import pg.gda.universemonuments.config.security.JWTProvider
import pg.gda.universemonuments.user.model.entity.User
import pg.gda.universemonuments.user.model.request.UserLogInRequest
import pg.gda.universemonuments.user.model.request.UserRegisterRequest
import pg.gda.universemonuments.user.model.response.UserLoggedInResponse
import pg.gda.universemonuments.user.repository.UserRepository

@RestController
@CrossOrigin
@RequestMapping("/user")
class UserController(
        private val userRepository: UserRepository,
        private val jwtProvider: JWTProvider
) {

    @PostMapping("/register")
    fun register(@RequestBody userRegisterRequest: UserRegisterRequest): ResponseEntity<UserLoggedInResponse> {
        val user = userRepository.findUserByLogin(userRegisterRequest.login)

        when (user) {
            null -> {
                val savedUser = userRepository.save(User.from(userRegisterRequest))
                val token = jwtProvider.issue(savedUser)
                return ResponseEntity(UserLoggedInResponse.from(savedUser, token), HttpStatus.CREATED)
            }
            else -> {
                throw ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User with given login already exist")
            }
        }
    }

    @PostMapping("/log-in")
    fun logIn(@RequestBody userLogInRequest: UserLogInRequest): ResponseEntity<UserLoggedInResponse> {
        val userFromDb = userRepository.findUserByLogin(userLogInRequest.login)
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User do not exist")

        if (userLogInRequest.password == userFromDb.password) {
            val token = jwtProvider.issue(userFromDb)
            return ResponseEntity(UserLoggedInResponse.from(userFromDb, token), HttpStatus.OK)
        } else {
            throw ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Incorrect password")
        }
    }
}