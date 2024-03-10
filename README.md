# Programbeskrivning
Programmet tar in ett identifikationsnummer som argument. Det numret kontrolleras sedan som personnummer, samordningsnummer och organisationsnummer. Om numret klarar alla kontroller för ett nummer skrivs detta ut. Annars skrivs de kontroller som inte klarades ut. 

## Beskrivning av scriptet run.bash
Detta skript läser varje rad från filen `testdata.txt` och kör programmet med varje rad som ett separat argument. Scriptet tar alltså inga argument utan läser från en textfil istället. Kör scriptet med: 
```bash
./run.bash