import kotlin.math.*

class Solution {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0
        var d1 = r1.toDouble().pow(2)
        var d2 = r2.toDouble().pow(2)
        
        for ( i in 1..r2) {
            var powI = i.toDouble().pow(2)
            var v1 = ceil(sqrt(d1-powI)).toLong()
            var v2 = floor(sqrt(d2-powI)).toLong()
            var count = v2 - v1 + 1  
            answer += count
        }
        
        return answer*4L
    }
}