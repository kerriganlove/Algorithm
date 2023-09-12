class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var map = HashMap<String, Int>()
        for ( i in keymap) {
            i.forEachIndexed { idx, key ->
                map.merge(key.toString(), idx+1, Integer::min)
            }
        }
        for (i in targets) {
            var ans = 0
            var missing = false
            i.forEach { value ->
                map.get(value.toString())?.apply {
                    ans += this
                }?:run { missing = true }
            }
            if ( missing ) { ans = -1 }
            answer += ans
        }
        return answer
    }
}