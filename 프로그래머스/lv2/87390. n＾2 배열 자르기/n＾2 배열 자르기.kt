class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer: IntArray = intArrayOf()
        var list = mutableListOf<Int>()
        for ( i in left..right ) {
            var div = (i / n) + 1
            var mod = (i % n) + 1
            if ( div >= mod ) {
                list.add(div.toInt())
            } else {
                list.add(mod.toInt())
            }
        }
        answer = list.toIntArray()
        return answer
    }
}