//Список архивов
class ListOfArchivesScreen() : ContentItem, ConsoleScreen() {

    init {
        contentList.add(("Добавить архив" to ContentItem { addContentItem() }))
        contentList.add(("Выход" to ContentItem { }))
    }

    override fun open() {
        println("Архивы:")
        run() //вызывает item.open()
    }

    override fun addContentItem() {
        val newItemName = scanNewItemName()
        contentList.add(contentList.lastIndex, newItemName to Archive(this))
        open()
    }

}