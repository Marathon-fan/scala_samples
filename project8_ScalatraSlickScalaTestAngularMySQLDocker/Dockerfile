# from a ubuntu with mysql
FROM picoded/ubuntu-openjdk-8-jdk

#################scala and sbt
# Env variables
ENV SCALA_VERSION 2.12.4
ENV SBT_VERSION 1.1.0

# Scala expects this file
RUN touch /usr/lib/jvm/java-8-openjdk-amd64/release

RUN \
  apt-get update; apt-get -y install curl

# Install Scala
## Piping curl directly in tar
RUN \
  curl -fsL https://downloads.typesafe.com/scala/$SCALA_VERSION/scala-$SCALA_VERSION.tgz | tar xfz - -C /root/ && \
  echo >> /root/.bashrc && \
  echo "export PATH=~/scala-$SCALA_VERSION/bin:$PATH" >> /root/.bashrc

# Install sbt
RUN \
  curl -L -o sbt-$SBT_VERSION.deb https://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
  dpkg -i sbt-$SBT_VERSION.deb && \
  rm sbt-$SBT_VERSION.deb && \
  apt-get update && \
  apt-get install sbt && \
  sbt sbtVersion

#################my sql- use amazon mysql


#################


#################
WORKDIR /app
COPY scalatraBackend /app
CMD ["cd", "/app/scalatraBackend"]
CMD ["chmod +x sbt && ./sbt ~jetty:start"]

