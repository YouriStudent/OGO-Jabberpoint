# Ogo - JabberPoint

Youri Tapper
Studentnummer: 5076315

# Strategie

1. Alle lessen volgen
2. Een ClassenDiagram maken van het huidige systeem.
3. Onderzoeken wat JabberPoint precies doet
4. Met de debugger door de code heen
5. Kijken op https://refactoring.guru/ voor suggesties voor wijzigingen.

# Veranderingen

1. Met behulp van intellij alle dode code verwijderd en een automatische format erover heen gegooid zodat ik de code
   beter kon lezen.
2. Uit de Style class heb ik de functies `createStyles` deze heb ik verplaatst naar de `StyleFactory`
   Omdat deze een nieuwe instantie van zichzelf aanmaakt en dat hoort niet.
3. Alle `exit()` functies naar de `JabberPoint` class verplaatst omdat ik vind dat als je een applicatie wilt afsluiten
   dit op 1 centrale duidelijke plek moet gebeuren
4. Verplaats het laden/opslaan van de presentatie en 

MenuController formated multiple functions to lamda for more readability

Style.java -> create_styles to factory and move the generation to presentation

Moved exit button from Presentation to jabberpoint

Controls of presentatie in SlideController

controllers naar controller package
