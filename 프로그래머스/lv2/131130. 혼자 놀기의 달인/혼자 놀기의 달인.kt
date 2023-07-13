import java.util.*

class Solution {
    fun solution(cards: IntArray): Int {
        var answer: Int = 0
        var map = HashMap<Int, Int>()
        var answerList = mutableListOf<Int>()
        for (i in cards.indices) {
            map.put(i+1, cards[i])
        }
        while(map.isNotEmpty()) {
            var first = map.toList()[0].first
            var stack = Stack<Int>()
            while ( map.get(first) != null) {
                stack.add(map.remove(first))
                if ( map.isEmpty() ) { break }
                first = stack.peek()
            }
            answerList.add(stack.size)
        }
        answerList.sortDescending()
        if ( answerList.size == 1) {
            answer = 0
        } else {
            answer = answerList[0]*answerList[1]
        }
        return answer
    }
}