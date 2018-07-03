# Java Common Helper
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/f23e09f60de644b484ca3ea9156ac997)](https://www.codacy.com/app/bliblidotcom/java-common-helper?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=bliblidotcom/java-common-helper&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/696ffcd27b424e548b1cbeb5cf631184)](https://www.codacy.com/app/bunthatcodes/java-common-helper?utm_source=github.com&utm_medium=referral&utm_content=bliblidotcom/java-common-helper&utm_campaign=Badge_Coverage)

List of available helpers can be found in the <a href="https://github.com/bliblidotcom/java-common-helper/wiki">Wiki page</a>.
<br>Generated javadoc can be found <a href="https://bliblidotcom.github.io/java-common-helper/">here</a>.
<br><br>To use this library, add the following in the `<repositories>` section of your pom:

    <repository>
      <snapshots>
        <enabled>false</enabled>
      </snapshots>
      <id>bintray-bliblidotcom-maven</id>
      <name>bintray</name>
      <url>https://dl.bintray.com/bliblidotcom/maven</url>
    </repository>

and in the `<dependencies>` section, add this declaration:

    <dependency>
      <groupId>com.blibli.oss.helpers</groupId>
      <artifactId>java-common-helper</artifactId>
      <version>${version}</version>
    </dependency>
