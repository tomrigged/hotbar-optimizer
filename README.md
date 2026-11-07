# TomaxMC Hotbar optimizer (Fabric, client-side)

Haalt de vertraging weg als je van hotbar-slot wisselt: het nieuwe item staat meteen in je hand,
zonder de zak-en-opkom-animatie. Werkt alleen aan de clientkant, dus ook op servers bruikbaar.

Gemaakt voor Minecraft 1.21.11 (Fabric, Java 21, Yarn-mappings).

## Bouwen

Dit zipje bevat geen Gradle wrapper. Kies een van deze twee manieren:

**Optie A (makkelijkst)**
1. Ga naar https://fabricmc.net/develop/template en genereer een template voor Minecraft 1.21.11
   (Java 21, Yarn-mappings, geen extra opties nodig). Pak die uit.
2. Kopieer de map `src/main/java/nl/tomaxmc` en de twee bestanden in `src/main/resources`
   uit dit project naar het template (vervang de bestaande `fabric.mod.json`).
3. Gebruik de versies uit het template als de versies in `gradle.properties` niet meer kloppen.

**Optie B**
1. Installeer Gradle en Java 21.
2. Voer in deze map `gradle wrapper` uit.
3. Controleer de versies in `gradle.properties` op https://fabricmc.net/develop.

Daarna bouwen met:

```
./gradlew build        (Windows: gradlew.bat build)
```

De mod staat dan in `build/libs/tomaxmc-hotbar-optimizer-1.0.0.jar`. Zet die in je `mods`-map
samen met Fabric API.

## Let op

- Dit is niet getest. Als de build klaagt over `HeldItemRenderer` of een van de velden in
  `HeldItemRendererMixin.java`, dan heten die in jouw versie net anders.
- Door deze mod zakt je item ook niet meer weg direct na een aanval (vanilla doet dat door de
  aanvalscooldown).
