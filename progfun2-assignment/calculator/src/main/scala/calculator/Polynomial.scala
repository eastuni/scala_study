package calculator

object Polynomial {
  def computeDelta(a: Signal[Double], b: Signal[Double],
      c: Signal[Double]): Signal[Double] = {
    Signal[Double]( b() * b() - 4 * a() * c())
  }

  def computeSolutions(a: Signal[Double], b: Signal[Double],
      c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] = {
    if (delta() > 0) Signal(List[Double]((-b() + Math.sqrt(delta())) / (2 * a()), (-b() - Math.sqrt(delta())) / (2 * a())).sorted.toSet)
    else if (delta() == 0) Signal(Set[Double](-b() / 2 * a()))
    else Signal(Set[Double](0.0))
  }
}
