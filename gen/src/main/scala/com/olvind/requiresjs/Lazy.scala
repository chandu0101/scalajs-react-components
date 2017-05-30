package com.olvind.requiresjs

// semi-solves circular dependencies
final class Lazy[+T](_t: => T) {
  lazy val run: T = _t

  def map[U](f: T => U): Lazy[U] =
    new Lazy(f(_t))

  def flatMap[U](f: T => Lazy[U]) =
    new Lazy(f(_t).run)
}

object Lazy {
  def apply[T](_t: => T) =
    new Lazy(_t)
}