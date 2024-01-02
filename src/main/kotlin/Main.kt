fun main() {
    ///TODO: hacer que el programa sea un bucle infinito y (opcional) que se pare si un operario introduce: 4321
    var secretCode=false
    do {
        startOfProgramMessage()
        var stillShop:Boolean
        var ticketsAdded=0
        val ticketNames=mutableListOf<String>()
        val ticketZones=mutableListOf<Int>()
        val ticketPrices=mutableListOf<Float>()
        do {
            val userOption = mainMenuOpcions()//funcion que muestra el menú principal y devuelve el userOption
            val userZone = zoneMenu()
            val priceTicket = calculatePricePerTicket(userOption, userZone)
            ticketsAdded++//counts tickets so that the limit for purchase is 3
            printAddedTicket(priceTicket)
            addUserOptionToReceipt(userOption,userZone,priceTicket, ticketNames, ticketZones, ticketPrices)
            stillShop=stillShooping()
        }while (stillShop&&ticketsAdded<3)
        payment(ticketPrices)
        printTicketLists(ticketNames, ticketZones, ticketPrices)
        endOfProgramMessage()
    }while (!secretCode)

}
