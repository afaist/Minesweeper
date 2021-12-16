fun main() {
    var distance = readLine()!!.toInt() // the distance back
    var totalDistance = readLine()!!.toInt()
    if (distance < 0) {
        distance = -distance
    }
    totalDistance += distance
    println(totalDistance)
}