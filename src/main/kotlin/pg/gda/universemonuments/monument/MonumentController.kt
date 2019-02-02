package pg.gda.universemonuments.monument

import jdk.nashorn.internal.ir.annotations.Ignore
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import pg.gda.universemonuments.config.security.JsonWebToken
import pg.gda.universemonuments.monument.model.entity.Monument
import pg.gda.universemonuments.monument.model.request.MonumentCreateRequest
import pg.gda.universemonuments.monument.repository.MonumentRepository
import pg.gda.universemonuments.user.repository.UserRepository

@RestController
@RequestMapping("/monuments")
class MonumentController(
        private val monumentRepository: MonumentRepository,
        private val userRepository: UserRepository) {

    @GetMapping("/all")
    fun getAllMonuments(): ResponseEntity<List<Monument>> {
        val monuments = monumentRepository.findAll().toList()
        return ResponseEntity(monuments, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getMonument(@PathVariable("id") id: Long): ResponseEntity<Monument> {
        val monument = monumentRepository.findById(id)
        if (monument.isPresent.not()) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Monument not found")
        }
        return ResponseEntity(monument.get(), HttpStatus.OK)
    }

    @PostMapping("/add")
    fun addMonument(@RequestBody monumentCreateRequest: MonumentCreateRequest,
                    @AuthenticationPrincipal token: JsonWebToken): ResponseEntity<Monument> {
        val user = userRepository.findUserByLogin(token.userLogin)
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")

        val monumentToSave = Monument.from(monumentCreateRequest, user)
        val savedMonument = monumentRepository.save(monumentToSave)

        return ResponseEntity(savedMonument, HttpStatus.CREATED)
    }

    @PutMapping("/update")
    fun updateMonument(): ResponseEntity<Any> {
        return ResponseEntity("Endpoint is not implemented yet", HttpStatus.NOT_IMPLEMENTED)
    }
}