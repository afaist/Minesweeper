fun main() {
    val lst = MutableList(readLine()!!.toInt()) { readLine()!!.toInt() }
    val (P, M) = readLine()!!.split(" ").map { it.toInt() }
    println(if (P in lst && M in lst) "YES" else "NO")
}