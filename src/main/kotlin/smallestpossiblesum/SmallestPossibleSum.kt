package smallestpossiblesum

fun solution(numbers: LongArray): Long {
    val mutableNumbers = numbers.toMutableList()

    val distinctNumbers = mutableNumbers.distinct().toMutableList()

    val numbersToCardinalityMap =
        distinctNumbers.associateWith { distinctNumber -> mutableNumbers.count { distinctNumber == it } }

    val reducedSubtractedNumbers = distinctNumbers.subtractWhileMinNotMax()

    val allSubtractedNumbers = mutableListOf<Long>()

    reducedSubtractedNumbers.forEachIndexed { index, reducedNumber ->
        val originalNumber = distinctNumbers[index]
        repeat(numbersToCardinalityMap[originalNumber]!!) { allSubtractedNumbers.add(reducedNumber) }
    }

    return allSubtractedNumbers.sum()
}

private fun MutableList<Long>.subtractWhileMinNotMax(): MutableList<Long> {

    val resultList = this.toMutableList()

    var max = resultList.maxOrNull()!!
    var min = resultList.minOrNull()!!

    while (max != min) {

        resultList.replaceAll { number ->
            if (number > min) {
                (number % min).takeIf { it > 0 } ?: min
            } else number
        }
        max = resultList.maxOrNull()!!
        min = resultList.minOrNull()!!
    }

    return resultList
}
