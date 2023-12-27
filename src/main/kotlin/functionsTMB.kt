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

fun addUserOptionToReceipt(pUserOption:Int,
                           pUserZone:Int,
                           pUserPrice:Float,
                           pNames:MutableList<String>,
                           pZones:MutableList<Int>,
                           pPrices:MutableList<Float>){
    val ticketNamesList=arrayOf("Bitllet Senzill", "TCasual", "TUsual", "TFamiliar","TJove")
    val ticketName=ticketNamesList[pUserOption-1]

    pNames.add(ticketName)
    pZones.add(pUserZone)
    pPrices.add(pUserPrice)
}

fun printTicketLists(pNames:MutableList<String>, pZones:MutableList<Int>, pPrices:MutableList<Float>){
    println("___________TIQUET__________")
    for (i in 0..pNames.size-1){
        println(pNames[i]+" Zona "+pZones[i]+ " - Preu: "+ pPrices[i]+"€")
    }
    println("___________________________")
}

fun endOfProgramMessage(){
    println("    Reculli el seu tiquet.  ")
    println("        ¡Bon Viatge!        ")
}

fun printAddedTicket(pPrice:Float){
    println("El preu del bitllet es "+pPrice+"€")
}

fun payment(pPrices:MutableList<Float>){
    ///TODO:esat funcion gestionara el pago del billete. Seguramente se deberian crear otras funciones tipo
    ///change() o algo por el estilo
    var totalPayment=0.0f
    for (i in 0..pPrices.size-1){
        totalPayment+=pPrices[i]
    }
    println("Ha comprat "+pPrices.size+" bitllets, ha de pagar "+totalPayment+"€")

}