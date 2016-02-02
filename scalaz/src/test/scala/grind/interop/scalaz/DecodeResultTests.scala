package grind.interop.scalaz

import grind.DecodeResult
import grind.laws.discipline.arbitrary._

import scalaz.scalacheck.ScalazProperties.{equal, monad}
import scalaz.std.anyVal._

class DecodeResultTests extends ScalazSuite {
  checkAll("DecodeResult", monad.laws[DecodeResult])
  checkAll("DecodeResult[Int]", equal.laws[DecodeResult[Int]])
}
