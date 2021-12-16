class Employee(val clothesSize: Int) {
    class Uniform {
        val uniformType = "suit"
        val uniformColor = "blue"
    }

    fun printUniformInfo() {
        println("The employee wears a ${Uniform().uniformColor} ${Uniform().uniformType} in size $clothesSize")
    }
}