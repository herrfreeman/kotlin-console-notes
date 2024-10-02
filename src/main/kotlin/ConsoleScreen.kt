import java.util.Scanner

fun interface ContentItem {
    fun open()
}

//Реализует хранение, вывод меню, выбор пункта меню, ввод непустого названия
abstract class ConsoleScreen() {

    //val contentList: MutableList<Pair<String,T>> = mutableListOf()
    val contentList: MutableList<Pair<String,ContentItem>> = mutableListOf()
    /*
    Для хранения использовал пары - Наименование пункта, пункт меню
    Пары выглядят не особо красиво, но:
    нужен и текст и дейтсвие, если сделать класс, то не получится в качестве действия назначить лямбды
    если сделать только интерфейс, то негде сохранить название
    */


    abstract fun addContentItem()

    fun showItemList() {
        var itemIndex = 0
        for ((name, ) in contentList) println("${itemIndex++}. ${name}")
    }

    fun scanNewItemName(): String {
        println("Введите название")
        while (true) {
            val newItemName: String = Scanner(System.`in`).nextLine()
            if (newItemName.isEmpty()) {
                println("Название не может быть пустым")
            } else {
                return newItemName
            }
        }
    }

    fun run() {

        while (true) {
            showItemList()
            println("Введите номер пункта меню")

            val command = Scanner(System.`in`).nextLine()
            if (command.isEmpty()) {
                println("Вы ввели пустую строку, введите число")
            } else {
                var intReady = true
                for (ch in command) {
                    if(!ch.isDigit()) {
                        intReady = false
                        break
                    }
                }
                if (intReady) {
                    val commandNumber = command.toInt()
                    if (commandNumber in contentList.indices) {
                        contentList[commandNumber].second.open()
                        break
                    } else {
                        println("Нет такого пункта меню, введите другое число")
                    }
                } else {
                    println("Введено не число, введите число")
                }
            }
        }
    }
}


