fun main() {
    println(
        List(readLine()!!.toInt()) { readLine()!!.toInt() }
            .run { if (readLine()!!.toInt() in this) "YES" else "NO" }
    )
}