import java.util.*

class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf()
        var que = LinkedList<Range>()
        var s = 0
        var e = 0
        var sum = sequence[0]
        while ( s <= e ) {
            if ( sum > k ) {
                sum -= sequence[s++]
            } else {
                if ( sum == k ) { que.add(Range(s,e)) }
                if ( e == sequence.size - 1) {
                    break
                }
                sum += sequence[++e]
            }
        }
        que.sortBy {
            it.end - it.start
        }
        var range = que.pop()
        answer += intArrayOf(range.start, range.end)
        return answer
    }
}

data class Range(
    var start : Int,
    var end : Int
)