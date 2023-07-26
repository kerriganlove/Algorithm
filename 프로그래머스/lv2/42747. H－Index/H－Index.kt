class Solution {
    fun solution(citations: IntArray): Int {
        var list = citations.sortedDescending()
        var answer = 0
        for ( i in 10000 downTo 0) {
            var max = citations.count { it >= i }
            var min = citations.count { it < i }
            if ( max >= i ) {
                answer = i
                break
            }
        }
        return answer
    }
}