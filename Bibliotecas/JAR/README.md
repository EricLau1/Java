Compilar um programa Java para .jar

Funciona no JDK 8

1� Compile o programa para gerar o arquivo .class

2� Crie o arquivo Manisfet (De uma olhada no arquivo para ver a estrutura dele, � necess�rio informar qual � classe principal)

3� Executar o comando: 

	jar -cfvm Test.jar Manifest.txt Test.class


4� Executar o comando:

	java -jar Test.jar				
