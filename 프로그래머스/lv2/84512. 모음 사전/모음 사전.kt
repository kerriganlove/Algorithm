class Solution {
    var list = mutableListOf<String>()
    var aeiou = listOf("A","E","I","O","U")
    fun solution(word: String): Int {
        var answer = 0
        self("",0);
        answer = list.indexOf(word)
        return answer
    }
    fun self(word : String, len : Int) {
        list.add(word)
        if (len == 5) return
        for ( i in aeiou) {
            self(word+i, len+1)
        }
    }
}