package pg.gda.universemonuments

import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
@ActiveProfiles("default")
class UniverseMonumentsApplicationTests {

	@Ignore
	@Test
	fun contextLoads() {
	}

	@Test
	fun checkJWTProvider(){
	}
}
