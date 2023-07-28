class Solution {
    fun solution(s: String): String {
        var list = s.split(" ").map { it.toInt() }
        list = list.sorted()
        var answer = "${list[0]} ${list[list.size-1]}"
        return answer
    }
}