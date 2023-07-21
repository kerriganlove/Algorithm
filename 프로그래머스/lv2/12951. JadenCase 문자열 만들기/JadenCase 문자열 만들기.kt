class Solution {
    fun solution(s: String): String {
        var list = s.split(" ").map { str ->
            str.lowercase().replaceFirstChar {
                it.uppercase()
            }
        }
        var answer = list.joinToString(separator = " ")
        return answer
    }
}