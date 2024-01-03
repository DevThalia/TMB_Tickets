import kotlin.math.absoluteValue

/**
 *function that asks user for their option, prints options, validates data and returns the option
 * @author Thalia2603
 * @since 04/01/2024
 * @return userOption value of option
 */
fun optionMenu():Int{
    var userOption=readIntMenu( BLUE_BOLD_BRIGHT+"Quin bitllet desitja adquirir?"+RESET +
            "\n1 - Bitllet senzill" +
            "\n2 - TCasual" +
            "\n3 - TUsual" +
            "\n4 - TFamiliar" +
            "\n5 - TJove",
        pMin = 1, pMax = 5)
    return userOption
}
/**
 *This method prints menu of zones, validates user input and returns user's chosen zone
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @return userZoneInput value of the zone user chooses
 */
fun zoneMenu():Int{
    val userZoneInput=readIntMenu(BLUE_BOLD_BRIGHT+"A quina zona vol viatjar?"+RESET+"\n1\n2\n3",1, 3)
    return userZoneInput
}
/**
 *This method gets the base price of ticket, adds the zone price increment to the base price , and returns the final sum of ticket
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @param pUserOption value of ticket option
 * @param pZone value of the zone
 * @return priceFinal final price of ticket (with decimals)
 */
fun calculatePricePerTicket(pUserOption:Int ,pZone:Int):Float{
    val basePrice=getBasePriceTicket(pUserOption)
    val priceFinal=addZonePrice(basePrice, pZone)
    return priceFinal
}
/**
 *This method gets the base price of the ticket chosen by user from an array that contains all prices
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @param pUserOption value of ticket option
 * @return basePriceTicket base price of ticket
 */
fun getBasePriceTicket(pUserOption:Int):Float{
    var stilShoppingBoolean=false
    val pricesPerOption= floatArrayOf(2.40f,11.35f,40.00f,10.00f,80.00f)
    val basePriceTicket=(pricesPerOption[pUserOption-1])//this makes pUserOption match the index of ticket in pricesPerOption, so we get the base price from array
    return basePriceTicket
}
/**
*This method asks the user if they want to continue shopping (si/no) and returns boolean
* @author Thalia2603, annacano0
* @since 04/01/2024
* @return stillShopBoolean true/false
*/
fun stillShooping():Boolean{
    var stillShopBoolean=readStringSiNo(BLUE_BOLD_BRIGHT+"Vol continuar comprant?"+RESET+" (Si/No)")
    return stillShopBoolean
}
/**
 *This adds zone supplement to the base price of ticket and returns final price
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @param pBasePrice base price of ticket
 * @param pZone zone chosen by user
 * @return finalPriceTicket final sum of price for ticket
 */
fun addZonePrice(pBasePrice:Float, pZone:Int):Float{
    
    var finalPriceTicket=pBasePrice//initial price doesn't change if zone==1
    if (pZone==3){
        finalPriceTicket=(finalPriceTicket*1.8443).round(2)//if zone is 3, the price is multiplied by 1.8443 to get total
    }
    else if (pZone==2){
        finalPriceTicket=(finalPriceTicket*1.3125).round(2)//if zone is 2, the price is multiplied by 1.3125 to get total
    }
    return (finalPriceTicket)
}
/**
 *This method adds the ticket options chosen by user to three mutable lists, organized by ticket names, ticket zones, ticket prices.
 * This will make the data more manageable
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @param pUserOption value of ticket chosen (later transformed to name)
 * @param pUserZone value of ticket zone
 * @param pUserPrice value of ticket price
 * @param pNames MutableList with all ticket names
 * @param pZones MutableList with all ticket zones
 * @param pPrices MutableList with all ticket prices
 */
