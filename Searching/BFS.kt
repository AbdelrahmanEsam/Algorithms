private fun ArrayList<ArrayList<Int>>.iterativeBFS(vertices:Int,root:Int)
{
    val queue: Queue<Int> = LinkedList()
   val  visited  = BooleanArray(vertices)

    visited[root] = true
    queue.add(root)
    var neighbour: Int
    while (queue.isNotEmpty())
    {
        val top = queue.poll()

        // manipulate the vertex here
        repeat(this[top].size) { index ->
            neighbour= this[top][index]
            if (!visited[neighbour] )
            {
                visited[neighbour] = true
                queue.add(neighbour)  //add the neighbours to the queue
            }
        }
    }
}
