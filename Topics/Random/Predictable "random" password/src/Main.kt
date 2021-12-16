import kotlin.random.Random

const val LENGTH = 10
const val START = 33
const val END = 127
fun generatePredictablePassword(seed: Int) = Random(seed).run {
    CharArray(LENGTH) { nextInt(START, END).toChar() }.joinToString("")
}