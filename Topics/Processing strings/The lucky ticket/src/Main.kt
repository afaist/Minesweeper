fun main() {
    val sumInTicket = readLine()!!.chunked(3).map { it.toCharArray().map { it.digitToInt() }.sum() }
    println(if (sumInTicket[0] == sumInTicket[1]) "Lucky" else "Regular")
}