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

package kantan.xpath.cats

import _root_.cats.data.Xor
import kantan.xpath.Node
import kantan.xpath.cats.arbitrary._
import kantan.xpath.laws.discipline.NodeDecoderTests
import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.typelevel.discipline.scalatest.Discipline

class XorDecoderTests extends FunSuite with GeneratorDrivenPropertyChecks with Discipline {
  implicit val legalNode = arbLegalXor[Option[Node], Int, Boolean]
  implicit val illegalNode = arbIllegalXor[Option[Node], Int, Boolean]

  checkAll("NodeDecoder[Int Xor Boolean]", NodeDecoderTests[Int Xor Boolean].decoder[Int, Int])
}
