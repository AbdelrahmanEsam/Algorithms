class Prim
{
    private fun <T> addAvailableEdge(
        vertex: Graph.Vertex<T>, graph: AdjacencyList<T>,
        visited: Set<Graph.Vertex<T>>, priorityQueue: PriorityQueue<Graph.Edge<T>>)
    {

        graph.edges(vertex).forEach { edge ->
            if (edge.destination !in visited) {
                priorityQueue.add(edge)
            }
        }
    }

     fun <T> getMinimumSpanningTree(graph: AdjacencyList<T>) : Pair<Double,AdjacencyList<T>>
    {

        var cost = 0.0
        val mst = AdjacencyList<T>()
        val visited = mutableSetOf<Graph.Vertex<T>>()

        val comparator = Comparator<Graph.Edge<T>> { first,second->
           val firstWeight = first.weight ?: 0.0
            val secondWeight = second.weight ?: 0.0
            (firstWeight -secondWeight ).roundToInt()
        }

        val edgePriorityQueue = PriorityQueue(comparator)

        mst.copyVertices(graph)

        val start =  graph.vertices.firstOrNull() ?: return Pair(cost,mst)
        visited.add(start)
        addAvailableEdge(start,graph,visited, edgePriorityQueue)

        while (true)
        {
            val bestRoute = edgePriorityQueue.poll() ?: break

            if (visited.contains(bestRoute.destination)) continue
            cost+= bestRoute.weight?:0.0
            visited.add(bestRoute.destination)

            mst.add(Graph.EdgeType.UNDIRECTED,bestRoute.source,bestRoute.destination,bestRoute.weight)
            addAvailableEdge(bestRoute.destination,graph,visited, edgePriorityQueue)
        }

   return Pair(cost,mst)
    }

}
