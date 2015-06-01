package name.abhijitsarkar.scala.scalaimpatient.operators

/**
 * Q8: Provide a class `Matrix`-you can choose whether you want to implement 2 x 2 matrices, square matrices of any size,
 * or ''m x n'' matrices. Supply operations `+` and `*`. The later should also work with scalars, for example `mat * 2`.
 * A single element should be accessible as `mat(row, col)`.
 * 
 * Ans: I chose to implement ''m x n'' matrix.
 */
class Matrix(val row: Int, val col: Int, val initial: Int = 0) {
  private val arr = if (initial != 0) Array.fill(row, col)(initial) else Array.ofDim[Int](row, col)

  def +(that: Matrix) = {
    validateAdditionCompatibility(that)

    def f(r: Int, c: Int) = {
      apply(r, c) + that(r, c)
    }

    val sum = new Matrix(row, col)

    updateWithIndices(sum, f)
  }

  def *(that: Matrix) = {
    validateMultiplicationCompatibility(that)
    
    def f(r: Int, c: Int) = {
      this.arr(r).view.zip(that.arr.collect { case a: Array[Int] => a(c) }).foldLeft(0) {
        (acc, pair) => { 
          println(f"r = $r%d, c = $c%d, acc = $acc%d, pair._1 = ${pair._1}%d, pair._2 = ${pair._2}%d")
          acc + pair._1 * pair._2 
        }
      }
    }

    val pdt = new Matrix(this.row, that.col)

    updateWithIndices(pdt, f)
  }

  def *(n: Int) = {
    val pdt = new Matrix(row, col, initial)

    def f(r: Int, c: Int) = {
      apply(r, c) * n
    }

    updateWithIndices(pdt, f)
  }

  private def updateWithIndices(m: Matrix, f: (Int, Int) => Int) = {
    m.arr.indices.foreach {
      r =>
        m.arr(r).indices.foreach {
          c => (m(r, c) = f.apply(r, c))
        }
    }

    m
  }

  private def validateMultiplicationCompatibility(that: Matrix) = {
    if (this.col != that.row) throw new IllegalArgumentException("Sizes are not multiplication compatible.")
  }

  private def validateAdditionCompatibility(that: Matrix) = {
    if (this.size != that.size) throw new IllegalArgumentException("Sizes are not addition compatible.")
  }

  def size = {
    (row, col)
  }

  def apply(r: Int, c: Int) = {
    arr(r)(c)
  }

  def update(r: Int, c: Int, value: Int) = {
    println(f"Setting arr($r%d)($c%d) = $value%d")

    arr(r)(c) = value
  }
}