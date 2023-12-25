fun showMenu(){
    println("----------------------------")
    println("Quin bitllet desitza adquirir?")
    println("1 - Bitllet senzill")
    println("2 - TCasual")
    println("3 - TUsual")
    println("4 - TFamiliar")
    println("5 - TJove")
}
/*function that reads USEROPTION and according to the value redirect to another function*/
fun mainMenuOpcions():Int{
    var userOption=0
    do{
        showMenu()
        userOption=readIntMenu( pMin = 1, pMax = 5, "El valor inserit no es valid", "El valor inserit no es una opcio")
    }while (userOption!in 1..5)
    return userOption
}
fun zoneMenu():Int{
    println("A quina zona vol viatjar?\n1\n2\n3")
    val userZoneInput=readIntMenu(1, 3,"El valor inserit no es valid",
        "El valor no es una opció de Zona",)
    return userZoneInput
}

fun calculatePricePerTicket(pUserOption:Int ,pZone:Int):Float{
    val basePrice=calculateBasePriceTicket(pUserOption)
    val priceFinal=addZonePrice(basePrice, pZone)
    return priceFinal
}
fun calculateBasePriceTicket(pUserOption:Int):Float{
    var stilShoppingBoolean=false
    val pricesPerOption= floatArrayOf(2.40f,11.35f,40.00f,10.00f,80.00f)
    val basePriceTicket=(pricesPerOption[pUserOption-1])
    return basePriceTicket
}
fun stillShooping():Boolean{
    var stillShopBoolean=readStringSiNo("Vols seguir comprant? (si/no)","Valor introduit no vàlid", "Valor no es una opció")
    return stillShopBoolean
}
fun addZonePrice(pBasePrice:Float, pZone:Int):Float{
    var finalPriceTicket=pBasePrice
    if (pZone==3){
        finalPriceTicket=(finalPriceTicket*1.8443).round(2)
    }
    else if (pZone==2){
        finalPriceTicket=(finalPriceTicket*1.3125).round(2)
    }
    return (finalPriceTicket)
}

fun addUserOptionToReceipt(pUserOption:Int, pUserZone:Int, pTicketPrice:Float){
    //create three dif. mutable lists so that the length of the receipt isn't strict and data stays organized
    val listTicketName:MutableList<Int> =mutableListOf()
    val listTicketZone:MutableList<Int> =mutableListOf()
    val listTicketPrice:MutableList<Float> =mutableListOf()

    listTicketName.add(pUserOption)
    listTicketZone.add(pUserZone)
    listTicketPrice.add(pTicketPrice)

}

fun printTicketLists(){
    ///TODO:funcion al que se le pasaran las listas como parametro y luego imprimira el contenido en formato ticket
}

fun endOfProgramMessage(){
    printTicketLists()
    println("----------------------------")
    println("    Reculli el seu tiquet.  ")
    println("        ¡Bon Viatge!        ")
    println("----------------------------")
}