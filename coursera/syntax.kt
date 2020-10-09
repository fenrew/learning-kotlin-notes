// TYPES: String, Int, Unit, Array, Char (?), enum class,

// VARIABLES
val name: String = "Markus"
println("Hello world, $name")
// val => read-only
// var => mutable variable

// DATA STRUCTURES


// FUNCTIONS
fun callFunc () {
    println("yooo")
}

fun main (args: Array<String> = ["defaultValue"]): Int{
    val name = if (args.size > 0) args[0] else "Kotlin"
    println("hallaa, ${callFunc()}")
    return 5
}

fun max(a: Int, b: Int) = if (a > b) a else b

// DATA STRUCTURES
var list = listOf("Java", "Kotlin")


// ARRAYS
var list = listOf("Java", "Kotlin")
list.add("Javascript")

// you can only add new elements to a val list if it is mutableListOf
// .push
val list = mutableListOf("Java")
list.add("Kotlin")

//.join .joinToString
println(listOf('a', 'b', 'c').joinToString(
    separator = "", prefix = "(", postfix = ")"))
// prints (abc)

// CONDITIONS

// switch case
when(color) {
    BLUE -> println("cold")
    ORANGE -> println("mild")
    else -> println("hot")
}

when(pet) {
    is Cat -> pet.meow() // 'is' checks if it's the instance of => is pet instance of Cat
    is Dog -> pet.woof()
}

when(val pet = "hey"){
    "hey" -> println("YEEET")
}

val (description, color) = when {
    degrees < 5 -> "cold" to BLUE
    degrees < 23 -> "mild" to ORANGE
    else -> "hot" to RED
}

// LOOPS
do {
    // ...
} while(condition)

// is letter capitalized. '!in' also works 
fun isLetter(c: Char) = c in 'a'..'z' || 'A'..'Z'

if(element in list)

for(s in list){ // val list = listOf("a", "b")
    print(s)
}

val map = mapOf(
    1 to "one"
    2 to "two"
    3 to "three"
)
for((key, value) in map) {
    println("$key = $value")
}

for((index, element) in list.withIndex()) {
    println("$index = $element")
}

for(i in 1..9) {
    print(i) // prints 1-9
}

for(i in 1 until 9) {
    print(i) // prints 1-8
}

for(i in 9 downTo 1 step 2) {
    print(i) // prints 97531
}

for(ch in "abc") {
    print(ch + 1) // prints bcd
}

// RANGES
1..9
1 until 10
"a".."z"
"ab".."az"
startDate..endDate

// EXCEPTIONS
throw IllegalArgumentException(
    "my string in here"
)

val number = try {
    Interger.parseInt(string)
} catch (e: NumberFormatException){
    null
    // or 'return' if i want that instead
}

// METHODS

// .reapeat
repeat(5){
    println("MARKUS")
}
// prints MARKUS five times

// .localeCompare
myString.compareTo(yourString)

// .includes
list.contains(element)

// .lastChar
fun String.lastChar() = this.get(this.length - 1)
