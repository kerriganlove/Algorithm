class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var x = s.get(0)
        var xCnt = 0
        var aCnt = 0
        for ( i in s) {
            if (xCnt == aCnt) {
                answer++
                xCnt = 0
                aCnt = 0
                x = i
            }
            if ( i == x) { xCnt++ }
            else { aCnt++ }
        }
        return answer
    }
}