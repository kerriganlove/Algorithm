class Solution {
    var tf1 = listOf(true,true,true,true,true,true,true,true,false,false,false,false,false,false,false,false)
    var tf2 = listOf(true,true,true,false,true,false,false,false,true,true,true,true,false,false,false,false)
    var tf3 = listOf(true,true,false,true,false,true,false,false,true,true,false,false,true,true,false,false)
    var tf4 = listOf(true,false,true,true,false,false,true,false,true,false,true,false,true,false,true,false)
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var infoList = mutableMapOf<String, MutableList<Int>>()
        for ( i in info ) {
            var list = i.split(" ")
            for ( j in 0..15) {
                var result = StringBuilder()
                var cond1 = if (tf1[j]) list[0] else "-"
                var cond2 = if (tf2[j]) list[1] else "-"
                var cond3 = if (tf3[j]) list[2] else "-"
                var cond4 = if (tf4[j]) list[3] else "-"
                var str = result.append(cond1).append(cond2).append(cond3).append(cond4).toString()
                if ( infoList[str] == null ) {
                    infoList[str] = mutableListOf<Int>(list[4].toInt())
                } else {
                    var replaceList = infoList[str]!!
                    replaceList.add(list[4].toInt())
                    infoList.replace(str, replaceList)
                }
            }
        }
        infoList.values.forEach {
            it.sort()
        }
        var answerList = mutableListOf<Int>()
        for ( i in query ) {
            var list = i.replace(" and ","").split(" ")
            var str = list[0]
            var num = list[1].toInt()
            var strList = infoList.get(str)?: mutableListOf<Int>()
            answerList.add(strList.size - binarySearch(num, strList))
        }
        answer = answerList.toIntArray()
        return answer
    }
    
    fun binarySearch(find : Int, list : MutableList<Int>) : Int {
        var start = 0
        var end = list.size
        var mid = 0
        while ( start < end) {
            mid = (start + end) / 2
            if ( find <= list[mid]) {
                end = mid
            } else {
                start = mid + 1
            }
        }
        return start
    }
}