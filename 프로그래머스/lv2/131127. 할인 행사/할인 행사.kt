class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        var map = HashMap<String, Int>()
        var firstDiscount = HashMap<String, Int>()
        var start = 0
        var end = 9
        for ( i in 0 until want.size ) {
            map.put(want[i], number[i])
        }
        for ( i in start..end) {
            firstDiscount.merge(discount[i], 1, Integer::sum)
        }
        for ( i in 0..discount.size - 10) {
            if (compareAB(map, firstDiscount, want)) answer++
            if ( end == discount.size - 1 ) break
            firstDiscount.merge(discount[start++], -1, Integer::sum)
            firstDiscount.merge(discount[++end], 1, Integer::sum)
        }
        return answer
    }
    
        
    fun compareAB(a : HashMap<String, Int>, b : HashMap<String, Int>, want : Array<String>) : Boolean {
        for ( i in want) {
            if (a.get(i)!!.compareTo(b.get(i)?:0) > 0) return false
        }
        return true
    }
}