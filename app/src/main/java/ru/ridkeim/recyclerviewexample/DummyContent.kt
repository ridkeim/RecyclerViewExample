package ru.ridkeim.recyclerviewexample

object DummyContent {
    val items : MutableList<DummyItem> = ArrayList()
    private val symbolsRange = (65..122)
    private val lengthRange = (10..25)
    private var count = 40
    init {
        val intRange = 0..5
        for (i in 1..count){
            val dummyItem =
                DummyItem(i, "Item #$i", createRandomString(lengthRange.random()), intRange.random())
            items.add(dummyItem)
        }
    }

    private fun createRandomString(size : Int): String{
        val stringBuilder = StringBuilder()
        for(i in (0..size)){
            stringBuilder.append(symbolsRange.random().toChar())
        }
        return stringBuilder.toString()
    }
}