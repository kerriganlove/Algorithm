import java.util.*

class Solution {
    var closeList = listOf(")", "]","}")
    fun solution(s: String): Int {
        var answer: Int = 0
        var deque = ArrayDeque<String>()
        s.map {
            it.toString()
        }.forEach {
            deque.add(it)
        }
        answer += isCorrect(deque.clone())
        for ( i in 1 until s.length) {
            deque.add(deque.removeFirst())
            answer += isCorrect(deque.clone())
        }
        return answer
    }
    
    fun isCorrect(deque : ArrayDeque<String>) : Int {
        var stack = mutableListOf<String>()
        while (!deque.isEmpty()) {
            var part = deque.removeFirst()
            if (closeList.contains(part)) {
                when(part) {
                    ")" -> {
                        if (!stack.isEmpty() && stack.last() == "(") { stack.removeLast()} else return 0
                    }
                    "]" -> {
                        if (!stack.isEmpty() && stack.last() == "[") { stack.removeLast()} else return 0
                    }
                    "}" -> {
                        if (!stack.isEmpty() && stack.last() == "{") { stack.removeLast()} else return 0  
                    }
                }
            } else {
                 stack.add(part)   
            }
        }
        if ( !stack.isEmpty() ) { return 0 }
        return 1
    }
}