fun addUserOptionToReceipt(pUserOption:Int,
                           pUserZone:Int,
                           pUserPrice:Float,
                           pNames:MutableList<String>,
                           pZones:MutableList<Int>,
                           pPrices:MutableList<Float>){
    val ticketNamesList=arrayOf("Bitllet Senzill", "TCasual", "TUsual", "TFamiliar","TJove")//array of names for options of ticket, ordered same as in menu
    val ticketName=ticketNamesList[pUserOption-1]//we get the ticket name from the array using index
    //we add the user ticket to the mutable lists
    pNames.add(ticketName)
    pZones.add(pUserZone)
    pPrices.add(pUserPrice)
}
/**
 *This method gets all the options added by user to the three ticket lists and prints them with the format of a receipt (message)
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @param pNames MutableList with all ticket names
 * @param pZones MutableList with all ticket zones
 * @param pPrices MutableList with all ticket prices
 */
fun printTicketLists(pNames:MutableList<String>, pZones:MutableList<Int>, pPrices:MutableList<Float>){
    var printTicket=readStringSiNo(BLUE_BOLD_BRIGHT+"Desitja tiquet?"+RESET+" (Si/No)")//ask user if the want ticket and validate input to return Boolean
    if (printTicket){
        println(BLUE_BRIGHT+"___________TIQUET__________")
        for (i in 0..pNames.size-1){
            println(pNames[i]+" Zona "+pZones[i]+ " - Preu: "+ pPrices[i]+"€")//prints all added tickets with their respective zone and price (receipt format)
        }
        println("___________________________"+RESET)
    }
}

/**
 *This method prints message with the price of the added ticket
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @param pPrice price of added (current) ticket
 */
fun printAddedTicket(pPrice:Float){
    println("El preu del bitllet és "+pPrice+"€")
}

/**
 *This function manages the payment of the tickets, first counts the total,then asks user to confirm purchase, and if purchase=true, then
 *asks user for valid input of money, and does so until payment is finished and "returns" the change.
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @param pPrices list of all the ticket prices
 * @return confirmPurchase returns if user has confirmed or cancelled purchase
 */
fun payment(pPrices:MutableList<Float>):Boolean{
    var totalPayment=totalPrices(pPrices)//sums total of prices
    var confirmPurchase=readStringSiNo(BLUE_BOLD_BRIGHT+"Confirma la seva compra?"+RESET+" (Si/No)")//option that allows user to cancel purchase, returns true/false
    if (confirmPurchase){
        println("Introdueixi bitllets o monedes vàlids d'EURO")
        do {
            var userMoney=checkMoney()//money is cheked to see if the value inserted by user exixts. if it doesn't userMoney==0f
            totalPayment-=userMoney//money inserted is substracted from totalPayment
            if (totalPayment>0){//if payment is not completed it will ask user to keep inserting money
                ///TODO: hacer que devuelva dos decimales siempre (he intentado con .round(2) pero no acaba de ir
                println("Ha introduït  "+userMoney+"€ li resta per pagar "+(totalPayment.toDouble().round(2))+"€")
            }
        }while (totalPayment>0)
        ///TODO: hacer que devuelva dos decimales siempre (he intentado con .round(2) pero no acaba de ir
        if (totalPayment<0) println("Reculli el seu bitllet i el seu canvi: "+(totalPayment.toDouble().round(2).absoluteValue)+"€")//returns the change (extra money inserted that reflects as negative value in totalPayment)
    }
    return confirmPurchase
}
/**
 *This sums all the prices of ticket, prints message informing user of num of tickets and final amount and returns final amount to pay
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @param list of all the ticket prices
 * @return totalPayment sum of all ticket prices
 */
fun totalPrices(pPrices:MutableList<Float>):Float{
    var totalPayment=0.00f
    for (i in 0..pPrices.size-1){
        totalPayment+=pPrices[i]
    }
    println("Ha comprat "+pPrices.size+" bitllet/s, ha de pagar "+(totalPayment.toDouble().round(2))+"€")//we round the sum to two decimals
    return totalPayment
}
/**
 *This method validates the input (via readFloat) of money from user.then checks if input exists, if input is not a valid curency it returns 0.
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @return money Value of valid money
 */
fun checkMoney():Float{
    var money=0.0f
    money=readFloat()
    if (money!=50f&&money!=20f&&money!=10f&&money!=5f&&money!=2f &&money!=1f&&money!=0.5f&&money!=0.2f&&money!=0.1f&&money!=0.05f&&money!=0.02f&&money!=0.01f){
        money=0.00f
    }
    return money
}
