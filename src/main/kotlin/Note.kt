import java.util.Scanner

//Заметка
class Note(var name: String, var parent: Archive) : ContentItem {
    var content: String = ""

    init {
        println("Введите многострочный текст заметки. Пустая строка будет означать конец заметки")
        while (true) {
            addContent()
            if (content.isEmpty()) println("Содержимое заметки не может быть пустым, введите текст")
            else break
        }
    }

    override fun open() {
        println("Заметка \"${name}\":\n${content}")
        println("Введите строку для добавления к заметке, пустую строку для возврата к списку заметок")
        addContent()
        parent.open()
    }

    private fun addContent() {
        while (true) {
            val newLine = Scanner(System.`in`).nextLine()
            if (newLine.isEmpty()) break
            if (!content.isEmpty()) content += "\n"
            content += newLine
        }
    }
}