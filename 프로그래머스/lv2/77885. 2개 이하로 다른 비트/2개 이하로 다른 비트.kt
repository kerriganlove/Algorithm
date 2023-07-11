import java.lang.*
import kotlin.math.*

class Solution {
    fun solution(numbers: LongArray): LongArray {
        var answer: LongArray = longArrayOf()
        for ( i in numbers ) {
            if ( i % 2L == 0L) {
                answer += i+1L
            } else {
                var a = java.lang.Long.toBinaryString(i)
                var l = a.lastIndexOf('0')
                if ( l == -1 ) { l = a.length }
                else {
                  l = a.length - l - 1   
                }
                var c = (2.0).pow(l-1)
                answer += i + c.toLong()
            }
        }
        return answer
    }
}