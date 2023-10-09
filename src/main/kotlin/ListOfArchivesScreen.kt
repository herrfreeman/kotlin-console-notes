class ListOfArchivesScreen() : ContentItem, ConsoleScreen<Archive>() {

    init {
        contentList.add(("Добавить архив" to ContentItem { addContentItem() }) as Pair<String, Archive>)
        contentList.add(("Выход" to ContentItem { }) as Pair<String, Archive>)
    }

    override fun open() {
        println("Архивы:")
        showItemList()
        run() //вызывает item.open()
    }

    override fun addContentItem() {
        val newItemName = scanNewItemName()
        contentList.add(contentList.lastIndex, newItemName to Archive(this))
        open()
    }

}