# Ogo - JabberPoint

Youri Tapper ***Studentnummer*** 5076315

# Strategie

1. Alle lessen volgen
2. Een ClassenDiagram maken van het huidige systeem.
3. Onderzoeken wat JabberPoint precies doet
4. Met de debugger door de code heen
5. Kijken op https://refactoring.guru/ voor suggesties voor wijzigingen.

# Veranderingen

1. Met behulp van intellij alle dode code verwijderd en een automatische format erover heen gegooid zodat ik de code
   beter kon lezen.
2. Uit de `Style` class heb ik de functies `createStyles` deze heb ik verplaatst naar de `StyleFactory`
   Omdat deze een nieuwe instantie van zichzelf aanmaakt en dat hoort niet.
3. Alle `exit()` functies naar de `JabberPoint` class verplaatst omdat ik vind dat als je een applicatie wilt afsluiten
   dit op 1 centrale duidelijke plek moet gebeuren
4. Verplaats het laden/opslaan van de presentatie naar een factory ipv de `JabberPoint` main functie omdat jabber point
   dat niet alle maal moet regelen alleen dat die geladen word hoe maakt JabberPoint niks uit
5. Probleem navigatie naar onbekende pagina opgelost met de `goto` knop, dit was een simpele fout die opgelost moest
   worden
6. Alle `Accessors` & `Items` verplaatst naar een package zodat deze duidelijk bij elkaar staan en het makkelijker word
   om een
   nieuwe toe te voegen zonder het overzicht te verliezen
7. Uit de `MenuController` class de functie `createMenuItem` omdat ik vind dat dit door een Factory moet gebeuren.
8. Uit de `MenuController` de logica weggehaald voor het aanmaken van een nieuw `Menu` deze verplaatst naar
   de `MenuFactory`