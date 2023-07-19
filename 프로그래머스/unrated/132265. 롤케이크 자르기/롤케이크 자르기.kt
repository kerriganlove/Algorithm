class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        var curSet = mutableSetOf<Int>()
        var dpFirst = IntArray(1000000)
        var dpLast = IntArray(1000000)
        var list = topping.reversed()
        for ( (index, i) in topping.withIndex() ) {
            curSet.add(i)
            dpFirst[index] = curSet.size
        }
        curSet = mutableSetOf<Int>()
        for ( (index, i) in list.withIndex()) {
            curSet.add(i)
            dpLast[index] = curSet.size
        }
        var size = topping.size - 2
        for ( i in 0..size) {
            var min = size - i
            var max = size - min
            if ( dpFirst[min] == dpLast[max]) {
                answer++
            }
        }
        
        return answer
    }
}