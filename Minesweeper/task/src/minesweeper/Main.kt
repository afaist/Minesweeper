package minesweeper

const val WIDTH = 9
const val HEIGHT = 9
fun main() {
    val totalCells = WIDTH * HEIGHT
    println("How many mines do you want on the field?")
    var totalMines = readLine()!!.toInt()
    if (totalMines > totalCells || totalMines < 1) {
        println("Incorrect number of mines for a field of $HEIGHT by $WIDTH cells")
        return
    }
    val minesField = MinesField(HEIGHT, WIDTH, totalMines)
    minesField.fillMinesAround()
    minesField.printField()
    while (totalMines > 0) {
        println("Set/unset mines marks or claim a cell as free:")
        try {
            val input = readLine()!!.split(" ")
            if (input.size != 3) {
                println("Invalid input!")
                continue
            }
            val isMine = input[2] == "mine"
            val (x, y) = input.slice(0..1).map { it.toInt() }
            if (x > WIDTH || y > HEIGHT) {
                println("Invalid input!!")
                continue
            }
            totalMines = minesField.userStep(x, y, isMine)
            minesField.printField()
            if (totalMines < 0){
                return
            }
        } catch (e: Exception) {
            println(e.message)
        }
    }
    println("Congratulations! You found all the mines!")
}