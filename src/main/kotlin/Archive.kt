//Архив (список заметок)
class Archive(var parent: ListOfArchivesScreen) : ContentItem, ConsoleScreen() {

    init {
        contentList.add(("Добавить заметку" to ContentItem { addContentItem() }))
        contentList.add(("Выход" to ContentItem { parent.open()}))
    }

    override fun open() {
        println("Список заметок:")
        run() //вызывает в итоге item.open()
    }

    override fun addContentItem() {
        val newItemName = scanNewItemName()
        contentList.add(contentList.lastIndex, newItemName to Note(newItemName, this))
        open()
    }

}