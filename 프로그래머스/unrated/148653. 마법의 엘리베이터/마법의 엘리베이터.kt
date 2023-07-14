import kotlin.math.*

class Solution {
    fun solution(storey: Int): Int {
        var answer: Int = 0
        var num = storey
        var start = 10
        while ( num != 0) {
            var div = num % start
            if ( div < 5) {
                answer += div
                num -= div
            } else {
                if ( div == 5 ) {
                    if ( (num / 10) % start < 5) {
                        answer += div
                        num -= div
                    } else {
                        answer += (10-div)
                        num += (10-div)       
                    }
                } else {
                    answer += (10-div)
                    num += (10-div)   
                }
            }
            num /= 10
        }
        return answer
    }
}