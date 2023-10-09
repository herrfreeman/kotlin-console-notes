//Архив (список заметок)
class Archive(var parent: ListOfArchivesScreen) : ContentItem, ConsoleScreen<Note>() {

    init {
        contentList.add(("Добавить заметку" to ContentItem { addContentItem() }) as Pair<String, Note>)
        contentList.add(("Выход" to ContentItem { parent.open()}) as Pair<String, Note>)
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