#!/bin/bash
VERSION=3.18.7

if [ -f jOOQ-javadoc/jooq-$VERSION-javadoc.jar ]; then
  JAVADOC_JOOQ=-Djavadoc=jOOQ-javadoc/jooq-$VERSION-javadoc.jar
  JAVADOC_JOOQ_META=-Djavadoc=jOOQ-javadoc/jooq-meta-$VERSION-javadoc.jar
  JAVADOC_JOOQ_META_EXTENSIONS=-Djavadoc=jOOQ-javadoc/jooq-meta-extensions-$VERSION-javadoc.jar
  JAVADOC_JOOQ_META_EXTENSIONS_HIBERNATE=-Djavadoc=jOOQ-javadoc/jooq-meta-extensions-hibernate-$VERSION-javadoc.jar
  JAVADOC_JOOQ_META_EXTENSIONS_LIQUIBASE=-Djavadoc=jOOQ-javadoc/jooq-meta-extensions-liquibase-$VERSION-javadoc.jar
  JAVADOC_JOOQ_CODEGEN=-Djavadoc=jOOQ-javadoc/jooq-codegen-$VERSION-javadoc.jar
  JAVADOC_JOOQ_CODEGEN_MAVEN=-Djavadoc=jOOQ-javadoc/jooq-codegen-maven-$VERSION-javadoc.jar
  JAVADOC_JOOQ_CHECKER=-Djavadoc=jOOQ-javadoc/jooq-checker-$VERSION-javadoc.jar
  JAVADOC_JOOQ_JACKSON_EXTENSIONS=-Djavadoc=jOOQ-javadoc/jooq-jackson-extensions-$VERSION-javadoc.jar
  JAVADOC_JOOQ_POSTGRES_EXTENSIONS=-Djavadoc=jOOQ-javadoc/jooq-postgres-extensions-$VERSION-javadoc.jar




  JAVADOC_JOOQ_SCALA_2_13=-Djavadoc=jOOQ-javadoc/jooq-scala_2.13-$VERSION-javadoc.jar
  JAVADOC_JOOQ_KOTLIN=-Djavadoc=jOOQ-javadoc/jooq-kotlin-$VERSION-javadoc.jar
  JAVADOC_JOOQ_KOTLIN_COROUTINES=-Djavadoc=jOOQ-javadoc/jooq-kotlin-coroutines-$VERSION-javadoc.jar
  JAVADOC_JOOQ_XTEND=-Djavadoc=jOOQ-javadoc/jooq-xtend-$VERSION-javadoc.jar
fi

if [ -f jOOQ-src/jooq-$VERSION-sources.jar ]; then
  SOURCES_JOOQ=-Dsources=jOOQ-src/jooq-$VERSION-sources.jar
  SOURCES_JOOQ_META=-Dsources=jOOQ-src/jooq-meta-$VERSION-sources.jar
  SOURCES_JOOQ_META_EXTENSIONS=-Dsources=jOOQ-src/jooq-meta-extensions-$VERSION-sources.jar
  SOURCES_JOOQ_META_EXTENSIONS_HIBERNATE=-Dsources=jOOQ-src/jooq-meta-extensions-hibernate-$VERSION-sources.jar
  SOURCES_JOOQ_META_EXTENSIONS_LIQUIBASE=-Dsources=jOOQ-src/jooq-meta-extensions-liquibase-$VERSION-sources.jar
  SOURCES_JOOQ_CODEGEN=-Dsources=jOOQ-src/jooq-codegen-$VERSION-sources.jar
  SOURCES_JOOQ_CODEGEN_MAVEN=-Dsources=jOOQ-src/jooq-codegen-maven-$VERSION-sources.jar
  SOURCES_JOOQ_CHECKER=-Dsources=jOOQ-src/jooq-checker-$VERSION-sources.jar
  SOURCES_JOOQ_JACKSON_EXTENSIONS=-Dsources=jOOQ-src/jooq-jackson-extensions-$VERSION-sources.jar
  SOURCES_JOOQ_POSTGRES_EXTENSIONS=-Dsources=jOOQ-src/jooq-postgres-extensions-$VERSION-sources.jar




  SOURCES_JOOQ_SCALA_2_13=-Djavadoc=jOOQ-src/jooq-scala_2.13-$VERSION-sources.jar
  SOURCES_JOOQ_KOTLIN=-Djavadoc=jOOQ-src/jooq-kotlin-$VERSION-sources.jar
  SOURCES_JOOQ_KOTLIN_COROUTINES=-Djavadoc=jOOQ-src/jooq-kotlin-coroutines-$VERSION-sources.jar
  SOURCES_JOOQ_XTEND=-Djavadoc=jOOQ-src/jooq-xtend-$VERSION-sources.jar
