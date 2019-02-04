package pg.gda.universemonuments.monument.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import pg.gda.universemonuments.monument.model.entity.Monument

@Repository
interface MonumentRepository : CrudRepository<Monument, Long>{
    fun findMonumentsByApproved(approved: Boolean): List<Monument>
    fun findMonumentsByAuthorId(authorId: Long): List<Monument>
}