fun main() {
    var stillShop:Boolean
    var ticketsAdded=0
    val ticketNames=mutableListOf<String>()
    val ticketZones=mutableListOf<Int>()
    val ticketPrices=mutableListOf<Float>()
    do {
        val userOption = mainMenuOpcions()//funcion que muestra el menú principal y devuelve el userOption
        val userZone = zoneMenu()
        val priceTicket = calculatePricePerTicket(userOption, userZone)
        ticketsAdded++//counts tickets so that the limit for user is 3
        printAddedTicket(priceTicket)
        addUserOptionToReceipt(userOption,userZone,priceTicket, ticketNames, ticketZones, ticketPrices)
        stillShop=stillShooping()
    }while (stillShop&&ticketsAdded<3)
    payment(ticketPrices)
    printTicketLists(ticketNames, ticketZones, ticketPrices)
    endOfProgramMessage()
}
