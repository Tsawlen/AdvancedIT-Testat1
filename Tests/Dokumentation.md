# Testat Dokumentation
Tomke Müller - Matrikelnummer 9974531  
Aufgabe ist es ein System zu entwickeln, welches das Befahren eines gemeinsamen Abschnittes durch Lok0 und Lok1 ermöglicht.  
Bedingungen hierfür sind, dass die Loks immer abwechselnd einen gemeinsam genutzen Bereich befahren und keines Falls gleichzeitig auf den gemeinsamen Bereich fahren!  

## Aufgabe A
In Aufgabe A soll dies unter zur Hilfe nahme des Erzeuger-/Verbraucher Problems gelöst werden.  
Um diesen Sachverhalt darstellen zu können werden in der Datei `SharedSpace.java` zwei Semaphore verwendet, welche wie folgt eingestellt sind:
```java
private Semaphore zug1 = new Semaphore(1,true);
private Semaphore zug2 = new Semaphore(0,true);
```
### Beispiel 1:
In diesem Beispiel sollen Lok 0 und Lok 1 gleich schnell fahren, Lok 1 allerdings zuerst in den gemeinsamen Bereich einfahren.  
Hierfür wurden folgende Einstellungen gewählt:  
```java
private static int velocityTrain1 = 100;
private static int velocityTrain2 = 100;
```
#### Ausgabe des 1. Beispieles
```java
Zug 0 möchte in den gemeinsamen Bereich einfahren
			Zug 0 fährt durch gemeinsamen Bereich!
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
```
#### Auswertung
Beispiel 1 erfüllt die gegebenen Bedingungen. Auch wenn ein Zug in den gemeinsamen Bereich einfahren möchte, so ist dies nicht möglich, während der Bereich von dem anderen Zug befahren wird. 
### Beispiel 2: Geschwindigkeit Lok 0 < Geschwindigkeit Lok 1
In diesem Beispiel soll Lok 1 schneller fahren als Lok 0. Hierfür wurden folgende Einstellungen gewählt:
```java
private static int velocityTrain1 = 100;
private static int velocityTrain2 = 200;
```
#### Ausgabe des 2. Beispieles
```java
Zug 0 möchte in den gemeinsamen Bereich einfahren
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
						Zug 1 möchte in den gemeinsamen Bereich einfahren
Zug 0 möchte in den gemeinsamen Bereich einfahren
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
						Zug 1 möchte in den gemeinsamen Bereich einfahren
Zug 0 möchte in den gemeinsamen Bereich einfahren
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
						Zug 1 möchte in den gemeinsamen Bereich einfahren
Zug 0 möchte in den gemeinsamen Bereich einfahren
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
```
#### Auswertung
Auch Beispiel 2 hält sich an die festgelegten Konventionen. Auch wenn Lok 1 deutlich schneller ist als Lok 0, so kann diese doch nur in den gemeinsamen Bereich einfahren, während dieser frei ist und Lok 0 zwischendurch ebenfalls einmal durch den Bereich gefahren ist.

### Beispiel 3: Geschwindigkeit Lok 0 > Geschwindigkeit Lok 1
In diesem Beispiel soll Lok 1 langsamer fahren als Lok 0. Hierfür wurden folgende Bedingungen gewählt:
```java
private static int velocityTrain1 = 200;
private static int velocityTrain2 = 100;
```
#### Ausgabe des 3. Beispieles
```java
Zug 0 möchte in den gemeinsamen Bereich einfahren
			Zug 0 fährt durch gemeinsamen Bereich!
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
```
#### Auswertung
Beispiel 3 hält sich ebenfalls an die vorgebenen Bedingungen.
### Auswertung Aufgabe A
Da die Semaphore wie in der Einleitung zu diesem Abschnitt eingestellt wurden ist sichergestellt, dass nicht beide Loks zur selben Zeit im gemeinsamen Abschnitt fahren können. Zudem ist dadurch, dass Lok 1 Lok 0 freigibt - und andersherum - sichergestellt, dass beide Loks streng abwechselnd fahren!

