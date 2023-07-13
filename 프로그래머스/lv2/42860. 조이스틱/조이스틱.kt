

class Solution {
    fun solution(name: String): Int {
        var answer = 0
        var list = name.toList().map {
           if ((it.toInt() - 65) > 13) { 26 - (it.toInt() - 65)} else { it.toInt() - 65}
        }
        answer = list.sum()
        var move = list.size - 1
        if ( list.contains(0) ) {
            for ( i in list.indices ) {
                var next = i + 1
                while ( next < list.size && list[next] == 0 ) {
                    next++
                }
                var a = listOf(move, (2*i) + list.size - next, i + 2 * (list.size - next))
                move = a.minOf{ it }
            }
        }
        answer += move
        return answer
    }
}