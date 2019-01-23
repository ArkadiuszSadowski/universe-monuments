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
            ResponseEntity("Monument not found", HttpStatus.NOT_FOUND)
        }
        return ResponseEntity(monument, HttpStatus.OK)
    }

    @PutMapping("/add")
    fun addMonument(@RequestBody monumentCreateRequest: MonumentCreateRequest): ResponseEntity<Any> {
        val monumentToSave = Monument.from(monumentCreateRequest)
        val savedMonument = monumentRepository.save(monumentToSave)

        return ResponseEntity(savedMonument, HttpStatus.CREATED)
    }

    @PostMapping("/update")
    fun updateMonument(): ResponseEntity<Any> {
        return ResponseEntity("Endpoint is not implemented yet", HttpStatus.NOT_IMPLEMENTED)
    }

}