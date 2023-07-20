class Solution {
    fun solution(s: String): IntArray {
        var zeroCount = 0
        var numCount = 0
        var num = s
        while (num != "1") {
            var elim = num.filter { it != '0' }
            var convert = num.length - elim.length
            zeroCount += convert
            numCount++
            num = Integer.toBinaryString(elim.length)
        }
        var answer: IntArray = intArrayOf(numCount, zeroCount)
        return answer
    }
}