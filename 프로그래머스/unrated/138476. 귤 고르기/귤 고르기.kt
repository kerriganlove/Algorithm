class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        var map = mutableMapOf<Int, Int>()
        for ( i in tangerine) {
            if ( map.get(i) == null) {
                map.put(i,1)
            }
            else {
                map.replace(i, map[i]!!+1)
            }
        }
        val answerList = map.toList().sortedByDescending { it.second }
        var index = 0
        var count = k
        while ( count > 0) {
            count -= answerList[index++].second
            answer++
        }
        return answer
    }
}