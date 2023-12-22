fun main() {
    var numberTickets=0
    do {
        val userOption=mainMenuOpcions()//funcion que muestra el menú principal y devuelve el userOption
        val userZone=zoneMenu()
        val priceTicket=calculatePricePerTicket(userOption, userZone)
        addUserOptionToReceipt(userOption, userZone, priceTicket)
        numberTickets++
        printTickedInfo(numberTickets)
        var again=readStringSiNo("Vols seguir comprant? (Si/No)","Tipus de dada incorrecta","El valor no es Si/No")
    }while (again&&numberTickets!=3)

}
