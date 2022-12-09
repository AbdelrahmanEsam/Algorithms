    fun KMPSearch(pattern : String ,text : String)
   {

       var k = 0
       val longestPrefix = text.failureFunction()
        text.forEachIndexed { index, charText ->

            while (k > 0 && pattern[k] != charText) k = longestPrefix[k-1]

            if (pattern[k] == charText) k++

            if (k == pattern.length) {
                println(index - pattern.length + 1)
                k = longestPrefix[k - 1]
            }

        }


   }


fun String.failureFunction() : Array<Int>
{

    var k = 0
    val longestPrefix:Array<Int> = Array(this.length){0}
    for (i in 1 until this.length)
    {
        while (k > 0 && this[k] != this[i]) k = longestPrefix[k-1]

        longestPrefix[i] = if (this[k] == this[i])  k++ else  k
    }

return  longestPrefix
}
