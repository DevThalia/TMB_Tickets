fun AsciiArt(){
    print(RED_BOLD)
    println(
            "                             \n" +
            "         ███████████         \n" +
            "       ███████████████       \n" +
            "     ███████████████████     \n" +
            "    █████████████████████    \n" +
            "   ███████████████████████   \n" +
            "  ███      █ ▀██▀ █   █████  \n" +
            "  █████  ███      █ ▀ █████  \n" +
            "  █████  ███  ██  █ ▄  ████  \n" +
            "  █████  ███  ██  █    ████  \n" +
            "   ███████████████████████   \n" +
            "    █████████████████████    \n" +
            "     ███████████████████     \n" +
            "       ███████████████       \n" +
            "         ███████████         \n" +
            "                             \n" +
            "                             ")
            print(RESET)
}

fun startOfProgramMessage(){
    AsciiArt()
    println(BLUE_BOLD_BRIGHT+"----------------------------")
    println("       ¡Benvolgut/da        ")
    println("----------------------------"+RESET)
}
fun endOfProgramMessage(){
    println(BLUE_BOLD_BRIGHT+"        ¡Bon Viatge!        "+RESET)
}

fun messageErrorDT(){
    //funcion que es llamada cuando el tipo de dato es incorrecto
    println(RED_BOLD+"El tipus de dada es incorrecte, torni a intentar."+RESET)
}

fun messageErrorRange(){
    //funcion que es llamada cuando el tipo de dato esta fuera del rango establecido
    println(YELLOW_BOLD+"El tipus de dada no està en les opcions, torni a intentar."+RESET)
}