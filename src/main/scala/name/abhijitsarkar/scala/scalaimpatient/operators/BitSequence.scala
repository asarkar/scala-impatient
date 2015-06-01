package name.abhijitsarkar.scala.scalaimpatient.operators

/**
 * Q7: Implement a class `BitSequence` that stores a sequence of 64 bits packed in a `Long` value. Supply `apply` and
 * `update` operators to get and set an individual bit.
 */
class BitSequence() {
  private var bits = 0L

  def apply(n: Byte): Boolean = {
    apply(n, mask(n))
  }

  private def apply(n: Byte, mask: Long): Boolean = {
    (mask & bits) == mask
  }

  def update(n: Byte, b: Boolean): Unit = {
    val m = mask(n)

    println(f"apply($n%d, $m%d) = ${apply(n, m)}%b, b = $b%b")

    if (apply(n, m) == b) return else bits = m ^ bits
  }

  def value = {
    bits
  }

  def mask(n: Byte) = {
    validateIndex(n)

    val mask: Long = if (n == 1) 1 else 2 << (n - 2)

    println(f"n = $n%d, mask = $mask%d, bits = $bits%d")

    mask
  }

  private def validateIndex(n: Byte) {
    if (n < 1 || n > 64) throw new IndexOutOfBoundsException("Index must be a value between 1 and 64.")
  }
}