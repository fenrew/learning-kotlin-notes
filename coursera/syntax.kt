// TYPES: String, Int, Unit, Array, Char (?), enum class, List, Set

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

list["Java"] // if not there, returns null ??
list.getValue("Java") // if not there, returns NoSuchElementsException ??

// Create empty array
var list = listOf<String>()

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

// METHODS / Extensions
// .length .size
Array.length // Works??
Array.size
String.length

// parseInt .toInt .toDouble .toIntOrNull
"123".toInt() // 123
"1e-10".toDouble() // 1.0E-10
"xx".toInt() // NumberFormatException
"xx".toIntOrNull() // null

// equal .eq
fun getAnswer() = 42
getAnswer() eq 42 // prints: OK
getAnswer() eq 43 // prints: Error: 42 != 43

// .reapeat
repeat(5){
    println("MARKUS")
}
// prints MARKUS five times

// .localeCompare
myString.compareTo(yourString)

// .includes .contains (use .any instead!)
list.contains(element)
"abba".contains("ab") // true
// .contains will be removed soon

// .lastChar
fun String.lastChar() = this.get(this.length - 1)
val c: Char = "abc".lastChar()

// .getOrNull
val list = listOf("Markus")
print(list.getOrNull(0), list.getOrNull(1)) // "Markus", null
// gets the index if it exists or null if it doesnt

// .isLetter() 
"a".isLetter() // true

// .isDigit()
3.isDigit() // true

// .isLetterOrDigit
"%".isLetterOrDigit() // false

// .count
// Returns the number of elements matching the given predicate
listOf("Markus", "Fenrew", 3).count() :Int // Returns the count of ints in the list (i think...)
secret.zip(guess).count { it.first == it.second }

// .instanceOf
if(any is String){
    any.toUpperCase()
}

// .isEmpty
String.isEmpty()
Array.isEmpty()

// .filter
employees.filter() { it.city == City.OSLO }.map { it.age }.average()

// .map
// .flatMap
// .flatten   JS version: .flat()
// .forEach
// .find
// .reduce
// .any
list.any() { it == 2 }
// checks if ANY of the elements is equal to 2, if yes  returns true else false

// .all
list.all() { it == 2 }
// checks if ALL of the elements is equal to 2, if yes  returns true else false

// .none
list.none() { it == 2 }
// checks if NONE of the elements is equal to 2, if yes  returns true else false

// .first .firstOrNull
list.first() {it == 2}
// gets the first element that is equal to 2

// .partition
list.partition { it == 2 }
// devides the list into two lists, one that only has 2's, and one that dont
val (young, old) = listOf(4, 7, 1, 10, 5, 15).partition() { it < 10 }
// young will be any number below 10, and old will be any number >= 10

// .groupBy
list.groupBy { it.age }
// devides the list into several lists depending if they are the same age or not

// .associate
listOf(1, 2).associate() { 'a' + it to 10 * it} // returns (a, 10), (b, 20)   not sure if object, list or whateves..

// .zip
listOf("A", "B").zip("Markus", "Fenrew") // Returns [(A, Markus), (B, Fenrew)]
// Length is equal to the shortest array

// .zipWithNext
listOf("A", "B").zipWithNext() // returns [(A, B)]

// .distinct
listOf("A", "B", "A").distinct() // returns [A, B]
// returns a lis tof distinct elements

// .maxBy
listOf(3, 4, 8).maxBy() // returns 8
// returns tha highest

// .getOrElse
listOf("Markus", "Fenrew").getOrElse("Klorida") { 0 } // returns Klorida if it is in the list, or else 0

// .windowed
"abba".windowed(2)
// returns an array with slices of 2 ("ab", "bb", "ba")


// REGEX
// .match
val regex = "\\d{2}\\.\\d{2}\\.\\d{4}".toRegex() 
val regex = """\d{2}\.\d{2}\.\d{4}""" //or it can be written like this
regex.matches("15.02.1992") // true
regex.matches("15.02.92") // false

// CLASS
data class Evaluation(val rightPosition: Int, val wrongPosition: Int)