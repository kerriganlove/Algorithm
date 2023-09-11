import kotlin.math.*

class Solution {
    fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()
        var startXY = intArrayOf(startX,startY)
        for ( i in balls ) {
            var min = Integer.MAX_VALUE
            var list = mutableListOf<IntArray>(intArrayOf(i[0],-i[1]),
                                        intArrayOf(i[0], n + (n-i[1])),
                                        intArrayOf(-i[0], i[1]),
                                        intArrayOf(m + (m-i[0]), i[1]))
            if ( i[0] == startXY[0] && i[1] < startXY[1]) {
                list.removeAt(0)
            }
            else if ( i[0] == startXY[0] && i[1] >  startXY[1]) {
                list.removeAt(1)
            }
            else if ( i[0] < startXY[0] && i[1] == startXY[1]) {
                list.removeAt(2)
            } else if ( i[0] > startXY[0] && i[1] == startXY[1] ) {
                list.removeAt(3)
            }
            for ( j in list) {
                min = min(min, getLength(startXY, j))
            }
            answer += min
        }
        return answer
    }
    
    fun getLength(a : IntArray, b : IntArray) : Int {
        var x = abs(a[0]-b[0]).toDouble()
        var y = abs(a[1]-b[1]).toDouble()
        return (x.pow(2) + y.pow(2)).toInt()
    }
}