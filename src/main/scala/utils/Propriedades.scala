package utils

import java.util.Properties

object Propriedades {

  final val properties = carregarPropertiesSistema

  private def carregarPropertiesSistema: Properties = {
    val propriedades = new Properties()
    propriedades.load(getClass.getClassLoader.getResourceAsStream("sistema.properties"))

    propriedades
  }

  def get(propriedade: String): String = {
    if (!properties.contains(propriedade)) {
      properties.getProperty(propriedade)
    } else {
      throw new IllegalArgumentException(s"Propriedade: $propriedade não encontrada no properties")
    }
  }
}
