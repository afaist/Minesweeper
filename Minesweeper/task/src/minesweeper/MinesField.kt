package minesweeper

const val SAFE_CELL = '.'
const val MINE = 'X'
const val USER_MARK = '*'
const val FREE_CELL = '/'

class MinesField(_height: Int, _width: Int, _mines: Int) {
    private val height = _height
    private val width = _width
    private val totalCells = height * width
    private val totalMines = _mines
    private val mines = mutableListOf<Pair<Int, Int>>()

    private val fieldReference = Array(height) { CharArray(width) }
    private val field = Array(height) { CharArray(width) }
    private val fieldShow = Array(height) { CharArray(width) { SAFE_CELL } }

    init {
        val fieldChar = CharArray(totalCells) { SAFE_CELL }
        val cells = MutableList(totalCells) { n -> n }
        for (i in 0 until totalMines) {
            val point = cells.random()
            cells.remove(point)
            mines.add(Pair(point / height, point % width))
        }
        (0 until height).forEach { i ->
            val start = i * width
            val end = i * width + width - 1
            field[i] = fieldChar.sliceArray(start..end)
        }
    }

    /**
     * the user made a move
     *
     * @param x
     * @param y
     * @return  how many moves are left to make
     */
    fun userStep(x: Int, y: Int, isMine: Boolean): Int {
        val i = y - 1
        val j = x - 1
        val point = Pair(i, j)
        if (isMine) {
            if (point in mines) {
                mines.remove(point)
            }
            if (field[i][j] == USER_MARK) {
                if (fieldReference[i][j] == MINE) {
                    mines.add(point)
                }
                field[i][j] = fieldReference[i][j]
                fieldShow[i][j] = SAFE_CELL
            } else {
                field[i][j] = USER_MARK
                fieldShow[i][j] = field[i][j]
            }
            return mines.size
        }
        if (point in mines) {
            println("You stepped on a mine and failed!")
            for (mine in mines) {
                fieldShow[mine.first][mine.second] = MINE
            }
            return -1
        } else if (field[i][j] == SAFE_CELL) {
            floodFill(point)
        }
        fieldShow[i][j] = field[i][j]
        return mines.size
    }

    /**
     * Flood fill field with FREE
     *
     * @param point - start
     */
    private fun floodFill(point: Pair<Int, Int>) {
        val (y, x) = point
        if (field[y][x] == USER_MARK) {
            field[y][x] = fieldReference[y][x]
        }
        if (field[y][x] != SAFE_CELL) {

            fieldShow[y][x] = field[y][x]
            return
        }
        field[y][x] = FREE_CELL
        fieldShow[y][x] = FREE_CELL
        if (y > 0) {
            floodFill(Pair(y - 1, x))
            if (x > 0) {
                floodFill(Pair(y - 1, x - 1))
            }
            if (x < WIDTH - 1) {
                floodFill(Pair(y - 1, x + 1))
            }
        }
        if (y < HEIGHT - 1) {
            floodFill(Pair(y + 1, x))
            if (x > 0) {
                floodFill(Pair(y + 1, x - 1))
            }
            if (x < WIDTH - 1) {
                floodFill(Pair(y + 1, x + 1))
            }
        }
        if (x > 0) {
            floodFill(Pair(y, x - 1))
        }
        if (x < WIDTH - 1) {
            floodFill(Pair(y, x + 1))
        }
        return
    }


    /**
     * Calculate how many mines there are around each empty cell
     *
     */
    fun fillMinesAround() {
        for ((j, i) in mines) {
            field[j][i] = MINE
        }
        for ((j, i) in mines) {
            val cells = mutableListOf<Pair<Int, Int>>()
            if (i > 0) {
                if (j > 0) {
                    cells.add(Pair(j - 1, i - 1))
                }
                if (j < height - 1) {
                    cells.add(Pair(j + 1, i - 1))
                }
                cells.add(Pair(j, i - 1))
            }
            if (i < width - 1) {
                if (j > 0) {
                    cells.add(Pair(j - 1, i + 1))
                }
                if (j < height - 1) {
                    cells.add(Pair(j + 1, i + 1))
                }
                cells.add(Pair(j, i + 1))
            }
            if (j > 0) {
                cells.add(Pair(j - 1, i))
            }
            if (j < height - 1) {
                cells.add(Pair(j + 1, i))
            }
            for (cell in cells) {
                var value = 1
                val (x, y) = cell
                val prev = field[x][y]
                if (prev != MINE) {
                    if (prev.isDigit()) {
                        value += prev.digitToInt()
                    }
                    field[x][y] = value.toString().first()
                }
            }
        }
        for (i in field.indices) {
            fieldReference[i] = field[i].copyOf()
        }
    }

    /**
     * printing the state of the playing field
     *
     */
    fun printField(isUser: Boolean = true) {
        val showField = if (isUser) {
            fieldShow
        } else {
            field
        }

        println("\n │123456789│\n—│—————————│")
        for ((i, row) in showField.withIndex()) {
            print("${i + 1}|")
            print(row.joinToString(""))
            println("|")
        }
        println("—│—————————│")
    }
}