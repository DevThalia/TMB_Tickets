# PROGRAMA TMB M03

Programa desenvolupat en Kotlin que es dedica a gestionar la venda de bitllets de Transport Metropolità de Barcelona (TMB). Desenvolupat per Thalia Bravo i Anna Cano.

## Descripció General

El programa utilitza un bucle infinit que només s'atura si un operari introdueix el codi secret "4321". En cada iteració, l'usuari pot comprar fins a tres bitllets de diferents opcions.

## Funcions Principals

### `main()`

La funció principal del programa, que inicia un bucle infinit. Mostra un missatge de benvinguda, sol·licita les opcions de compra a l'usuari i gestiona el procés de compra i pagament de bitllets. El bucle s'atura si s'introdueix el codi secret.

### `startOfProgramMessage()`

Mostra un missatge de benvinguda a l'inici de cada iteració del programa.

### `endOfProgramMessage()`

Mostra un missatge d'acomiadament al final de cada iteració del programa.

### `mainMenuOpcions()`

Sol·licita a l'usuari l'opció de compra de bitllets mostrant un menú. Retorna l'opció seleccionada.

### `zoneMenu()`

Sol·licita a l'usuari la zona a la qual vol viatjar. Mostra les opcions i retorna la zona seleccionada.

### `calculatePricePerTicket(pUserOption, pZone)`

Calcula el preu final d'un bitllet sumant el preu base i el suplement de zona.

### `getBasePriceTicket(pUserOption)`

Obté el preu base del bitllet seleccionat per l'usuari a partir d'una matriu de preus.

### `stillShooping()`

Pregunta a l'usuari si vol seguir comprant i retorna un valor booleà.

### `addZonePrice(pBasePrice, pZone)`

Afegeix el suplement de zona al preu base del bitllet i retorna el preu final.

### `addUserOptionToReceipt(pUserOption, pUserZone, pUserPrice, pNames, pZones, pPrices)`

Afegeix les opcions de bitllets triades per l'usuari a llistes mudables organitzades per noms, zones i preus.

### `printTicketLists(pNames, pZones, pPrices)`

Imprimeix un rebut amb les opcions de bitllets seleccionades per l'usuari.

### `printAddedTicket(pPrice)`

Imprimeix un missatge amb el preu del bitllet afegit.

### `payment(pPrices)`

Gestiona el procés de pagament, demanant a l'usuari introduir diners fins a completar el pagament total. Retorna el canvi.

### `checkMoney()`

Valida l'entrada de diners de l'usuari, assegurant-se que sigui una moneda vàlida.

### `AsciiArt()`

Imprimeix art ASCII en color blau a l'inici del programa.

## Funcions Auxiliars

### Funcions d'Entrada de Dades

Es proporcionen diverses funcions (`readWord`, `readSentence`, `readChar`, `readBoolean`, `readInt`, `readIntRange`, `readFloat`) per llegir diferents tipus de dades de l'usuari.

### Funcions de Missatges d'Error

`messageErrorDT` i `messageErrorRange` imprimeixen missatges d'error quan s'introdueix un tipus de dada incorrecte o un valor fora de l'abast, respectivament.

## Colors ASCII

S'utilitzen codis ASCII per imprimir text en colors (blau, vermell, groc) en algunes funcions.

