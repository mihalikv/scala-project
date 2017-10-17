/**
  * Created by Viliam on 16.10.2017.
  */
object Hello extends App {
    println("Hello, World!")
}

object ValVar extends App {
    val x = 1 + 1
    // x = 3  This does not compile.
    val y: Int = 1 + 1

    var x2 = 1 + 1
    x2 = 3 // This compiles because "x" is declared with the "var" keyword.
    var x3: Int = 15
}

object FunctionAndMethods extends App {

    //    Functions
    (x: Int) => x + 1
    val addOne0 = (x: Int) => x + 1

    //    Methods
    def addOne1(x: Int): Int = x + 1

    def addOne2(x: Int): Int = {
        x + 1
    }

    println(addOne1(1))
    println(addOne1(1))
    println(addOne2(1))
}

class Decorator(left: String, right: String) {
    def layout[Int](x: Int): String = left + x.toString() + right
}

object HigherOrderFunc extends App {
    def apply(f: Int => String, v: Int): String = f(v)

    val decorator = new Decorator("[", "]")
    println(apply(decorator.layout, 7))
}

object IdFactory {
    private var counter = 0

    def create(): Int = {
        counter += 1
        counter
    }
}

object Traits extends App {

    trait Pet {
        val name: String

        def makeNoise(): String
    }

    class Dog(val name: String) extends Pet {
        override def makeNoise(): String = "Haw"
    }

    val dog1 = new Dog("Black")
    //    val pet = new Pet("Black")


    println(IdFactory.create())
    println(IdFactory.create())
    println(IdFactory.create())
}