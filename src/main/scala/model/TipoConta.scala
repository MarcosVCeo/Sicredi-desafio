package model

sealed trait TipoConta {
  val nome: String
}

object TipoConta {

  private final val valores: Set[TipoConta] = Set(Corrente, Poupanca, Investimento)

  object Corrente extends TipoConta {
    override val nome = "Corrente"
  }

  object Poupanca extends TipoConta {
    override val nome = "Poupança"
  }

  object Investimento extends TipoConta {
    override val nome = "Investimento"
  }

  def fromString(valor: String): TipoConta = {
    valores
      .find(_.nome == valor)
      .getOrElse(throw new Exception(s"Não foi encontrado o tipo conta $valor parametrizado."))
  }
}
