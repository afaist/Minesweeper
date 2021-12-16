fun main() {
    val n = readLine()!!.toInt()
    val incomes = IntArray(n) { readLine()!!.toInt() }
    val percents = IntArray(n) { readLine()!!.toInt() }
    var maxIndex = 0
    var max = 0
    (0 until n).forEach { i ->
        val newValue = incomes[i] * percents[i]
        if (newValue > max) {
            max = newValue
            maxIndex = i
        }
    }
    println(maxIndex + 1)
}