fun isValidIdentifier(s: String): Boolean {
    for((index, ch) in s.withIndex()){
        if(!(ch in 'A'..'Z' || ch in 'a'..'z' || index !== 0 && ch in '0'..'9' || index == 0 && ch == '_')){
            return false
        }
    }
    
    return !s.isEmpty()
}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}