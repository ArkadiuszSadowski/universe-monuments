package pg.gda.universemonuments.user.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import pg.gda.universemonuments.user.model.entity.User

@Repository
interface UserRepository: CrudRepository<User, Long>{
    fun findUserByLogin(login: String): User?
    fun findAuthorByLogin(login: String): User?
}