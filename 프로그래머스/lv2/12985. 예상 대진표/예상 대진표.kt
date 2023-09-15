import kotlin.math.*

class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var x = a
        var y = b
        while (abs(x - y).toInt() != 1 || (x/2 == y/2)) {
            if ( x % 2 == 1) {
                x = (x/2) + 1
            } else {
                x = x/2
            }
            if ( y % 2 == 1) {
                y = y/2 + 1
            } else {
                y = y/2
            }
            answer++
        }
        answer++

        return answer
    }
}