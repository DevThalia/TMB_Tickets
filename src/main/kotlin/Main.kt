fun main() {
    ///TODO: program is infinite until secret code (4321) is typed
    var secretCode=false
    do {
        startOfProgramMessage()
        var stillShop:Boolean=false
        var ticketsAdded=0//counts num of tickets being added
        val ticketNames=mutableListOf<String>()//saves added ticket names
        val ticketZones=mutableListOf<Int>()//saves added ticket zones
        val ticketPrices=mutableListOf<Float>()//saves added ticket prices
        do {
            val userOption = optionMenu()//function that prints menu of ticket options and returns value for ticket chosen by user
            val userZone = zoneMenu()//function that prints menu of zone options and returns zone chosen by user
            val priceTicket = calculatePricePerTicket(userOption, userZone)
            ticketsAdded++//adds ticket
            printAddedTicket(priceTicket)
            addUserOptionToReceipt(userOption,userZone,priceTicket, ticketNames, ticketZones, ticketPrices)//adds values to their respective lists
            if (ticketsAdded!=3) stillShop=stillShooping()//if user hasn't reached limit of tickets, asks user if they want to continue shopping
        }while (stillShop&&ticketsAdded<3)//if user wants to continue shopping and tickets is less than 3, it will iterate
        var printTicket=payment(ticketPrices)//if user confirms purchase in payment(), then final receipt is printed
        if (printTicket) printTicketLists(ticketNames, ticketZones, ticketPrices)
        endOfProgramMessage()
    }while (!secretCode)
}
