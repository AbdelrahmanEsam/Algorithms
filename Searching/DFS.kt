private fun ArrayList<ArrayList<Int>>.recursiveDFS(vertex : Int,visited : BooleanArray)
{
     visited[vertex] = true
    // manipulate the vertex here

    var neighbour: Int
    repeat(this[vertex].size) {index ->

        neighbour= this[vertex][index]
        if (!visited[neighbour]) recursiveDFS(neighbour,visited)
    }

}



private fun ArrayList<ArrayList<Int>>.iterativeDFS(vertices:Int,root:Int)
{

    val nodes = BooleanArray(vertices)

    val stack: Stack<Int> = Stack()

    stack.push(root)

    var neighbour: Int
    while (stack.isNotEmpty())
    {
        val top = stack.peek()
        stack.pop()

        if (!nodes[top])
        {
            // manipulate the vertex here
            nodes[top] = true
        }

        repeat(this[top].size) {index ->
            neighbour= this[top][index]
            if (!nodes[top]) {          // push the neighbours to the stack
            stack.push(neighbour)
            }
        }
    }
}
