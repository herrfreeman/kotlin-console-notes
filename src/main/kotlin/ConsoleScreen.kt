import java.util.Scanner

abstract class ConsoleScreen<T: ContentItem> () {

    val contentList: MutableList<Pair<String,T>> = mutableListOf()

    /*init {

        contentList.add(object : ContentItem("Add") {
            override fun open() { addContentItem() }
        } as T)

        contentList.add(object : ContentItem("Exit") {
            override fun open() { }
        } as T)
    }*/

//    fun show() {
//        var itemIndex = 0
//        for (item in contentList) println("${itemIndex++}. ${item}")
//    }

    fun showItemList() {
        var itemIndex = 0
        for ((name, item) in contentList) println("${itemIndex++}. ${name}")
    }


    abstract fun addContentItem()

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
        println("Введите номер пункта меню")
        while (true) {
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

fun interface ContentItem {
    fun open()
}
