package PassportValidator

import Passport.Passport

import scala.util.matching.Regex

class PassportValidator {
	val requiredFields = Set("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
	
	def isValid(passport: Passport): Boolean = {
		val fieldKeys = passport.fields
		  .filter(field => field._1 != "cid")
		  .toSet
		
		if ((requiredFields diff fieldKeys.map(field => field._1)).toSeq.nonEmpty) return false
		
		var validation = true
		for (field <- fieldKeys){
			field._1 match {
				case "byr" => validation = checkYearValidation(field._2, year => year >= 1920 && year <= 2002)
				case "iyr" => validation = checkYearValidation(field._2, year => year >= 2010 && year <= 2020)
				case "eyr" => validation = checkYearValidation(field._2, year => year >= 2020 && year <= 2030)
				case "hgt" => validation = checkHeightValidation(field._2)
				case "hcl" => validation = checkAccordingPattern(field._2, "#[\\da-f]{6}".r)
				case "ecl" => validation = checkAccordingPattern(field._2, "amb|blu|brn|gry|grn|hzl|oth".r)
				case "pid" => validation = checkAccordingPattern(field._2, "\\d{9}".r)
			}
			if (!validation) return validation
		}
		
		validation
	}
	
	private def checkYearValidation(param: String, func: Int => Boolean): Boolean = {
		val year = Integer.parseInt(param)
		func(year)
	}
	
	private def checkHeightValidation(height: String): Boolean = {
		 val pattern = "\\d+".r
		 val heightToParse = pattern.findFirstIn(height).get
		 
		if (height.contains("cm")){
			val temp = Integer.parseInt(heightToParse)
			return temp >= 150 && temp <= 193
		}
		
		val temp = Integer.parseInt(heightToParse)
		temp >= 59 && temp <= 76
	}
	
	private def checkAccordingPattern(param: String, pattern: Regex): Boolean = pattern.matches(param)
}
