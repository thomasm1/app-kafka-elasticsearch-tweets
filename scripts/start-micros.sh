cd ./client-mapl-config-server && mvn package && java --jar target/mapl-config-server*.jar && \
cd ../client-mapl-gateway && mvn package && java --jar target/mapl-gateway*.jar && \
cd ../client-mapl-service-registry && mvn package && java --jar target/mapl-service-registry*.jar && \
cd ../client-mapl-users && mvn package && java -jar target/mapl-user-service*.jar && \
cd ../client-mapl-dashboard && mvn package -Dmaven.test.skip=true && java --jar target/mapl-dashboard*.*ar && \
cd ../client-mapl-eventbus-amqp && mvn package && java --jar target/mapl-eventbus-ampq*.jar
