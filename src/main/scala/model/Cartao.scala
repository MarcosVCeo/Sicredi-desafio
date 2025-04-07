package model

import org.apache.spark.sql.{Encoder, Encoders}

case class Cartao(
                   id: Long,
                   num_cartao: Long,
                   nom_impresso: String,
                   id_conta: Long,
                   id_associado: Long
                 )

object Cartao extends CriacaoDS[Cartao] {
  override protected val nomeTabela: String = "cartao"
  override protected implicit val encoder: Encoder[Cartao] = Encoders.product[Cartao]
}
