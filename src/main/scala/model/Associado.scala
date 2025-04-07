package model

import org.apache.spark.sql.{Encoder, Encoders}

case class Associado(
                      id: Long,
                      nome: String,
                      sobreNome: String,
                      idade: Int,
                      email: String
                    )

object Associado extends CriacaoDS[Associado] {
  override protected val nomeTabela = "associado"
  override protected implicit val encoder: Encoder[Associado] = Encoders.product[Associado]
}
