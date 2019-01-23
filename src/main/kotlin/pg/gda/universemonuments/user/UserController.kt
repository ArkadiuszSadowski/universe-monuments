package pg.gda.universemonuments.user

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pg.gda.universemonuments.config.security.JWTProvider
import pg.gda.universemonuments.user.model.entity.User
import pg.gda.universemonuments.user.model.request.UserLogInRequest
import pg.gda.universemonuments.user.model.request.UserRegisterRequest
import pg.gda.universemonuments.user.model.response.UserLoggedInResponse
import pg.gda.universemonuments.user.repository.UserRepository

@RestController
@RequestMapping("/user")
class UserController(
        private val userRepository: UserRepository,
        private val jwtProvider: JWTProvider
) {

    @PutMapping("/register")
    fun register(@RequestBody userRegisterRequest: UserRegisterRequest): ResponseEntity<Any> {
        val user = userRepository.findUserByLogin(userRegisterRequest.login)

        return when (user) {
            null -> {
                val savedUser = userRepository.save(User.from(userRegisterRequest))
                val token = jwtProvider.issue(savedUser)
                ResponseEntity(UserLoggedInResponse.from(savedUser, token), HttpStatus.CREATED)
            }
            else -> {
                ResponseEntity("User with given login already exist", HttpStatus.NOT_ACCEPTABLE)
            }
        }
    }

    @GetMapping("/log-in")
    fun logIn(@RequestBody userLogInRequest: UserLogInRequest): ResponseEntity<Any> {
        val userFromDb = userRepository.findUserByLogin(userLogInRequest.login)
                ?: return ResponseEntity("User do not exist", HttpStatus.NOT_FOUND)

        return if (userLogInRequest.password == userFromDb.password) {
            val token = jwtProvider.issue(userFromDb)
            ResponseEntity(UserLoggedInResponse.from(userFromDb, token), HttpStatus.OK)
        } else {
            return ResponseEntity("Incorrect password", HttpStatus.NOT_ACCEPTABLE)
        }
    }
}