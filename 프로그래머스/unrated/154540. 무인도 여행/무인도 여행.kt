class Solution {
    var num : Int = 0
    var dx = intArrayOf(-1,1,0,0)
    var dy = intArrayOf(0,0,-1,1)
    var x : Int = 0
    var y : Int = 0
    var map = mutableListOf(mutableListOf(""))
    fun solution(maps: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        x = maps[0].length
        y = maps.size
        map = maps.map {
            it.toCharArray().map { it.toString() }
        }.map {
            it.toMutableList()
        }.toMutableList()
        for ( i in 0 until y ) {
            for ( j in 0 until x) {
                if ( dfs(i,j) ) {
                    answer += num
                    num = 0
                }
            }   
        }
        if ( answer.size == 0) { answer += -1 } 
        else { 
            answer.sort()
        }
        return answer
    }
    
    fun dfs(s : Int, e : Int) : Boolean {
        if (map[s][e] != "X") {
            var sum = map[s][e].toInt() 
            map[s][e] = "X"
            for ( i in 0 until 4) {
                var ny = s + dy[i]
                var nx = e + dx[i]
                if ( 0 <= ny && ny < y && 0 <= nx && nx < x) {
                    dfs(ny,nx)
                }
            }
            num += sum
            return true                
        }
        return false
    }
}