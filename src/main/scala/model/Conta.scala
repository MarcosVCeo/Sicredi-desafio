package model

import org.apache.spark.sql.{Encoder, Encoders}

import java.time.LocalDateTime

case class Conta(
                  private val tipo: String,
                  id: Long,
                  data_criacao: LocalDateTime,
                  id_associado: Long
                ) {
  val tipoConta: TipoConta = TipoConta.fromString(tipo)
}

object Conta extends CriacaoDS[Conta] {
  override protected val nomeTabela: String = "conta"
  override protected implicit val encoder: Encoder[Conta] = Encoders.product[Conta]
}