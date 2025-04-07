package model

import org.apache.spark.sql.{Dataset, Encoder, SparkSession}

trait CriacaoDS[T <: Product] {

  protected val options: Map[String, String] = Map.empty[String, String]
  protected val nomeTabela: String

  protected implicit val encoder: Encoder[T]

  final def criarDs(implicit sparkSession: SparkSession): Dataset[T] = {
    utils.ConexaoBancoSicredi.criarDf(nomeTabela, options)(sparkSession).as(nomeTabela).as[T]
  }
}