# Fuel Station Project

## Übersicht

Dieses Projekt verwaltet Ladestationen für Elektrofahrzeuge und generiert Rechnungen für Kunden. Es besteht aus mehreren Komponenten, darunter eine PostgreSQL-Datenbank, Docker-Container für die Datenbank und RabbitMQ, sowie eine Spring Boot-Anwendung, die REST-APIs bereitstellt.
Inhaltsverzeichnis

    - Database
    - Docker
    - SpringBoot
    - Setup-Anleitung

## Database

Die Datenbankkomponente verwendet PostgreSQL, um Benutzerdaten, Ladestationsdaten und Transaktionsinformationen zu speichern. Die initialen SQL-Skripte befinden sich im Database-Verzeichnis.
Initiales SQL-Skript

Das SQL-Skript init.sql enthält die Definitionen für die folgenden Tabellen:

- user_info: Speichert Benutzerdaten wie Benutzername, Passwort und E-Mail-Adresse.

- station: Speichert Informationen über die Ladestationen, einschließlich Adresse, PLZ, Anzahl der Transaktionen, Kraftstofftyp und der zugehörigen Kunden-ID.
  
- transaction: Speichert Transaktionen, die an den Ladestationen durchgeführt wurden, einschließlich Station-ID, Kunden-ID und verbrauchter Kraftstoffmenge.

## Docker

Docker wird verwendet, um die PostgreSQL-Datenbanken und RabbitMQ als Container bereitzustellen. Eine docker-compose.yml Datei wird verwendet, um die Konfiguration zu vereinfachen.
docker-compose.yml

Die docker-compose.yml Datei definiert die folgenden Services:

- customer-db: PostgreSQL-Datenbank für Kundendaten.

- mother-db: PostgreSQL-Datenbank für allgemeine Daten.
  
- station1-db, station2-db, station3-db: Separate PostgreSQL-Datenbanken für die Daten der einzelnen Ladestationen.
  
- adminer: Web-basierte Datenbankverwaltungsschnittstelle für PostgreSQL.
  
- queue: RabbitMQ-Instanz für die Nachrichtenübermittlung.

### Docker-Kommandos

Starten der Docker-Container:

 ``docker-compose up -d`` 

Überprüfen der laufenden Container:

 ```docker-compose ps```

Logs anzeigen:

```docker-compose logs```


Stoppen und Entfernen der Container:

``docker-compose down``

## Adminer

Adminer ist eine Web-basierte Schnittstelle zur Verwaltung von PostgreSQL-Datenbanken. Sie kann über den folgenden Link aufgerufen werden: http://localhost:9090

Zugangsdaten:

- Datenbank System: PostgreSQL
  
- Hostname: customer-db (oder der jeweilige Service-Name)
  
- Benutzername: user
  
- Passwort: password
  
- Datenbank: customerdb (oder die jeweilige Datenbank)``

## SpringBoot

Die Spring Boot-Anwendung stellt REST-APIs bereit, um Rechnungen zu generieren und zu verwalten sowie Informationen zu den Ladestationen bereitzustellen. Es verwendet RabbitMQ für die Nachrichtenübermittlung zwischen den Komponenten.
Projektstruktur

Die Spring Boot-Anwendung ist in folgende Pakete unterteilt:

#### controller: 
Enthält die REST-Controller, die die Endpunkte der API definieren.
dto: 
Enthält die Datenübertragungsobjekte (DTOs), die in den API-Anfragen und -Antworten verwendet werden.

#### queue.communication: 
Enthält die Klassen für die Kommunikation mit RabbitMQ.

### Konfigurationsdateien

#### application.properties
Die application.properties Datei enthält die Konfiguration für die Datenbankverbindung und RabbitMQ.

##### Starten der Spring Boot-Anwendung

1. Öffne das ./SpringBoot Verzeichnis in IntelliJ.

2. Führe den folgenden Befehl im Terminal von IntelliJ IDEA aus:

   ``mvn spring-boot:run``    

## Setup-Anleitung

Datenbanken und RabbitMQ starten:

1. Stelle sicher, dass Docker installiert und der Docker-Dienst gestartet ist.

2. Starte die Docker-Container mit:

    ``docker-compose up -d``

## Spring Boot-Anwendung starten:

1. Öffne das ./SpringBoot Verzeichnis in IntelliJ IDEA.

2. Führe den folgenden Befehl im Terminal von IntelliJ IDEA aus:

   ``mvn spring-boot:run`` 

## JavaFX-Anwendung starten:

1. Öffne das ./JavaFX Verzeichnis in IntelliJ IDEA.

2. Führe den folgenden Befehl im Terminal von IntelliJ IDEA aus:

  `` mvn javafx:run``

       
## Worker-Anwendungen starten:
1. Öffne nacheinander die Verzeichnisse ./Worker/Food und ./Worker/Drink in IntelliJ IDEA.
2. Starte die jeweiligen Hauptklassen.

