fun main() = readLine()!!.run {
    println(readLine()!!.toRegex().findAll(this).count())
}