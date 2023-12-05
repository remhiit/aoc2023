class Main

fun readFromResource(file: String): List<String> {
    return Main::class.java.getResource(file)?.readText()!!.split("\r\n").filter { it.isNotBlank() }
}
