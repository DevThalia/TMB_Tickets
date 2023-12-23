fun main() {
    var stillShop:Boolean
    do {
        val userOption = mainMenuOpcions()//funcion que muestra el menú principal y devuelve el userOption
        val userZone = zoneMenu()
        val priceTicket = calculatePricePerTicket(userOption, userZone)
        println(priceTicket)
        stillShop=stilShooping()
    }while (stillShop)
}
