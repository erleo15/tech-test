export PROJ_HOME=target
echo "Iniciando Microservicio TestTech"
java -Dquarkus.config.locations=resources/properties/application-mod.properties -Dquarkus.profile=dev -jar $PROJ_HOME/quarkus-app/quarkus-run.jar
echo "Microservicio TestTech Ejecutado/Finalizado"