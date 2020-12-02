import java.nio.file.Paths
import PolicyChecker.{FrequencyChecker, PositionChecker}
import PolicyParser.PolicyParser
import TextReader.TextReader

object Program extends App {
	val textReader = new TextReader()
	val lines = textReader.readAllLines(Paths.get("src", "input.txt").toString)
	
	val policyParser = new PolicyParser()
	var correctPosPswdCount = 0
	var correctFreqPswdCount = 0
	for (line <- lines)
	{
		val policy = policyParser.getPolicy(line)
		val password = line.split(Array(' ', ':')).filter(part => part.length > 0)(2)
		val frequencyCheck = new FrequencyChecker().checkPolicy(policy, password)
		val positionCheck = new PositionChecker().checkPolicy(policy, password)
		if (frequencyCheck)
			correctFreqPswdCount += 1
		if (positionCheck)
			correctPosPswdCount += 1
	}
	
	println("Correctness passwords according frequency policy: " + correctFreqPswdCount)
	println("Correctness passwords according position policy: " + correctPosPswdCount)
}