fi

# [#15072] Document known maven bug
BAD_MAVEN_VERSION=".*Apache Maven 3.9.0.*"
MAVEN_VERSION=$(mvn -version | grep '.*Apache Maven 3\.9\.0.*')
if [[ "$MAVEN_VERSION" =~ $BAD_MAVEN_VERSION ]]; then
  echo ""
  echo "ERROR: Maven 3.9.0 has a known bug preventing install:install-file calls."
  echo "Please upgrade to a newer version."
  echo "See also: https://issues.apache.org/jira/browse/MNG-7679"
  echo ""
fi

set -e
mvn install:install-file -e -Dfile=jOOQ-pom/pom.xml                                     -DgroupId=org.jooq -DartifactId=jooq-parent                    -Dversion=$VERSION -Dpackaging=pom
mvn install:install-file -e -Dfile=jOOQ-lib/jooq-$VERSION.jar                           -DgroupId=org.jooq -DartifactId=jooq                           -Dversion=$VERSION -Dpackaging=jar $JAVADOC_JOOQ                           $SOURCES_JOOQ                           -DpomFile=jOOQ-pom/jooq/pom.xml
mvn install:install-file -e -Dfile=jOOQ-lib/jooq-meta-$VERSION.jar                      -DgroupId=org.jooq -DartifactId=jooq-meta                      -Dversion=$VERSION -Dpackaging=jar $JAVADOC_JOOQ_META                      $SOURCES_JOOQ_META                      -DpomFile=jOOQ-pom/jooq-meta/pom.xml
mvn install:install-file -e -Dfile=jOOQ-lib/jooq-meta-extensions-$VERSION.jar           -DgroupId=org.jooq -DartifactId=jooq-meta-extensions           -Dversion=$VERSION -Dpackaging=jar $JAVADOC_JOOQ_META_EXTENSIONS           $SOURCES_JOOQ_META_EXTENSIONS           -DpomFile=jOOQ-pom/jooq-meta-extensions/pom.xml
mvn install:install-file -e -Dfile=jOOQ-lib/jooq-meta-extensions-hibernate-$VERSION.jar -DgroupId=org.jooq -DartifactId=jooq-meta-extensions-hibernate -Dversion=$VERSION -Dpackaging=jar $JAVADOC_JOOQ_META_EXTENSIONS_HIBERNATE $SOURCES_JOOQ_META_EXTENSIONS_HIBERNATE -DpomFile=jOOQ-pom/jooq-meta-extensions-hibernate/pom.xml
mvn install:install-file -e -Dfile=jOOQ-lib/jooq-meta-extensions-liquibase-$VERSION.jar -DgroupId=org.jooq -DartifactId=jooq-meta-extensions-liquibase -Dversion=$VERSION -Dpackaging=jar $JAVADOC_JOOQ_META_EXTENSIONS_LIQUIBASE $SOURCES_JOOQ_META_EXTENSIONS_LIQUIBASE -DpomFile=jOOQ-pom/jooq-meta-extensions-liquibase/pom.xml
mvn install:install-file -e -Dfile=jOOQ-lib/jooq-codegen-$VERSION.jar                   -DgroupId=org.jooq -DartifactId=jooq-codegen                   -Dversion=$VERSION -Dpackaging=jar $JAVADOC_JOOQ_CODEGEN                   $SOURCES_JOOQ_CODEGEN                   -DpomFile=jOOQ-pom/jooq-codegen/pom.xml
mvn install:install-file -e -Dfile=jOOQ-lib/jooq-codegen-maven-$VERSION.jar             -DgroupId=org.jooq -DartifactId=jooq-codegen-maven             -Dversion=$VERSION -Dpackaging=jar $JAVADOC_JOOQ_CODEGEN_MAVEN             $SOURCES_JOOQ_CODEGEN_META              -DpomFile=jOOQ-pom/jooq-codegen-maven/pom.xml
mvn install:install-file -e -Dfile=jOOQ-lib/jooq-checker-$VERSION.jar                   -DgroupId=org.jooq -DartifactId=jooq-checker                   -Dversion=$VERSION -Dpackaging=jar $JAVADOC_JOOQ_CHECKER                   $SOURCES_JOOQ_CHECKER                   -DpomFile=jOOQ-pom/jooq-checker/pom.xml
mvn install:install-file -e -Dfile=jOOQ-lib/jooq-jackson-extensions-$VERSION.jar        -DgroupId=org.jooq -DartifactId=jooq-jackson-extensions        -Dversion=$VERSION -Dpackaging=jar $JAVADOC_JOOQ_JACKSON_EXTENSIONS        $SOURCES_JOOQ_JACKSON_EXTENSIONS        -DpomFile=jOOQ-pom/jooq-jackson-extensions/pom.xml
mvn install:install-file -e -Dfile=jOOQ-lib/jooq-postgres-extensions-$VERSION.jar       -DgroupId=org.jooq -DartifactId=jooq-postgres-extensions       -Dversion=$VERSION -Dpackaging=jar $JAVADOC_JOOQ_POSTGRES_EXTENSIONS       $SOURCES_JOOQ_POSTGRES_EXTENSIONS       -DpomFile=jOOQ-pom/jooq-postgres-extensions/pom.xml




