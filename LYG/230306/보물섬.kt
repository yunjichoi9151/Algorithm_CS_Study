import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

var N = 0
var M = 0
lateinit var map: Array<CharArray>
lateinit var visited: Array<IntArray>
val dr = arrayOf(-1, 1, 0, 0)
val dc = arrayOf(0, 0, -1, 1)
var ans = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readln())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    map = Array(N) { CharArray(M) { '0' } }
    visited = Array(N) { IntArray(M) { 0 } }
    for (i in 0 until N) {
        map[i] = readLine().toCharArray()
    }
    var cnt = 1
    for (i in 0 until N)
        for (j in 0 until M) {
            if (map[i][j] == 'L') bfs(i, j, cnt++)
        }
    println(ans)
}

fun bfs(i: Int, j: Int, idx: Int) {
    val q: Queue<IntArray> = LinkedList()
    q.add(intArrayOf(i, j, 0))

    visited[i][j] = idx
    while (!q.isEmpty()) {
        val arr = q.poll()
        val r = arr[0]
        val c = arr[1]
        val dis = arr[2]
        ans = ans.coerceAtLeast(dis)
        for (d in 0 until 4) {
            val nr = r + dr[d]
            val nc = c + dc[d]
            if (nr in 0 until N && nc in 0 until M && map[nr][nc] == 'L' && visited[nr][nc] != idx) {
                visited[nr][nc] = idx
                q.add(intArrayOf(nr, nc, dis + 1))
            }
        }

    }

}