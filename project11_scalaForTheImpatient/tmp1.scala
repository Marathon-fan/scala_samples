

  val s = "brilliant"

  assert( s.take(2) == "br" )
  assert( s.drop(2) == "illiant" )
  assert( s.takeRight(2) == "nt" )
  assert( s.dropRight(2) == "brillia" )

  // advantages: chain
  assert( s.drop(2).take(3) == "ill" )