mvn install:install-file -e -Dfile=jOOQ-lib/jooq-scala_2.13-$VERSION.jar                -DgroupId=org.jooq -DartifactId=jooq-scala_2.13                -Dversion=$VERSION -Dpackaging=jar $JAVADOC_JOOQ_SCALA_2_13                $SOURCES_JOOQ_SCALA_2_13                -DpomFile=jOOQ-pom/jooq-scala_2.13/pom.xml
mvn install:install-file -e -Dfile=jOOQ-lib/jooq-kotlin-$VERSION.jar                    -DgroupId=org.jooq -DartifactId=jooq-kotlin                    -Dversion=$VERSION -Dpackaging=jar $JAVADOC_JOOQ_KOTLIN                    $SOURCES_JOOQ_KOTLIN                    -DpomFile=jOOQ-pom/jooq-kotlin/pom.xml
mvn install:install-file -e -Dfile=jOOQ-lib/jooq-kotlin-coroutines-$VERSION.jar         -DgroupId=org.jooq -DartifactId=jooq-kotlin-coroutines         -Dversion=$VERSION -Dpackaging=jar $JAVADOC_JOOQ_KOTLIN_COROUTINES         $SOURCES_JOOQ_KOTLIN_COROUTINES         -DpomFile=jOOQ-pom/jooq-kotlin-coroutines/pom.xml
mvn install:install-file -e -Dfile=jOOQ-lib/jooq-xtend-$VERSION.jar                     -DgroupId=org.jooq -DartifactId=jooq-xtend                     -Dversion=$VERSION -Dpackaging=jar $JAVADOC_JOOQ_XTEND                     $SOURCES_JOOQ_XTEND                     -DpomFile=jOOQ-pom/jooq-xtend/pom.xml


echo ""
echo ""
echo "The different jOOQ editions are released under different Maven groupIds!"
echo "------------------------------------------------------------------------"
echo "- org.jooq.pro          : The jOOQ Express, Professional, and Enterprise Editions with support for Java 17+"
echo "- org.jooq.pro-java-11  : The jOOQ Express, Professional, and Enterprise Editions with support for Java 11 - 16"
echo "- org.jooq.pro-java-8   : The jOOQ Express, Professional, and Enterprise Editions with support for Java  8 - 10"
echo "- org.jooq.trial        : The jOOQ Trial Edition with support for Java 17+"
echo "- org.jooq.trial-java-11: The jOOQ Trial Edition with support for Java 11 - 16"
echo "- org.jooq.trial-java-8 : The jOOQ Trial Edition with support for Java  8 - 10"
echo "- org.jooq              : The jOOQ Open Source Edition with support for Java 17+"
