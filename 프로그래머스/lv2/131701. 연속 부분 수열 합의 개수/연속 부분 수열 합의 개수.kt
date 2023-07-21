class Solution {
    fun solution(elements: IntArray): Int {
        var prefix = mutableListOf<Int>()
        var list = elements + elements
        prefix.add(list[0])
        for ( i in 1..list.size-1) {
            var num = prefix[i-1] + list[i]
            prefix.add(num)
        }
        var answerList = mutableSetOf<Int>()
        for ( i in elements.indices) {
            for ( j in i+1 until i+elements.size) {
                answerList.add(prefix[j] - prefix[i])
            }
        }
        var answer : Int = 0
        answer = answerList.size + 1
        return answer
    }
}