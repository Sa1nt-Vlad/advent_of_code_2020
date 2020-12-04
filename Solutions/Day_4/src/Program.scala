import java.nio.file.Paths

import PassportParser.PassportParser
import PassportValidator.PassportValidator

object Program extends App {
	val parser = new PassportParser()
	val passports = parser.parseFromFile(Paths.get("src", "input.txt").toString)
	
	val validator = new PassportValidator()
	val validPassports = passports.count(passport => validator.isValid(passport))
	println(s"Count of valid passports: $validPassports")
}
