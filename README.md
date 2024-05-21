# About

This repository's name is: Programmazione-2.

To get started, clone the repository and make some changes.

To invite people to this repo, please contact the organization administrator.

Folder Structure:
```
├── .DS_Store
├── Escape
│   ├── .idea
│   │   ├── encodings.xml
│   │   ├── misc.xml
│   │   ├── uiDesigner.xml
│   │   └── vcs.xml
│   ├── .mvn
│   │   └── wrapper
│   │       ├── maven-wrapper.jar
│   │       └── maven-wrapper.properties
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   ├── Control
│           │   │   ├── HelloController.java
│           │   │   ├── MainFX.java
│           │   │   └── MainGUI.java
│           │   ├── Main
│           │   │   ├── Coordinate.java
│           │   │   ├── Direzioni.java
│           │   │   ├── Enemy.java
│           │   │   ├── Palla.java
│           │   │   ├── Utente.java
│           │   │   └── enemy
│           │   │       ├── Bubbler.java
│           │   │       ├── Striker.java
│           │   │       └── Wanderer.java
│           │   ├── View
│           │   │   ├── KeyHandler.java
│           │   │   └── StatsPane.java
│           │   └── module-info.java
│           └── resources
│               └── controller
│                   └── escape
│                       └── hello-view.fxml
├── Farmacia
│   ├── .idea
│   │   ├── encodings.xml
│   │   ├── misc.xml
│   │   ├── uiDesigner.xml
│   │   └── vcs.xml
│   ├── .mvn
│   │   └── wrapper
│   │       ├── maven-wrapper.jar
│   │       └── maven-wrapper.properties
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   ├── Controller
│           │   │   ├── HelloController.java
│           │   │   └── MainFX.java
│           │   ├── Model
│           │   │   ├── ConRicetta.java
│           │   │   ├── DaBanco.java
│           │   │   ├── DataBase.java
│           │   │   ├── Medicina.java
│           │   │   └── RicettaUtente.java
│           │   ├── View
│           │   │   ├── MainGUI.java
│           │   │   ├── MedicinePane.java
│           │   │   ├── RicettePane.java
│           │   │   ├── SelectPane.java
│           │   │   └── UserPane.java
│           │   └── module-info.java
│           └── resources
│               └── Controller
│                   └── hello-view.fxml
├── GeraltGUI
│   ├── .idea
│   │   ├── encodings.xml
│   │   ├── misc.xml
│   │   ├── uiDesigner.xml
│   │   └── vcs.xml
│   ├── .mvn
│   │   └── wrapper
│   │       ├── maven-wrapper.jar
│   │       └── maven-wrapper.properties
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   ├── View
│           │   │   ├── ButtonPane.java
│           │   │   ├── MainGUI.java
│           │   │   ├── MutationsPane.java
│           │   │   ├── SpellsPane.java
│           │   │   └── StatsPane.java
│           │   ├── model
│           │   │   ├── geralt
│           │   │   │   ├── Geralt.java
│           │   │   │   ├── Mutation.java
│           │   │   │   └── Spell.java
│           │   │   └── mutations
│           │   │       ├── MutationInterface.java
│           │   │       ├── abstracts
│           │   │       │   ├── AbstractMutation.java
│           │   │       │   ├── CombatMutation.java
│           │   │       │   ├── PotionMutation.java
│           │   │       │   └── SpellMutation.java
│           │   │       └── muts
│           │   │           ├── EmptyMutation.java
│           │   │           ├── combat
│           │   │           │   ├── StrCombatMutation.java
│           │   │           │   └── VelCombatMutation.java
│           │   │           ├── potions
│           │   │           │   └── TolPotionMutation.java
│           │   │           └── spells
│           │   │               ├── IgniSpellMutation.java
│           │   │               └── QuenSpellMutation.java
│           │   ├── module-info.java
│           │   └── org
│           │       └── example
│           │           └── geraltgui
│           │               ├── HelloController.java
│           │               ├── Main.java
│           │               └── MainFX.java
│           └── resources
│               └── org
│                   └── example
│                       └── geraltgui
│                           └── hello-view.fxml
├── Macchinina
│   ├── .idea
│   │   ├── encodings.xml
│   │   ├── misc.xml
│   │   ├── uiDesigner.xml
│   │   └── vcs.xml
│   ├── .mvn
│   │   └── wrapper
│   │       ├── maven-wrapper.jar
│   │       └── maven-wrapper.properties
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   ├── Main
│           │   │   ├── Coordinate.java
│           │   │   └── Direzioni.java
│           │   ├── View
│           │   │   ├── Auto.java
│           │   │   ├── Celle
│           │   │   │   ├── Cella.java
│           │   │   │   ├── Prato.java
│           │   │   │   ├── Strada.java
│           │   │   │   └── Strade
│           │   │   │       ├── StradaEst.java
│           │   │   │       ├── StradaNord.java
│           │   │   │       ├── StradaOvest.java
│           │   │   │       └── StradaSud.java
│           │   │   ├── GrigliaPane.java
│           │   │   ├── IndicationButtons.java
│           │   │   ├── KeyHandler.java
│           │   │   └── SettingsButtons.java
│           │   ├── com
│           │   │   └── macchinina
│           │   │       ├── HelloApplication.java
│           │   │       ├── HelloController.java
│           │   │       └── MainGUI.java
│           │   └── module-info.java
│           └── resources
│               └── com
│                   └── macchinina
│                       └── hello-view.fxml
├── Numbers
│   ├── .idea
│   │   ├── encodings.xml
│   │   ├── misc.xml
│   │   ├── uiDesigner.xml
│   │   └── vcs.xml
│   ├── .mvn
│   │   └── wrapper
│   │       ├── maven-wrapper.jar
│   │       └── maven-wrapper.properties
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   ├── Controller
│           │   │   └── MainGUI.java
│           │   ├── View
│           │   │   ├── ButtonPane.java
│           │   │   ├── Cella.java
│           │   │   ├── Celle
│           │   │   │   ├── CellaCentrale.java
│           │   │   │   ├── CellaEmpty.java
│           │   │   │   ├── CellaLaterale.java
│           │   │   │   ├── Centrale
│           │   │   │   │   ├── CellaBlu.java
│           │   │   │   │   └── CellaGrigia.java
│           │   │   │   └── Laterali
│           │   │   │       ├── CellaRossa.java
│           │   │   │       └── CellaVerde.java
│           │   │   ├── GrigliaPane.java
│           │   │   └── KeyHandler.java
│           │   ├── com
│           │   │   └── numbers
│           │   │       ├── HelloApplication.java
│           │   │       └── HelloController.java
│           │   └── module-info.java
│           └── resources
│               └── com
│                   └── numbers
│                       └── hello-view.fxml
├── OnlyFans
│   ├── .idea
│   │   ├── encodings.xml
│   │   ├── misc.xml
│   │   ├── uiDesigner.xml
│   │   └── vcs.xml
│   ├── .mvn
│   │   └── wrapper
│   │       ├── maven-wrapper.jar
│   │       └── maven-wrapper.properties
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   ├── Controller
│           │   │   ├── Alimentazione.java
│           │   │   ├── Fans.java
│           │   │   ├── Stats.java
│           │   │   └── Ventilators
│           │   │       ├── Parete.java
│           │   │       ├── Piantana.java
│           │   │       ├── Soffitto.java
│           │   │       └── Ventilatore.java
│           │   ├── Main
│           │   │   ├── HelloController.java
│           │   │   └── MainFX.java
│           │   ├── View
│           │   │   ├── CenterPane.java
│           │   │   ├── LeftButtons.java
│           │   │   ├── MainGUI.java
│           │   │   ├── RightButtons.java
│           │   │   └── StatsPane.java
│           │   └── module-info.java
│           └── resources
│               └── org
│                   └── example
│                       └── onlyfans
│                           └── hello-view.fxml
├── Piastrelle
│   ├── .idea
│   │   ├── encodings.xml
│   │   ├── misc.xml
│   │   ├── uiDesigner.xml
│   │   └── vcs.xml
│   ├── .mvn
│   │   └── wrapper
│   │       ├── maven-wrapper.jar
│   │       └── maven-wrapper.properties
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   ├── View
│           │   │   ├── ButtonPane.java
│           │   │   ├── DataBase.java
│           │   │   ├── MainGUI.java
│           │   │   ├── Piastrella.java
│           │   │   ├── PiastrellaCerchio.java
│           │   │   ├── PiastrellaDettagliata.java
│           │   │   ├── PiastrellaPane.java
│           │   │   ├── PiastrellaQuadrato.java
│           │   │   └── TextPane.java
│           │   ├── com
│           │   │   └── piastrelle
│           │   │       ├── HelloApplication.java
│           │   │       └── HelloController.java
│           │   └── module-info.java
│           └── resources
│               └── com
│                   └── piastrelle
│                       └── hello-view.fxml
├── README.md
├── StreamThis
│   ├── .idea
│   │   ├── encodings.xml
│   │   ├── misc.xml
│   │   ├── uiDesigner.xml
│   │   └── vcs.xml
│   ├── .mvn
│   │   └── wrapper
│   │       ├── maven-wrapper.jar
│   │       └── maven-wrapper.properties
│   ├── StreamThis (1).pdf
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   ├── Controller
│           │   │   ├── ArchivioTitoli.java
│           │   │   ├── Titoli
│           │   │   │   ├── Anime.java
│           │   │   │   ├── Film.java
│           │   │   │   └── Serie.java
│           │   │   └── Titolo.java
│           │   ├── Main
│           │   │   ├── HelloController.java
│           │   │   └── MainFX.java
│           │   ├── View
│           │   │   ├── ButtonPane.java
│           │   │   ├── MainGUI.java
│           │   │   ├── RightPane.java
│           │   │   └── TitoliPane.java
│           │   └── module-info.java
│           └── resources
│               └── org
│                   └── example
│                       └── streamthis
│                           └── hello-view.fxml
├── a
│   └── a.txt
├── esami
│   ├── Soluzione_2018_06_15
│   │   ├── .idea
│   │   │   ├── compiler.xml
│   │   │   ├── encodings.xml
│   │   │   ├── jarRepositories.xml
│   │   │   ├── misc.xml
│   │   │   ├── uiDesigner.xml
│   │   │   ├── vcs.xml
│   │   │   └── workspace.xml
│   │   ├── .mvn
│   │   │   └── wrapper
│   │   │       ├── maven-wrapper.jar
│   │   │       └── maven-wrapper.properties
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   ├── src
│   │   │   └── main
│   │   │       ├── java
│   │   │       │   ├── Controller
│   │   │       │   │   └── MainGUI.java
│   │   │       │   ├── Model
│   │   │       │   │   ├── Cella.java
│   │   │       │   │   ├── Celle
│   │   │       │   │   │   ├── CellaBase.java
│   │   │       │   │   │   ├── CellaBoom.java
│   │   │       │   │   │   ├── CellaDivisore.java
│   │   │       │   │   │   └── CellaMoltiplicatore.java
│   │   │       │   │   └── Coordinate.java
│   │   │       │   ├── View
│   │   │       │   │   ├── CellePane.java
│   │   │       │   │   └── StatsPane.java
│   │   │       │   ├── module-info.java
│   │   │       │   └── org
│   │   │       │       └── example
│   │   │       │           └── soluzione_2018_06_15
│   │   │       │               ├── HelloController.java
│   │   │       │               └── MainFX.java
│   │   │       └── resources
│   │   │           └── org
│   │   │               └── example
│   │   │                   └── soluzione_2018_06_15
│   │   │                       └── hello-view.fxml
│   │   └── target
│   │       ├── classes
│   │       │   ├── Controller
│   │       │   │   └── MainGUI.class
│   │       │   ├── Model
│   │       │   │   ├── Cella.class
│   │       │   │   ├── Celle
│   │       │   │   │   ├── CellaBase.class
│   │       │   │   │   ├── CellaBoom.class
│   │       │   │   │   ├── CellaDivisore.class
│   │       │   │   │   └── CellaMoltiplicatore.class
│   │       │   │   └── Coordinate.class
│   │       │   ├── View
│   │       │   │   ├── CellePane.class
│   │       │   │   └── StatsPane.class
│   │       │   ├── module-info.class
│   │       │   └── org
│   │       │       └── example
│   │       │           └── soluzione_2018_06_15
│   │       │               ├── HelloController.class
│   │       │               ├── MainFX.class
│   │       │               └── hello-view.fxml
│   │       └── generated-sources
│   │           └── annotations
│   ├── Soluzione_2018_07_05
│   │   ├── .idea
│   │   │   ├── encodings.xml
│   │   │   ├── misc.xml
│   │   │   ├── uiDesigner.xml
│   │   │   └── vcs.xml
│   │   ├── .mvn
│   │   │   └── wrapper
│   │   │       ├── maven-wrapper.jar
│   │   │       └── maven-wrapper.properties
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           ├── java
│   │           │   ├── Controller
│   │           │   │   └── MainGUI.java
│   │           │   ├── Model
│   │           │   │   ├── Auto.java
│   │           │   │   ├── Autos
│   │           │   │   │   ├── Berlina.java
│   │           │   │   │   ├── Sportiva.java
│   │           │   │   │   └── Utilitaria.java
│   │           │   │   ├── Concessionaria.java
│   │           │   │   └── Enums
│   │           │   │       ├── Accessori.java
│   │           │   │       └── TipoMotore.java
│   │           │   ├── View
│   │           │   │   ├── ButtonPane.java
│   │           │   │   └── CarPane.java
│   │           │   ├── com
│   │           │   │   └── soluzione_2018_07_05
│   │           │   │       ├── HelloController.java
│   │           │   │       └── MainFX.java
│   │           │   └── module-info.java
│   │           └── resources
│   │               └── com
│   │                   └── soluzione_2018_07_05
│   │                       └── hello-view.fxml
│   ├── Soluzione_2018_09_11
│   │   ├── .idea
│   │   │   ├── encodings.xml
│   │   │   ├── misc.xml
│   │   │   ├── uiDesigner.xml
│   │   │   └── vcs.xml
│   │   ├── .mvn
│   │   │   └── wrapper
│   │   │       ├── maven-wrapper.jar
│   │   │       └── maven-wrapper.properties
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           ├── java
│   │           │   ├── Controller
│   │           │   │   └── MainGUI.java
│   │           │   ├── Model
│   │           │   │   ├── Carta.java
│   │           │   │   ├── Gioco.java
│   │           │   │   ├── Mano.java
│   │           │   │   ├── Mazzo.java
│   │           │   │   └── Semi.java
│   │           │   ├── View
│   │           │   │   ├── HandPane.java
│   │           │   │   └── PlayerPane.java
│   │           │   ├── module-info.java
│   │           │   └── org
│   │           │       └── example
│   │           │           └── soluzione_2018_09_11
│   │           │               ├── HelloController.java
│   │           │               └── MainFX.java
│   │           └── resources
│   │               └── org
│   │                   └── example
│   │                       └── soluzione_2018_09_11
│   │                           └── hello-view.fxml
│   ├── Soluzione_2019_01_18
│   │   ├── .idea
│   │   │   ├── encodings.xml
│   │   │   ├── misc.xml
│   │   │   ├── uiDesigner.xml
│   │   │   └── vcs.xml
│   │   ├── .mvn
│   │   │   └── wrapper
│   │   │       ├── maven-wrapper.jar
│   │   │       └── maven-wrapper.properties
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           ├── java
│   │           │   ├── Controller
│   │           │   │   └── MainGUI.java
│   │           │   ├── Model
│   │           │   │   ├── AlertDisplayer.java
│   │           │   │   ├── Griglia.java
│   │           │   │   ├── Tessera.java
│   │           │   │   └── Tessere
│   │           │   │       ├── TesseraInterface.java
│   │           │   │       ├── TesseraP.java
│   │           │   │       ├── TesseraS.java
│   │           │   │       └── TesseraV.java
│   │           │   ├── View
│   │           │   │   ├── ButtonPane.java
│   │           │   │   ├── GrigliaPane.java
│   │           │   │   └── StatsPane.java
│   │           │   ├── module-info.java
│   │           │   └── org
│   │           │       └── example
│   │           │           └── soluzione_2019_01_18
│   │           │               ├── HelloController.java
│   │           │               └── MainFX.java
│   │           └── resources
│   │               └── org
│   │                   └── example
│   │                       └── soluzione_2019_01_18
│   │                           └── hello-view.fxml
│   ├── Soluzione_2019_02_15
│   │   ├── .idea
│   │   │   ├── encodings.xml
│   │   │   ├── misc.xml
│   │   │   ├── uiDesigner.xml
│   │   │   └── vcs.xml
│   │   ├── .mvn
│   │   │   └── wrapper
│   │   │       ├── maven-wrapper.jar
│   │   │       └── maven-wrapper.properties
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           ├── java
│   │           │   ├── Controller
│   │           │   │   └── MainGUI.java
│   │           │   ├── Model
│   │           │   │   ├── AlertDisplayer.java
│   │           │   │   ├── ListaRecord.java
│   │           │   │   ├── Record.java
│   │           │   │   └── Records
│   │           │   │       ├── Automobile.java
│   │           │   │       └── Persona.java
│   │           │   ├── View
│   │           │   │   ├── Bottoni.java
│   │           │   │   ├── ButtonPane.java
│   │           │   │   ├── ContenitorePane.java
│   │           │   │   └── ListaRecordPane.java
│   │           │   ├── com
│   │           │   │   └── soluzione_2019_02_15
│   │           │   │       ├── HelloController.java
│   │           │   │       └── MainFX.java
│   │           │   └── module-info.java
│   │           └── resources
│   │               └── com
│   │                   └── soluzione_2019_02_15
│   │                       └── hello-view.fxml
│   ├── Soluzione_2019_06_19
│   │   ├── .idea
│   │   │   ├── encodings.xml
│   │   │   ├── misc.xml
│   │   │   ├── uiDesigner.xml
│   │   │   └── vcs.xml
│   │   ├── .mvn
│   │   │   └── wrapper
│   │   │       ├── maven-wrapper.jar
│   │   │       └── maven-wrapper.properties
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           ├── java
│   │           │   ├── Controller
│   │           │   │   ├── Bottoni.java
│   │           │   │   └── MainGUI.java
│   │           │   ├── Model
│   │           │   │   ├── Palestra.java
│   │           │   │   ├── Persona.java
│   │           │   │   └── Persone
│   │           │   │       ├── Atleta.java
│   │           │   │       ├── AtletaStudente.java
│   │           │   │       ├── SpecificPerson.java
│   │           │   │       └── Studente.java
│   │           │   ├── View
│   │           │   │   ├── CentralPane.java
│   │           │   │   └── TopPane.java
│   │           │   ├── module-info.java
│   │           │   └── org
│   │           │       └── example
│   │           │           └── soluzione_2019_06_19
│   │           │               ├── HelloController.java
│   │           │               └── MainFX.java
│   │           └── resources
│   │               └── org
│   │                   └── example
│   │                       └── soluzione_2019_06_19
│   │                           └── hello-view.fxml
│   ├── Soluzione_2019_07_26
│   │   ├── .idea
│   │   │   ├── encodings.xml
│   │   │   ├── misc.xml
│   │   │   ├── uiDesigner.xml
│   │   │   └── vcs.xml
│   │   ├── .mvn
│   │   │   └── wrapper
│   │   │       ├── maven-wrapper.jar
│   │   │       └── maven-wrapper.properties
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           ├── java
│   │           │   ├── Controller
│   │           │   │   ├── KeyHandler.java
│   │           │   │   └── MainGUI.java
│   │           │   ├── Model
│   │           │   │   ├── Coordinate.java
│   │           │   │   ├── Direzione.java
│   │           │   │   ├── Pallina.java
│   │           │   │   └── Palline
│   │           │   │       ├── Enemy.java
│   │           │   │       ├── Nemici
│   │           │   │       │   ├── Bubbler.java
│   │           │   │       │   ├── Striker.java
│   │           │   │       │   └── Wanderer.java
│   │           │   │       └── User.java
│   │           │   ├── View
│   │           │   │   └── StatsStage.java
│   │           │   ├── module-info.java
│   │           │   └── org
│   │           │       └── example
│   │           │           └── soluzione_2019_07_26
│   │           │               ├── HelloController.java
│   │           │               └── MainFX.java
│   │           └── resources
│   │               └── org
│   │                   └── example
│   │                       └── soluzione_2019_07_26
│   │                           └── hello-view.fxml
│   └── Soluzione_2019_09_06
│       ├── .idea
│       │   ├── encodings.xml
│       │   ├── misc.xml
│       │   ├── uiDesigner.xml
│       │   ├── vcs.xml
│       │   └── workspace.xml
│       ├── .mvn
│       │   └── wrapper
│       │       ├── maven-wrapper.jar
│       │       └── maven-wrapper.properties
│       ├── mvnw
│       ├── mvnw.cmd
│       ├── pom.xml
│       ├── src
│       │   └── main
│       │       ├── java
│       │       │   ├── Controller
│       │       │   │   ├── KeyHandler.java
│       │       │   │   └── MainGUI.java
│       │       │   ├── Model
│       │       │   │   ├── Coordinate.java
│       │       │   │   └── Figure
│       │       │   │       ├── Cerchio.java
│       │       │   │       ├── EmptyFigure.java
│       │       │   │       └── Triangolo.java
│       │       │   ├── View
│       │       │   │   ├── Bottoni
│       │       │   │   │   ├── Bottoni.java
│       │       │   │   │   └── BottoniPerGestire.java
│       │       │   │   ├── Casella.java
│       │       │   │   ├── Caselle
│       │       │   │   │   ├── CasellaDueBottoni.java
│       │       │   │   │   └── CasellaTreBottoni.java
│       │       │   │   └── ScacchieraPane.java
│       │       │   ├── com
│       │       │   │   └── soluzione_2019_09_06
│       │       │   │       ├── HelloController.java
│       │       │   │       └── MainFX.java
│       │       │   └── module-info.java
│       │       └── resources
│       │           └── com
│       │               └── soluzione_2019_09_06
│       │                   └── hello-view.fxml
│       └── target
│           └── classes
│               ├── Controller
│               │   ├── KeyHandler.class
│               │   └── MainGUI.class
│               ├── Model
│               │   ├── Coordinate.class
│               │   └── Figure
│               │       ├── Cerchio.class
│               │       ├── EmptyFigure.class
│               │       └── Triangolo.class
│               ├── View
│               │   ├── Bottoni
│               │   │   ├── Bottoni.class
│               │   │   └── BottoniPerGestire.class
│               │   ├── Casella.class
│               │   ├── Caselle
│               │   │   ├── CasellaDueBottoni.class
│               │   │   └── CasellaTreBottoni.class
│               │   └── ScacchieraPane.class
│               ├── com
│               │   └── soluzione_2019_09_06
│               │       ├── HelloController.class
│               │       ├── MainFX.class
│               │       └── hello-view.fxml
│               └── module-info.class
└── lab
    ├── .DS_Store
    ├── lab 1
    │   ├── .DS_Store
    │   ├── .idea
    │   │   ├── lab 1.iml
    │   │   ├── misc.xml
    │   │   ├── modules.xml
    │   │   └── vcs.xml
    │   ├── Lab1.iml
    │   ├── Lab1Istruzioni.txt
    │   ├── out
    │   │   └── production
    │   │       └── Lab1
    │   │           ├── Main
    │   │           │   └── Main.class
    │   │           └── data
    │   │               ├── AbstractBlock.class
    │   │               ├── AirBlock.class
    │   │               ├── Block.class
    │   │               └── Mappa.class
    │   └── src
    │       ├── Main
    │       │   └── Main.java
    │       └── data
    │           ├── AbstractBlock.java
    │           ├── AirBlock.java
    │           ├── Block.java
    │           ├── Mappa.java
    │           └── SandBlock.java
    ├── lab 2
    │   ├── .DS_Store
    │   ├── .idea
    │   │   ├── misc.xml
    │   │   ├── modules.xml
    │   │   ├── uiDesigner.xml
    │   │   └── vcs.xml
    │   ├── Lab1
    │   │   └── .idea
    │   │       └── workspace.xml
    │   ├── Lab1.iml
    │   ├── LabIstruzioni.txt
    │   ├── lab 2.iml
    │   ├── out
    │   │   └── production
    │   │       ├── Lab1
    │   │       │   ├── Main
    │   │       │   │   └── Main.class
    │   │       │   └── data
    │   │       │       ├── AbstractBlock.class
    │   │       │       ├── AirBlock.class
    │   │       │       ├── Block.class
    │   │       │       └── Mappa.class
    │   │       └── lab 2
    │   │           ├── Main
    │   │           │   └── Main.class
    │   │           ├── data
    │   │           │   ├── Factory.class
    │   │           │   └── blocks
    │   │           │       ├── AbstractBlock.class
    │   │           │       ├── AirBlock.class
    │   │           │       ├── NullBlock.class
    │   │           │       ├── SandBlock.class
    │   │           │       ├── WaterBlock.class
    │   │           │       ├── interfaces
    │   │           │       │   ├── Block.class
    │   │           │       │   ├── IronSwordInterface.class
    │   │           │       │   └── SmeltableBlock.class
    │   │           │       └── solids
    │   │           │           ├── AbstractSolidBlock.class
    │   │           │           ├── GlassBlock.class
    │   │           │           ├── IronSwordBlock.class
    │   │           │           └── RawIronBlock.class
    │   │           ├── utils
    │   │           │   └── Coordinate.class
    │   │           └── visual
    │   │               ├── Furnace.class
    │   │               ├── MainView.class
    │   │               └── Mappa.class
    │   └── src
    │       ├── Main
    │       │   └── Main.java
    │       ├── data
    │       │   ├── Factory.java
    │       │   └── blocks
    │       │       ├── AbstractBlock.java
    │       │       ├── AirBlock.java
    │       │       ├── NullBlock.java
    │       │       ├── SandBlock.java
    │       │       ├── WaterBlock.java
    │       │       ├── interfaces
    │       │       │   ├── Block.java
    │       │       │   ├── IronSwordInterface.java
    │       │       │   └── SmeltableBlock.java
    │       │       └── solids
    │       │           ├── AbstractSolidBlock.java
    │       │           ├── GlassBlock.java
    │       │           ├── IronSwordBlock.java
    │       │           └── RawIronBlock.java
    │       ├── utils
    │       │   └── Coordinate.java
    │       └── visual
    │           ├── Furnace.java
    │           ├── MainView.java
    │           └── Mappa.java
    ├── lab 3
    │   ├── .DS_Store
    │   ├── .idea
    │   │   ├── misc.xml
    │   │   ├── modules.xml
    │   │   ├── uiDesigner.xml
    │   │   └── vcs.xml
    │   ├── Lab1
    │   │   └── .idea
    │   │       └── workspace.xml
    │   ├── Lab1.iml
    │   ├── LabIstruzioni.txt
    │   ├── lab 2.iml
    │   ├── out
    │   │   └── production
    │   │       ├── Lab1
    │   │       │   ├── Main
    │   │       │   │   └── Main.class
    │   │       │   └── data
    │   │       │       ├── AbstractBlock.class
    │   │       │       ├── AirBlock.class
    │   │       │       ├── Block.class
    │   │       │       └── Mappa.class
    │   │       └── lab 2
    │   │           ├── Main
    │   │           │   └── Main.class
    │   │           ├── data
    │   │           │   ├── Factory.class
    │   │           │   └── blocks
    │   │           │       ├── AbstractBlock.class
    │   │           │       ├── AirBlock.class
    │   │           │       ├── NullBlock.class
    │   │           │       ├── SandBlock.class
    │   │           │       ├── WaterBlock.class
    │   │           │       ├── interfaces
    │   │           │       │   ├── Block.class
    │   │           │       │   ├── CheckIndex.class
    │   │           │       │   ├── DustBlock.class
    │   │           │       │   ├── InventoryBlock.class
    │   │           │       │   ├── IronSwordInterface.class
    │   │           │       │   └── SmeltableBlock.class
    │   │           │       ├── solids
    │   │           │       │   ├── AbstractSolidBlock.class
    │   │           │       │   ├── GlassBlock.class
    │   │           │       │   ├── IronSwordBlock.class
    │   │           │       │   ├── RawIronBlock.class
    │   │           │       │   └── TorchBlock.class
    │   │           │       └── utils
    │   │           │           ├── AlphabeticalBlockComparator.class
    │   │           │           └── BlockComparator.class
    │   │           ├── utils
    │   │           │   ├── BlockErrorException.class
    │   │           │   ├── Coordinate.class
    │   │           │   └── WrongCoordinatesException.class
    │   │           └── visual
    │   │               ├── Furnace.class
    │   │               ├── Inventario.class
    │   │               ├── MainView.class
    │   │               └── Mappa.class
    │   └── src
    │       ├── Main
    │       │   └── Main.java
    │       ├── data
    │       │   ├── Factory.java
    │       │   └── blocks
    │       │       ├── AbstractBlock.java
    │       │       ├── AirBlock.java
    │       │       ├── NullBlock.java
    │       │       ├── SandBlock.java
    │       │       ├── WaterBlock.java
    │       │       ├── interfaces
    │       │       │   ├── Block.java
    │       │       │   ├── CheckIndex.java
    │       │       │   ├── DustBlock.java
    │       │       │   ├── InventoryBlock.java
    │       │       │   ├── IronSwordInterface.java
    │       │       │   └── SmeltableBlock.java
    │       │       ├── solids
    │       │       │   ├── AbstractSolidBlock.java
    │       │       │   ├── GlassBlock.java
    │       │       │   ├── IronSwordBlock.java
    │       │       │   ├── RawIronBlock.java
    │       │       │   └── TorchBlock.java
    │       │       └── utils
    │       │           ├── AlphabeticalBlockComparator.java
    │       │           └── BlockComparator.java
    │       ├── utils
    │       │   ├── BlockErrorException.java
    │       │   ├── Coordinate.java
    │       │   └── WrongCoordinatesException.java
    │       └── visual
    │           ├── Furnace.java
    │           ├── Inventario.java
    │           ├── MainView.java
    │           └── Mappa.java
    └── lab4
        ├── .DS_Store
        ├── .idea
        │   ├── libraries
        │   │   └── bio_singa_javafx.xml
        │   ├── misc.xml
        │   ├── modules.xml
        │   ├── uiDesigner.xml
        │   └── vcs.xml
        ├── Lab1
        │   └── .idea
        │       └── workspace.xml
        ├── Lab1.iml
        ├── LabIstruzioni.txt
        ├── lab 2.iml
        ├── out
        │   └── production
        │       ├── Lab1
        │       │   ├── Main
        │       │   │   └── Main.class
        │       │   └── data
        │       │       ├── AbstractBlock.class
        │       │       ├── AirBlock.class
        │       │       ├── Block.class
        │       │       └── Mappa.class
        │       └── lab 2
        │           ├── Main
        │           │   ├── Main.class
        │           │   └── MainFX.class
        │           ├── data
        │           │   ├── Factory.class
        │           │   └── blocks
        │           │       ├── AbstractBlock.class
        │           │       ├── AirBlock.class
        │           │       ├── NullBlock.class
        │           │       ├── SandBlock.class
        │           │       ├── WaterBlock.class
        │           │       ├── interfaces
        │           │       │   ├── Block.class
        │           │       │   ├── CheckIndex.class
        │           │       │   ├── DustBlock.class
        │           │       │   ├── InventoryBlock.class
        │           │       │   ├── IronSwordInterface.class
        │           │       │   └── SmeltableBlock.class
        │           │       ├── solids
        │           │       │   ├── AbstractSolidBlock.class
        │           │       │   ├── GlassBlock.class
        │           │       │   ├── IronSwordBlock.class
        │           │       │   ├── RawIronBlock.class
        │           │       │   └── TorchBlock.class
        │           │       └── utils
        │           │           ├── AlphabeticalBlockComparator.class
        │           │           └── BlockComparator.class
        │           ├── utils
        │           │   ├── BlockErrorException.class
        │           │   ├── Coordinate.class
        │           │   └── WrongCoordinatesException.class
        │           └── visual
        │               ├── GUI
        │               │   ├── BlockPane.class
        │               │   ├── ButtonListPane$1.class
        │               │   ├── ButtonListPane$2.class
        │               │   ├── ButtonListPane$3.class
        │               │   ├── ButtonListPane$4.class
        │               │   ├── ButtonListPane$5.class
        │               │   ├── ButtonListPane.class
        │               │   ├── FurnacePane.class
        │               │   ├── InventoryPane.class
        │               │   ├── MainGUI.class
        │               │   └── MapPane.class
        │               └── textual
        │                   ├── Furnace.class
        │                   ├── Inventario.class
        │                   ├── MainView.class
        │                   └── Mappa.class
        └── src
            ├── Main
            │   ├── Main.java
            │   └── MainFX.java
            ├── data
            │   ├── Factory.java
            │   └── blocks
            │       ├── AbstractBlock.java
            │       ├── AirBlock.java
            │       ├── NullBlock.java
            │       ├── SandBlock.java
            │       ├── WaterBlock.java
            │       ├── interfaces
            │       │   ├── Block.java
            │       │   ├── CheckIndex.java
            │       │   ├── DustBlock.java
            │       │   ├── InventoryBlock.java
            │       │   ├── IronSwordInterface.java
            │       │   └── SmeltableBlock.java
            │       ├── solids
            │       │   ├── AbstractSolidBlock.java
            │       │   ├── GlassBlock.java
            │       │   ├── IronSwordBlock.java
            │       │   ├── RawIronBlock.java
            │       │   └── TorchBlock.java
            │       └── utils
            │           ├── AlphabeticalBlockComparator.java
            │           └── BlockComparator.java
            ├── utils
            │   ├── BlockErrorException.java
            │   ├── Coordinate.java
            │   └── WrongCoordinatesException.java
            └── visual
                ├── GUI
                │   ├── BlockPane.java
                │   ├── ButtonListPane.java
                │   ├── FurnacePane.java
                │   ├── InventoryPane.java
                │   ├── MainGUI.java
                │   └── MapPane.java
                └── textual
                    ├── Furnace.java
                    ├── Inventario.java
                    ├── MainView.java
                    └── Mappa.java
```
