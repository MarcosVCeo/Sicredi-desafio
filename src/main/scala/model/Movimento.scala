package model

import org.apache.spark.sql.{Encoder, Encoders}

import java.time.LocalDateTime

case class Movimento(id: Long,
                     vlr_transacao: BigDecimal,
                     des_transacao: String,
                     data_movimento: LocalDateTime,
                     id_cartao: Long) {
}

object Movimento extends CriacaoDS[Movimento] {
  override protected val nomeTabela = "movimento"
  override protected implicit val encoder: Encoder[Movimento] = Encoders.product[Movimento]
}
