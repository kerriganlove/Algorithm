import java.util.*

class Solution {
    fun solution(targets: Array<IntArray>): Int {
        var answer: Int = 0
        targets.sortBy { it[1] }
        var e = 0
        for ( arr in targets ) {
            if ( arr[0] < e) {
                continue
            }
            e = arr[1]
            answer++
        }
        
        return answer
    }
}