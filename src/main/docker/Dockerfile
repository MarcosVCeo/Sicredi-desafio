FROM openjdk:17-slim

# Variáveis de ambiente para Spark
ENV SPARK_VERSION=3.5.5
ENV HADOOP_VERSION=3
ENV SPARK_HOME=/opt/spark
ENV PATH=$SPARK_HOME/bin:$PATH

# Instala dependências e Spark
RUN apt-get update && \
    apt-get install -y curl unzip && \
    curl -L https://downloads.apache.org/spark/spark-${SPARK_VERSION}/spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION}.tgz | tar -xz -C /opt && \
    ln -s /opt/spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION} /opt/spark && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY target/scala-2.12/sicredi-desafio-assembly-0.1.0-SNAPSHOT.jar ./app.jar

#ENTRYPOINT ["java", "--add-opens=java.base/sun.nio.ch=ALL-UNNAMED", "-jar", "app.jar"]
ENTRYPOINT ["/opt/spark/bin/spark-submit", "--class", "Main", "--conf", "spark.driver.extraJavaOptions=--add-opens=java.base/sun.nio.ch=ALL-UNNAMED", "/app/app.jar"]

