class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer: IntArray = intArrayOf()
        for ( i in left..right ) {
            var div = (i / n) + 1
            var mod = (i % n) + 1
            if ( div >= mod ) {
                answer += div.toInt()
            } else {
                answer += (div + (mod - div)).toInt()
            }
        }
        return answer
    }
}