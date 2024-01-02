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
        userOption=readIntMenu( pMin = 1, pMax = 5)
    }while (userOption!in 1..5)
    return userOption
}
fun zoneMenu():Int{
    println("A quina zona vol viatjar?\n1\n2\n3")
    val userZoneInput=readIntMenu(1, 3)
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
    var stillShopBoolean=readStringSiNo("Vols seguir comprant? (si/no)")
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
    //we add the user ticket to the mutable lists
    pNames.add(ticketName)
    pZones.add(pUserZone)
    pPrices.add(pUserPrice)
}

fun printTicketLists(pNames:MutableList<String>, pZones:MutableList<Int>, pPrices:MutableList<Float>){
    var printTicket=readStringSiNo("Desitja tiquet? (si/no)")
    if (printTicket){
        println("___________TIQUET__________")
        for (i in 0..pNames.size-1){
            println(pNames[i]+" Zona "+pZones[i]+ " - Preu: "+ pPrices[i]+"€")//printa todos los tiquets añadidos a las listas mutables
        }
        println("___________________________")
    }

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
fun showMoneyMenu(){
    println("----------------------------")
    println("Sel.leccioni amb què vol pagar")
    println("1 - 50€")
    println("2 - 20€")
    println("3 - 10€")
    println("4 - 5€")
    println("5 - 2€")
    println("6 - 1€")
    println("7 - 0.50€")
    println("8 - 0.20€")
    println("9 - 0.10€")
    println("10 - 0.05€")
}

fun moneyMenuOptions(listOfMoney: MutableList<Int>):MutableList<Int>{
    showMoneyMenu()
    var option: Int
    do {
        println("Amb què pagarà (introdueixi 0 per sortir): ")
        option =readIntMenu( pMin = 1, pMax = 5, "El valor inserit no es valid", "El valor inserit no es una opcio")

        if (option != 0) {
            listOfMoney.add(option)
        }
    } while (option != 0)
    return listOfMoney
}

fun priceTransform(listOfMoney:MutableList<Int>):Double{
    val price=0
    var sumPrice=0.0
    for (i in listOfMoney){
        when (listOfMoney[i]){
            1 -> price==50
            2 -> price==20
            3 -> price==10
            4 -> price==5
            5 -> price==2
            6 -> price==1
            7 -> price.toDouble() ==0.50
            8 -> price.toDouble() ==0.20
            9 -> price.toDouble() ==0.10
            10 -> price.toDouble() ==0.05
        }
        sumPrice+=price
    }
    return sumPrice.toDouble()
}

fun change(sumPrice:Double,totalPayment:Float){
    val priceReturn=totalPayment-sumPrice
    println("El seu canvi és de $priceReturn")
}