package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CountChangeSuite extends FunSuite {
  import Main.countChange
  test("countChange: single coin one") {
    assert(countChange(1,List(1)) === 1)
  }

  test("countChange: single coin two") {
    assert(countChange(2,List(1)) === 1)
  }
  
  test("countChange: two coin 0") {
    assert(countChange(0,List(1,2)) === 1)
  }
  
  test("countChange: two coin 1") {
    assert(countChange(1,List(1,2)) === 1)
  }
  
  test("countChange: two coin 2") {
    assert(countChange(2,List(1,2)) === 2)
  }
  
  test("countChange: two coin 3") {
    assert(countChange(3,List(1,2)) === 2)
  }
  
  test("countChange: two coin 4") {
    assert(countChange(4,List(1,2)) === 3)
  }

  
  test("countChange: sorted CHF") {
    assert(countChange(300,List(5,10,20,50,100,200,500)) === 1022)
  }

  test("countChange: no pennies") {
    assert(countChange(301,List(5,10,20,50,100,200,500)) === 0)
  }

  test("countChange: unsorted CHF") {
    assert(countChange(300,List(500,5,50,100,20,200,10)) === 1022)
  }
}
