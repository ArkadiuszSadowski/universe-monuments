package pg.gda.universemonuments

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Profile
import org.springframework.web.bind.annotation.RequestMapping

@SpringBootApplication
@Profile("default")
@RequestMapping("/universemonuments/api")
class UniverseMonumentsApplication

fun main(args: Array<String>) {
    runApplication<UniverseMonumentsApplication>(*args)
}
