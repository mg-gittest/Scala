package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
  import Main.pascal
  
  test("pascal: col=0,row=2") {
    assert(pascal(0,2) === 1)
  }

  test("pascal: dodgy") {
    assert(pascal( 0,-1) === 0) // r < 0
    assert(pascal(-1, 0) === 0) // c < 0
    assert(pascal(-1,-1) === 0) // c < 0, r < 0
    assert(pascal( 1, 0) === 0) // c > r
  }


  test("pascal: row=2") {
    assert(pascal(0,2) === 1)
    assert(pascal(1,2) === 2)
    assert(pascal(2,2) === 1)
  }

    test("pascal: row=3") {
    assert(pascal(0,3) === 1)
    assert(pascal(1,3) === 3)
    assert(pascal(2,3) === 3)
    assert(pascal(3,3) === 1)
  }

  test("pascal: row=4") {
    assert(pascal(0,4) === 1)
    assert(pascal(1,4) === 4)
    assert(pascal(2,4) === 6)
    assert(pascal(3,4) === 4)
    assert(pascal(4,4) === 1)
  }
  
  test("pascal: row=5") {
    assert(pascal(0,5) === 1)
    assert(pascal(1,5) === 5)
    assert(pascal(2,5) === 10)
    assert(pascal(3,5) === 10)
    assert(pascal(4,5) === 5)
    assert(pascal(5,5) === 1)
  }
  
}