## Aufgabe B
In diesem Teil des Testates sollte das vorliegende Problem mit Hilfe privater Semaphore gelöst werden.  
Zur Lösung dieses Problemes wurden in der Datei `PrivateSharedSpace.java` folgende Einstellungen gewählt:
```java
private boolean blocked;
	private boolean[] waiting;
	private int lastDrivenThrough;
	private Semaphore[] privateSemaphore;
	
	public PrivateSharedSpace() {
		
		blocked = false;
		lastDrivenThrough = 1;
		waiting = new boolean[2];
		privateSemaphore = new Semaphore[2];
		for(int i = 0; i < 2; i++) {
			waiting[i] = false;
			privateSemaphore[i] = new Semaphore(0, true);
		}
		
	}
```
### Beispiel 1: Geschwindigkeit Lok 0 = Geschwindigkeit Lok 1
In diesem Beispiel sollen wieder beide Züge mit der gleichen Geschwindigkeit fahren. Hierfür wurden die folgenden Einstellungen in der Datei `PrivateTrainRunner.java` gewählt:
```java
private static int velocityTrain1 = 100;
private static int velocityTrain2 = 100;
``` 
#### Ausgabe des 1. Beispieles
```java 
Zug 0 möchte in den gemeinsamen Bereich einfahren
			Zug 0 fährt durch gemeinsamen Bereich!
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
			Zug 0 fährt durch gemeinsamen Bereich!
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
			Zug 0 fährt durch gemeinsamen Bereich!
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
			Zug 0 fährt durch gemeinsamen Bereich!
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
```
#### Auswertung des 1. Beispieles
Wie zu sehen ist hält sich das Programm strikt an alle vorgaben, wie definiert. Dies ist bei gleichschnellen Zügen allerdings auch zu erwarten.
### Beispiel 2: Geschwindigkeit Lok 0 < Geschwindigkeit Lok 1
In diesem Beispiel soll Lok 1 erneut schneller fahren als Lok 0. Hierfür wurden folgende Einstellungen gewählt:
```java
private static int velocityTrain1 = 100;
private static int velocityTrain2 = 200;
```
#### Ausgabe des 2. Beispieles
```java 
Zug 0 möchte in den gemeinsamen Bereich einfahren  
						Zug 1 möchte in den gemeinsamen Bereich einfahren  
			Zug 0 fährt durch gemeinsamen Bereich!  
			Zug 0 verlässt gemeinsamen Bereich!  
Zug 0 fährt auf seinem eigenen Bereich!  
			Zug 1 fährt durch gemeinsamen Bereich!  
			Zug 1 verlässt gemeinsamen Bereich!  
						Zug 1 fährt auf seinem eigenen Bereich!  
						Zug 1 möchte in den gemeinsamen Bereich einfahren  
Zug 0 möchte in den gemeinsamen Bereich einfahren  
			Zug 0 fährt durch gemeinsamen Bereich!  
			Zug 0 verlässt gemeinsamen Bereich!  
Zug 0 fährt auf seinem eigenen Bereich!  
			Zug 1 fährt durch gemeinsamen Bereich!  
			Zug 1 verlässt gemeinsamen Bereich!  
						Zug 1 fährt auf seinem eigenen Bereich!  
						Zug 1 möchte in den gemeinsamen Bereich einfahren  
Zug 0 möchte in den gemeinsamen Bereich einfahren  
			Zug 0 fährt durch gemeinsamen Bereich!  
			Zug 0 verlässt gemeinsamen Bereich!  
Zug 0 fährt auf seinem eigenen Bereich!  
			Zug 1 fährt durch gemeinsamen Bereich!  
			Zug 1 verlässt gemeinsamen Bereich!  
						Zug 1 fährt auf seinem eigenen Bereich!  
						Zug 1 möchte in den gemeinsamen Bereich einfahren  
Zug 0 möchte in den gemeinsamen Bereich einfahren  
			Zug 0 fährt durch gemeinsamen Bereich!  
			Zug 0 verlässt gemeinsamen Bereich!  
Zug 0 fährt auf seinem eigenen Bereich!  
			Zug 1 fährt durch gemeinsamen Bereich!  
			Zug 1 verlässt gemeinsamen Bereich!  
						Zug 1 fährt auf seinem eigenen Bereich!  
						Zug 1 möchte in den gemeinsamen Bereich einfahren  
Zug 0 möchte in den gemeinsamen Bereich einfahren  
			Zug 0 fährt durch gemeinsamen Bereich!  
			Zug 0 verlässt gemeinsamen Bereich!  
Zug 0 fährt auf seinem eigenen Bereich!  
			Zug 1 fährt durch gemeinsamen Bereich!  
			Zug 1 verlässt gemeinsamen Bereich!  
						Zug 1 fährt auf seinem eigenen Bereich!  
						Zug 1 möchte in den gemeinsamen Bereich einfahren  
Zug 0 möchte in den gemeinsamen Bereich einfahren  
			Zug 0 fährt durch gemeinsamen Bereich!  
			Zug 0 verlässt gemeinsamen Bereich!  
Zug 0 fährt auf seinem eigenen Bereich!  
			Zug 1 fährt durch gemeinsamen Bereich!  
			Zug 1 verlässt gemeinsamen Bereich!  
						Zug 1 fährt auf seinem eigenen Bereich!  
						Zug 1 möchte in den gemeinsamen Bereich einfahren 
```	
#### Auswertung des 2. Beispieles
### Beispiel 3: Geschwindigkeit Lok 0 > Geschwindigkeit Lok 1
In diesem Beispiel soll Lok 0 erneut schneller fahren als Lok 1. Hierfür wurden folgende Einstellungen gewählt:
```java
private static int velocityTrain1 = 200;
private static int velocityTrain2 = 100;
```
#### Ausgabe des 3. Beispieles
```java 
Zug 0 möchte in den gemeinsamen Bereich einfahren  
						Zug 1 möchte in den gemeinsamen Bereich einfahren  
			Zug 0 fährt durch gemeinsamen Bereich!  
			Zug 0 verlässt gemeinsamen Bereich!  
Zug 0 fährt auf seinem eigenen Bereich!  
			Zug 1 fährt durch gemeinsamen Bereich!  
			Zug 1 verlässt gemeinsamen Bereich!  
						Zug 1 fährt auf seinem eigenen Bereich!  
Zug 0 möchte in den gemeinsamen Bereich einfahren  
			Zug 0 fährt durch gemeinsamen Bereich!  
			Zug 0 verlässt gemeinsamen Bereich!  
Zug 0 fährt auf seinem eigenen Bereich!  
Zug 0 möchte in den gemeinsamen Bereich einfahren  
						Zug 1 möchte in den gemeinsamen Bereich einfahren  
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
						Zug 1 möchte in den gemeinsamen Bereich einfahren
			Zug 1 fährt durch gemeinsamen Bereich!
			Zug 1 verlässt gemeinsamen Bereich!
						Zug 1 fährt auf seinem eigenen Bereich!
			Zug 0 fährt durch gemeinsamen Bereich!
			Zug 0 verlässt gemeinsamen Bereich!
Zug 0 fährt auf seinem eigenen Bereich!
Zug 0 möchte in den gemeinsamen Bereich einfahren
```
#### Auswertung des 3. Beispieles
### Auswertung der Aufgabe B