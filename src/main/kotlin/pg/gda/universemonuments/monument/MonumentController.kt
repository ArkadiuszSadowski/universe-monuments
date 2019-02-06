package pg.gda.universemonuments.monument

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import pg.gda.universemonuments.config.security.JsonWebToken
import pg.gda.universemonuments.monument.model.entity.Monument
import pg.gda.universemonuments.monument.model.request.MonumentCreateRequest
import pg.gda.universemonuments.monument.model.response.MonumentResponse
import pg.gda.universemonuments.monument.repository.MonumentRepository
import pg.gda.universemonuments.user.repository.UserRepository

@RestController
@CrossOrigin
@RequestMapping("/monuments")
class MonumentController(
        private val monumentRepository: MonumentRepository,
        private val userRepository: UserRepository) {

    @GetMapping("/all")
    fun getAllMonuments(): ResponseEntity<List<MonumentResponse>> {
        val monuments = monumentRepository.findAll()
                .toList()
                .map { MonumentResponse from it }

        return ResponseEntity(monuments, HttpStatus.OK)
    }

    @GetMapping()
    fun getAllMonumentsByApprove(@RequestParam("approved") approved: Boolean): ResponseEntity<List<MonumentResponse>> {
        val monuments = monumentRepository.findMonumentsByApproved(approved).map { MonumentResponse from it }
        return ResponseEntity(monuments, HttpStatus.OK)
    }

    @GetMapping("/{userId}/user")
    fun getUserMonuments(@PathVariable("userId") userId: Long): ResponseEntity<List<Monument>> {
        val monuments = monumentRepository.findMonumentsByAuthorId(userId)
        return ResponseEntity(monuments, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getMonument(@PathVariable("id") id: Long): ResponseEntity<MonumentResponse> {
        val monument = monumentRepository.findById(id)
        if (monument.isPresent.not()) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Monument not found")
        }

        return ResponseEntity(MonumentResponse from monument.get(), HttpStatus.OK)
    }

    @PostMapping("/add")
    fun addMonument(@RequestBody monumentCreateRequest: MonumentCreateRequest,
                    @AuthenticationPrincipal token: JsonWebToken): ResponseEntity<MonumentResponse> {
        val user = userRepository.findUserByLogin(token.userLogin)
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")

        val monumentToSave = Monument.from(monumentCreateRequest, user)
        val savedMonument = monumentRepository.save(monumentToSave)

        return ResponseEntity(MonumentResponse.from(savedMonument), HttpStatus.CREATED)
    }

    @PutMapping("/approve/{monumentId}/monument")
    fun markMonumentAsApproved(@PathVariable("monumentId") monumentId: Long): ResponseEntity<MonumentResponse> {
        val monument = monumentRepository.findById(monumentId)
        if (monument.isPresent.not()) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Monument not found")
        }
        val monumentToUpdate = monument.get()
        monumentToUpdate.approved = true

        val updatedMonument = monumentRepository.save(monumentToUpdate)
        return ResponseEntity(MonumentResponse.from(updatedMonument), HttpStatus.OK)
    }
}