fun main()
{
    val inputArr = readInts()

    var maxTillNow = 0
    var maxEver = Int.MIN_VALUE
    var firstIndex = 0
    var lastIndex = 0

    for (i in inputArr.indices)
    {

        maxTillNow += inputArr[i]
        if (maxTillNow < inputArr[i])
        {
            maxTillNow = inputArr[i]
            firstIndex = i
            lastIndex = i

        }

        if (maxEver < maxTillNow)
        {
            maxEver = maxTillNow

            lastIndex = i

        }
    }
    println("$maxEver $firstIndex $lastIndex")


}


fun readInt() = readLine()!!.toInt()
fun readInts() = readLine()!!.split(" ").map(String::toInt).toIntArray()
