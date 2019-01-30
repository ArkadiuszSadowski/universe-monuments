package pg.gda.universemonuments.monument

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pg.gda.universemonuments.monument.model.entity.Monument
import pg.gda.universemonuments.monument.model.request.MonumentCreateRequest
import pg.gda.universemonuments.monument.repository.MonumentRepository

@RestController
@RequestMapping("/monuments")
class MonumentController(private val monumentRepository: MonumentRepository) {

    @GetMapping()
    fun getAllMonuments(): ResponseEntity<List<Monument>> {
        val monuments = monumentRepository.findAll().toList()
        return ResponseEntity(monuments, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getMonument(@PathVariable("id") id: Long): ResponseEntity<Any> {
        val monument = monumentRepository.findById(id)
        if (monument.isPresent.not()) {
            return ResponseEntity("Monument not found", HttpStatus.NOT_FOUND)
        }
        return ResponseEntity(monument, HttpStatus.OK)
    }

    @PostMapping()
    fun addMonument(@RequestBody monumentCreateRequest: MonumentCreateRequest): ResponseEntity<Any> {
        val monumentToSave = Monument.from(monumentCreateRequest)
        val savedMonument = monumentRepository.save(monumentToSave)

        return ResponseEntity(savedMonument, HttpStatus.CREATED)
    }

    @PutMapping()
    fun updateMonument(@RequestBody string: String): ResponseEntity<Any> {
        return ResponseEntity("Endpoint is not implemented yet", HttpStatus.NOT_IMPLEMENTED)
    }

}