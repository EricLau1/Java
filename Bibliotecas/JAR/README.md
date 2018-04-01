Compilar um programa Java para .jar

Funciona no JDK 8

1º Compile o programa para gerar o arquivo .class

2º Crie o arquivo Manisfet (De uma olhada no arquivo para ver a estrutura dele, é necessário informar qual é classe principal)

3º Executar o comando: 

	jar -cfvm Test.jar Manifest.txt Test.class


4º Executar o comando:

	java -jar Test.jar				
