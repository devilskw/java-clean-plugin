# java-clean-plugin

precisa add no settings.xml do computador:

``
<pluginGroups>
  <pluginGroup>br.com.kazuo</pluginGroup>
</pluginGroups>
``

e depois rodar:

``
mvn clean install
``
para testar, deixei um arquivo example-pom-usage.xml que poderia ser colocado em uma pasta de um novo projeto e, nessa, pasta, rodaria o codigo abaixo
``
mvn cleanarch:generate
``

Fonte usada para consulta: https://www.baeldung.com/maven-plugin