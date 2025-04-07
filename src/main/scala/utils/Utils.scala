package utils

object Utils {
  final def buscarVariavelDeAmbienteCasoExistaOuPropriedade(variavelDeAmbiente: String, propriedade: String): String = {
    val variavel = System.getenv(variavelDeAmbiente)

    if (variavel == null) Propriedades.get(propriedade)
    else variavel
  }
}
