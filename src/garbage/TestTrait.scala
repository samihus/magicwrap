package garbage

trait InitialSetType[+T <: MySuperType]

trait FinalSetType[+R <: MySuperType]

class MySuperType
class MyType extends MySuperType

case class ClassOfInitialType(t:MyType) extends InitialSetType[MyType]

case class ClassOfFinalType(t:MyType) extends FinalSetType[MyType]


object Test {
  def transform (x: ClassOfInitialType) : ClassOfFinalType= ClassOfFinalType(x.t)

  def genTrans[T<:MySuperType](f: InitialSetType[T] => T)(g: T => FinalSetType[T])(x: InitialSetType[T]): FinalSetType[T] = g(f(x))

  def ff(c1: ClassOfInitialType): MyType = c1.t
  def gg(t: MyType): ClassOfFinalType = ClassOfFinalType(t)
  def fog(x: ClassOfInitialType) = gg(ff(x))

  //def transform2(x: ClassOfInitialType): ClassOfFinalType = genTrans[MyType](y => ff(y))(gg)(x)

}
