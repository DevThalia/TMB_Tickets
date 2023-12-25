fun main() {
    var stillShop:Boolean
    var ticketsAdded=0
    do {
        val userOption = mainMenuOpcions()//funcion que muestra el menú principal y devuelve el userOption
        val userZone = zoneMenu()
        val priceTicket = calculatePricePerTicket(userOption, userZone)
        println(priceTicket)
        stillShop=stillShooping()
        ticketsAdded++//counts tickets so that the limit for user is 3
    }while (stillShop&&ticketsAdded<3)
    endOfProgramMessage()
}
