class Solution {
    fun solution(weights: IntArray): Long {
        var answer: Long = 0
        var distinct = weights.distinct()
        var same = mutableListOf<Long>()
        for ( i in distinct ) {
            var count = weights.count { it == i }.toLong()
            if ( count > 1L) {
                same.add(count)
            }
        }
        for ( i in same ) {
            answer += (i)*(i-1)/2L
        } // 여기가 같은 거리
        for ( i in distinct ) {
            val count = weights.count { it == i }.toLong()
            val one = weights.filter { it.toDouble() == (i * (3.0 / 2.0)).toDouble() }.count().toLong()
            val two = weights.filter { it.toDouble() == (i * 2.0).toDouble() }.count().toLong()
            val three = weights.filter { it.toDouble() == (i * (4.0 / 3.0)).toDouble() }.count().toLong()
            if ( one > 0L ) {
                answer+=(one*count).toLong()
            }
            if ( two > 0L) {
                answer+=(two*count).toLong()
            }
            if ( three > 0L) {
                answer+=(three*count).toLong()
            }
        }
        return answer
    }
}