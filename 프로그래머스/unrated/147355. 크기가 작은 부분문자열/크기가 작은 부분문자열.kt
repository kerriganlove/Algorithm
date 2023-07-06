class Solution {
    fun solution(t: String, p: String): Int {
        var answer: Int = 0
        var pLen = p.length
        var tLen = t.length
        var pInt = p.toLong()
        for ( i in t.indices) {
            if ( i+pLen > tLen) {
                break
            }
            var tInt = t.substring(i, i+pLen).toLong()
            if ( tInt <= pInt ) {
                answer++
            }
        }
        return answer
    }
}