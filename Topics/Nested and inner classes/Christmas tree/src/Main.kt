class ChristmasTree(var color: String) {

    fun putTreeTopper(color: String) {
        val treeTopper = TreeTopper(color)
        treeTopper.sparkle()
    }

    inner class TreeTopper(private var color: String) {
        fun sparkle() {
            print("The sparkling $color tree topper looks stunning on the ")
            println("${this@ChristmasTree.color} Christmas tree!")
        }
    }
}