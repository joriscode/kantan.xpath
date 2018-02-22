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
package joda

import kantan.codecs.export.Exported
import kantan.codecs.strings.StringDecoder
import kantan.codecs.strings.joda.time._
import org.joda.time.{DateTime, LocalDate, LocalDateTime, LocalTime}

/** Declares [[kantan.xpath.NodeDecoder]] instances joda-time types.
  *
  * Note that the type for default codecs might come as a surprise: the wrapping `Exported` is used to lower their
  * priority. This is necessary because the standard use case will be to `import kantan.xpath.joda.time._`, which
  * brings both the instance creation and default instances in scope. Without this type trickery, custom instances
  * and default ones would always clash.
  */
package object time extends JodaTimeDecoderCompanion[Option[Node], DecodeError, codecs.type] {

  override def decoderFrom[D](d: StringDecoder[D]) = codecs.fromString(d)

  implicit val defaultDateTimeNodeDecoder: Exported[NodeDecoder[DateTime]] = Exported(defaultDateTimeDecoder)
  implicit val defaultLocalDateTimeNodeDecoder: Exported[NodeDecoder[LocalDateTime]] = Exported(
    defaultLocalDateTimeDecoder
  )
  implicit val defaultLocalTimeNodeDecoder: Exported[NodeDecoder[LocalTime]] = Exported(defaultLocalTimeDecoder)
  implicit val defaultLocalDateNodeDecoder: Exported[NodeDecoder[LocalDate]] = Exported(defaultLocalDateDecoder)

}
