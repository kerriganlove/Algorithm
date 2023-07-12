import java.util.*

class Solution {
    fun solution(number: String, k: Int): String {
        var answer = ""
        var list = number.map {
            it.toString().toInt()
        }
        var count = k
        var stack = Stack<Int>()
        for ( i in list) {
            if ( count <= 0) {
                stack.add(i)
                continue
            }
           while (!stack.isEmpty()) {
               if ( count == 0) {
                   break
               }
                if ( stack.peek() < i) {
                    stack.pop()
                    count--
                } else break
            }
            stack.add(i)
        }
        var str = stack.toList().joinToString("")
        answer = str.slice(0..(str.length - count)-1)
        return answer
    }
}