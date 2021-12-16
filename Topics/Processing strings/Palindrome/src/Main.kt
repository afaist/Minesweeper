fun main() {
    val str = readLine()!!
    println(
        if (str == str.reversed()) "yes" else "no"
    )
}