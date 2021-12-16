const val THIRTEEN = 13L
const val REPEAT = 9
fun main() {
    var thirteen = THIRTEEN
    repeat(REPEAT) { thirteen *= THIRTEEN; println(thirteen) }
}