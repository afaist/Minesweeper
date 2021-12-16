class Point3D {
    var x: Int = 0
    var y: Int = 0
    var z: Int = 0
}

fun createPoint(x: Int, y: Int, z: Int): Point3D {
    val point3D = Point3D()
    point3D.x = x
    point3D.y = y
    point3D.z = z
    return point3D
}