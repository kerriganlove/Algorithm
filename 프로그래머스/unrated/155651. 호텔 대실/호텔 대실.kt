class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        var answer: Int = 0
        var isBreak = false
        var table = book_time.map { time ->
            time.map { it.getFromTimeStamp() }
        }.sortedBy { it[0] }
        var answerList = mutableListOf<Int>()
        table.forEach { tables ->
            isBreak = false
            for ( i in answerList) {
                if ( i + 10 <= tables[0]) {
                    answerList.set(answerList.indexOf(i), tables[1])
                    isBreak = true
                    break
                }
            }
            if (!isBreak) answerList.add(tables[1])
        }
        answer = answerList.size
        return answer
    }
}

fun String.getFromTimeStamp() : Int {
    var arr = this.split(":")
    return (arr[0].toInt() * 60) + arr[1].toInt()
}