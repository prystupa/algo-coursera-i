import scala.collection.mutable.ArrayBuffer

object Algorithm {

  def inversions(a: Array[Int]): Int = {
    def sortAndCount(aa: Array[Int]): (Array[Int], Int) = {
      if (aa.length < 2) {
        (aa, 0)
      }
      else {
        val mid = aa.length / 2
        val (b, c) = aa.splitAt(mid)
        val (bb, bn) = sortAndCount(b)
        val (cc, cn) = sortAndCount(c)
        val (dd, dn) = merge(bb, cc)
        (dd, bn + cn + dn)
      }
    }

    def merge(b: Array[Int], c: Array[Int]): (Array[Int], Int) = {
      var i = 0
      var j = 0
      var n = 0
      val k = new ArrayBuffer[Int]

      while (k.length < b.length + c.length) {
        if (i >= b.length) {
          k ++= c.slice(j, c.length)
          j = c.length
        } else if (j >= c.length) {
          k ++= b.slice(i, b.length)
          i = b.length
        } else if (b(i) <= c(j)) {
          k += b(i)
          i = i + 1
        } else {
          k += c(j)
          j = j + 1
          n = n + b.length - i
        }
      }

      (k.toArray, n)
    }

    sortAndCount(a)._2
  }
}
