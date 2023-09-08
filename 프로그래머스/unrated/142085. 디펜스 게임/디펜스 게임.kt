import java.util.*

class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var answer: Int = 0
        var sum = 0
        var count = k
        var pQue = PriorityQueue<Int>()
        for ( (index,i) in enemy.withIndex() ) {
            pQue.add(i)
            if ( pQue.size > k) {
                sum += pQue.poll()
            }
            if ( sum > n ) {
                return index
            }
        }
        answer = enemy.size
        return answer
    }
}