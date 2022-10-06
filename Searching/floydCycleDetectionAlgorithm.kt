fun main(args: Array<String>) {
val nums = readInts()
val (head,tail) = createLinkedList(nums)
    var next = head
    val isCircular = isCircular(head,tail)
    if (isCircular.first)
    {
        println("circular")
        println("entry "+getTheEntryPointOfTheCycle(head,isCircular.second)?.value)
    }
    else println("not circular")







}


data class Node(var next : Node? = null,val value : Int)

private fun createLinkedList(array : IntArray) : Pair<Node?,Node?>
{

    if (array.isEmpty()) { return Pair(null,null)}
    val head = Node( value = array[0])
    var tail = head

    for (  i in  1 until array.size)
    {
            tail.next = Node(value = array[i])
            tail = tail.next!!
    }
    tail.next = head

return Pair(head,tail)
}



 fun isCircular(head: Node?, tail: Node?) : Pair<Boolean,Node?>
{
    var hare : Node? = head?.next
    var tortoise : Node? = head

    while (hare != null && tortoise != null)
    {

        if (hare.value == tortoise.value)
        {
            tail?.next = hare
            return Pair(true,hare)
        }

        tortoise = tortoise.next

        if(hare.next == null) return Pair(false,null)

        hare = hare.next?.next
    }

    return Pair(false,null)


}

fun getTheEntryPointOfTheCycle(head : Node? , hareNode : Node?) : Node?
{

    var tortoise = head
    var hare = hareNode


    while ( tortoise?.value != hare?.value)
    {
        tortoise = tortoise?.next
        hare = hare?.next
    }

    return hare
}













fun readInt() = readLine()!!.toInt()
fun readInts() = readLine()!!.split(" ").map(String::toInt).toIntArray()
















