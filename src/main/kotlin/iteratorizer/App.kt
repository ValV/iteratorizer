/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */

package iteratorizer

class App(val lists: List<List<Int>>) {
  private val itX: List<Iterator<Int>> by lazy {
    listOf(
        lists[0].iterator(),
        lists[1].iterator(),
        lists[2].iterator()
      )
  }
  private val current: MutableList<Int> by lazy {
    mutableListOf(itX[0].next(), itX[1].next(), itX[2].next())
  }
  private val inf = Int.MAX_VALUE
  private var count = 0
  private val size = 3
  private var idx = 0

  init {
    count = lists[0].size + lists[1].size + lists[2].size
  }

  fun getNext() {
    if (current[idx] == current.min() && hasNext()) {
      println("${current[idx]}\t$current")
      current[idx] = if (itX[idx].hasNext()) itX[idx].next() else inf
      count --
    }
    idx = if (idx == size - 1) 0 else idx + 1
  }

  fun hasNext() = count > 0
}

fun main(args: Array<String>) {
  val app = App(listOf(
    listOf(1, 8, 12, 17, 26, 31),
    listOf(2, 7, 35, 40),
    listOf(10, 13, 15, 18)
  ))
  while (app.hasNext()) app.getNext()
}

// vim: se et ts=2 sw=2 number:
