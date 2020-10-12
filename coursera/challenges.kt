// Is Valid Identifier

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

// Sum as an extension
fun Array<Int>.sum() = {
    var sum = 0
    for(i in this){
        sum += i
    }
    this.get(sum)
}

fun main(args: Array<String>) {
    val sum = listOf(1, 2, 3).sum()
    println(sum)    // 6
}


// ---------------MASTERMIND---------------------
package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPos = 0
    var wrongPos = 0
    val guessedIndex = mutableListOf<Int>()

    for((index, ch) in secret.withIndex()){
        if(guess[index] == ch) {
            rightPos++
            if(guessedIndex.contains(index)){
                wrongPos--
            }
            guessedIndex.add(index)
        } else {
            for((i, chGuess) in guess.withIndex()){
                if(ch == chGuess && !guessedIndex.contains(i)){
                    wrongPos++
                    guessedIndex.add(i)
                    break
                }
            }
        }
    }

    return Evaluation(rightPos, wrongPos)
}

// Functional solution to Mastermind
fun evaluateGuess(secret: String, guess: String): Evaluation {

    val rightPositions = secret.zip(guess).count { it.first == it.second }

    val commonLetters = "ABCDEF".sumBy { ch ->

        Math.min(secret.count { it == ch }, guess.count { it == ch })
    }
    return Evaluation(rightPositions, commonLetters - rightPositions)
}