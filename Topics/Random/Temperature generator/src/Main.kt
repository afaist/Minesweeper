import kotlin.random.Random

const val DAYS = 7
const val MIN = 20
const val MAX = 31
fun generateTemperature(seed: Int) = Random(seed).run {
    IntArray(DAYS) { nextInt(MIN, MAX) }.joinToString(" ")
}