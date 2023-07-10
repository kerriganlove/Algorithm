class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        score.sortDescending()
        var len = score.size
        var repeat = len / m
        for ( i in 1 until repeat+1) {
            var num = (i*m)-1
            answer += (score[num] * m)
        }
        return answer
    }
}