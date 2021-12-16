fun main() =
    println(MutableList(readLine()!!.toInt()) { readLine()!!.toInt() }.run { this.indexOf(this.maxOrNull()) })
