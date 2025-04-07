package utils

import org.apache.spark.sql
import org.apache.spark.sql.SparkSession

import java.util.Properties

object ConexaoBancoSicredi {

  def criarDf(nomeTabela: String, options: Map[String, String])(implicit sparkSession: SparkSession): sql.DataFrame = {
    val url = Utils.buscarVariavelDeAmbienteCasoExistaOuPropriedade("POSTGRES_URL", "url")

    val props = new Properties()
    props.put("user", Utils.buscarVariavelDeAmbienteCasoExistaOuPropriedade("POSTGRES_USER", "user"))
    props.put("password", Utils.buscarVariavelDeAmbienteCasoExistaOuPropriedade("POSTGRES_PASSWORD", "password"))
    props.put("driver", Propriedades.get("driver"))

    sparkSession.read.options(options).jdbc(url, nomeTabela, props)
  }
}
