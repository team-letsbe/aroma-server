package esperer.appjam

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppjamApplication

fun main(args: Array<String>) {
	runApplication<AppjamApplication>(*args)
}
