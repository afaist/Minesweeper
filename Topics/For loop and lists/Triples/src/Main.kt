fun main() {
    val lst = MutableList(readLine()!!.toInt()) { readLine()!!.toInt() }
    var triples = 0
    for (i in 1 until lst.lastIndex) {
        if (lst[i - 1] + 1 == lst[i] && lst[i] + 1 == lst[i + 1]) triples++
    }
    println(triples)
}