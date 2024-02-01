package tech.noir.billsapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BillsAppApplication

fun main(args: Array<String>) {
	runApplication<BillsAppApplication>(*args)
}
