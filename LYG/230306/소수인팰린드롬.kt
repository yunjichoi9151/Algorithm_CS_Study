import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt



fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    BufferedWriter(OutputStreamWriter(System.`out`)).use { w ->
        val (a, b) = readLine().split(' ').map { it.toInt() }

        val arr = BooleanArray(b + 1) { false }
        for (i in 2 until sqrt(b.toDouble()).toInt() + 1) {
            if (!arr[i]) {
                for (j in i * 2..b step i) arr[j] = true
            }
        }

        for (i in a..b) {
            if (!arr[i] && check(i)) {
               w.write("$i\n")
            }
        }
        w.write("-1\n")
        w.flush()

    }
    this.close()
}

fun check(i: Int): Boolean {
    val str = i.toString()
    for (j in 0 until str.length/2) {
        if (str[j]!=str[str.length-1-j]) return false
    }
    return true
}