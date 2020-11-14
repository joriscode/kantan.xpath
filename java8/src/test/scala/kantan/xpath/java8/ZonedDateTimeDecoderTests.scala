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

package kantan.xpath.java8

import java.time.ZonedDateTime
import kantan.xpath.NodeDecoder
import kantan.xpath.java8.arbitrary._
import kantan.xpath.laws.discipline.{DisciplineSuite, NodeDecoderTests, SerializableTests}

class ZonedDateTimeDecoderTests extends DisciplineSuite {

  checkAll("NodeDecoder[ZonedDateTime]", NodeDecoderTests[ZonedDateTime].decoder[Int, Int])
  checkAll("NodeDecoder[ZonedDateTime]", SerializableTests[NodeDecoder[ZonedDateTime]].serializable)

}
