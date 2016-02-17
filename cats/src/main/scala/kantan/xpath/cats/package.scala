package kantan.xpath

import _root_.cats.functor.Contravariant
import _root_.cats.{Eq, Functor}
import kantan.codecs.cats.CatsInstances
import kantan.xpath.XPathError.{EvaluationError, LoadingError}

package object cats extends CatsInstances {
  /** `Eq` instance for errors. */
  implicit val errorEq = new Eq[XPathError] {
    override def eqv(x: XPathError, y: XPathError) = x == y
  }

  implicit val evaluationErrorEq = new Eq[XPathError.EvaluationError] {
    override def eqv(x: EvaluationError, y: EvaluationError) = x == y
  }

  implicit val loadingErrorEq = new Eq[XPathError.LoadingError] {
    override def eqv(x: LoadingError, y: LoadingError) = x == y
  }

  /** `Functor` instance for `NodeDecoder`. */
  implicit val nodeDecoder = new Functor[NodeDecoder] {
    override def map[A, B](fa: NodeDecoder[A])(f: A ⇒ B) = fa.map(f)
  }

  /** `Contravariant` instance for `XmlSource`. */
  implicit val xmlSource = new Contravariant[XmlSource] {
    override def contramap[A, B](fa: XmlSource[A])(f: B ⇒ A) = fa.contramap(f)
  }
}
