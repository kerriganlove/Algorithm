class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        var answer: Int = 0
        data.sortWith(compareBy({it[col-1]}, {-it[0]}))
        var tupleSize = data[0].size
        val Slist = mutableListOf<Int>()
        for ( i in row_begin-1 until row_end ) {
            var sum = 0
            for ( j in 0 until tupleSize) {
                sum+= (data[i][j]) % (i+1)
            }
            Slist.add(sum)
        }
       answer = Slist[0]
        for ( i in 1 until Slist.size) {
            answer = answer xor Slist[i] 
        }
        return answer
    }
}