/*
 * Copyright 2016 Nicolas Rinaudo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kantan.xpath
package cats

import _root_.cats.Eq
import _root_.cats.implicits._
import _root_.cats.laws.discipline.eq._
import kantan.codecs.cats.laws.discipline.EqInstances
import laws.discipline.arbitrary._
import org.scalacheck.Arbitrary

object equality extends EqInstances {
  implicit def queryEq[A: Eq: Arbitrary]: Eq[Query[A]] = new Eq[Query[A]] {
    implicit val arb = arbNode((a: A) => a.toString)
    override def eqv(a1: Query[A], a2: Query[A]) =
      kantan.codecs.laws.discipline.equality.eq(a1.eval, a2.eval) { (d1, d2) =>
        d1 === d2
      }
  }

  implicit def eqXmlSource[A: Eq: Arbitrary]: Eq[XmlSource[A]] = Eq.by { source => (a: A) =>
    source.asNode(a)
  }

}
