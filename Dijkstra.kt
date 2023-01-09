class Dijkstra<T>(private val graph : AdjacencyList<T>)
{
private fun route(destination: Graph.Vertex<T>, paths:HashMap<Graph.Vertex<T>,Visit<T>>) : ArrayList<Graph.Edge<T>>
{
    var vertex = destination
    val path = arrayListOf<Graph.Edge<T>>()

    loop@ while (true)
    {
        val visit = paths[vertex] ?: break

        when(visit.type)
        {
            VisitType.START -> break@loop
            VisitType.EDGE -> {
                visit.edge?.let {
                    path.add(it)
                    vertex = it.source
                }
            }
        }
    }
    return  path
}

    private fun  distance(destination:Graph.Vertex<T>,paths:HashMap<Graph.Vertex<T>,Visit<T>>) : Double
    {
        val path = route(destination,paths)
        return path.sumByDouble { it.weight ?: 0.0 }
    }

    fun shortestPath(source : Graph.Vertex<T>) : HashMap<Graph.Vertex<T>,Visit<T>>
    {
        val paths : HashMap<Graph.Vertex<T>,Visit<T>> =  HashMap()
        paths[source] = Visit(type = VisitType.START)


        val distanceComparator = Comparator<Graph.Vertex<T>> { first, second ->
            (distance(second, paths) - distance(first, paths)).toInt()
        }

        val priorityQueue  = PriorityQueue(distanceComparator)
        priorityQueue.add(source)

        while (true)
        {
            val vertex = priorityQueue.poll() ?: break
            val edges = graph.edges(vertex)

            edges.forEach {
                val weight = it.weight ?: 0.0

                if (paths[it.destination] == null || distance(vertex,paths)+weight < distance(it.destination,paths))
                {
                    // if the destination vertex isn't visited yet or if you had a new path is better than the previous one

                    paths[it.destination] = Visit(VisitType.EDGE,it)
                    priorityQueue.add(it.destination)
                }
            }
        }

     return paths
    }


    fun shortestPath(destination: Graph.Vertex<T>, paths: HashMap<Graph.Vertex<T>, Visit<T>>): ArrayList<Graph.Edge<T>>
    {
        return route(destination, paths)
    }

    class Visit<T>(val type:VisitType,val edge: Graph.Edge<T>?= null)

    enum class VisitType
    { START,EDGE }
    
}
