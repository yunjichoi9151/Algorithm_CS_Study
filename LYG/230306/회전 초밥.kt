import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, d, k, c) = readln().split(' ').map { it.toInt() }
    val count = IntArray(d + 1)
    count[c] = 1
    var cnt = 1 // c 포함
    val arr = IntArray(N)
    for (i in 0 until N) {
        arr[i] = readLine().toInt()
        if (i < k) {
            count[arr[i]]++
            if (count[arr[i]] == 1) cnt++
        }
    }
    var ans = cnt
    for (i in k until N) {
        count[arr[i - k]]--
        if (count[arr[i - k]] == 0) cnt--
        count[arr[i]]++
        if (count[arr[i]] == 1) cnt++
        ans = max(ans, cnt)
    }
    for (i in 0 until k) {
        count[arr[N + i - k]]--
        if (count[arr[N + i - k]] == 0) cnt--
        count[arr[i]]++
        if (count[arr[i]] == 1) cnt++
        ans = max(ans, cnt)
    }
    println(ans)
}