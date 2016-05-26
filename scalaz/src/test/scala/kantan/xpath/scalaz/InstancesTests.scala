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

package kantan.xpath.scalaz

import _root_.scalaz.scalacheck.ScalazProperties.{equal, monad}
import _root_.scalaz.std.anyVal._
import kantan.xpath._
import kantan.xpath.scalaz.arbitrary._
import kantan.xpath.scalaz.equality._

class InstancesTests extends ScalazSuite {
  checkAll("ReadError", equal.laws[ReadError])
  checkAll("DecodeError", equal.laws[DecodeError])
  checkAll("ParseError", equal.laws[ParseError])
  checkAll("Query", monad.laws[Query])
}
