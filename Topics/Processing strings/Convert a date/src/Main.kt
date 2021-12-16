fun main() =
    println(readLine()!!.split("-").run {
        "${this[1]}/${this.last()}/${this.first()}"
    })