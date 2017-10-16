/**
  * Created by Viliam on 17.10.2017.
  */
class Point(private var _x: Int = 0, private var _y: Int = 0) {
    def x: Int = {
        _x
    }
    def x_= (newValue: Int): Unit = {
        println("Setter for X")
        _x = newValue
    }

    def y: Int = {
        _y
    }
    def y_= (newValue: Int): Unit = {
        println("Setter for Y")
        _y = newValue
    }

    def move(dx: Int, dy: Int): Unit = {
        _x = _x + dx
        _y = _y + dy
    }

    override def toString: String =
        s"($x, $y)"
}

object ConstructorAndClasses extends App {
    val points = List(
        new Point,
        new Point(1),
        new Point(_y = 2)
    )
    points.foreach(println)
    points.head.x = 20

    var i_can_change_this = 2
    val i_can_not_change_this = 2

    i_can_change_this += 1
//    i_can_not_change_this += 1
}