# Run with: python edmonds_karp.py
# Edmonds-Karp Algorithm (BFS-based Ford-Fulkerson) to find Max Flow in a directed graph

from collections import deque, defaultdict

def bfs(capacity, residual, source, sink, parent):
    visited = set()
    queue = deque([source])
    visited.add(source)

    while queue:
        u = queue.popleft()
        for v in capacity[u]:
            if v not in visited and residual[u][v] > 0:
                parent[v] = u
                visited.add(v)
                if v == sink:
                    return True
                queue.append(v)
    return False

def edmonds_karp(graph, source, sink):
    capacity = defaultdict(dict)
    residual = defaultdict(dict)

    # Initialize capacities and residual graph
    for u in graph:
        for v in graph[u]:
            capacity[u][v] = graph[u][v]
            residual[u][v] = graph[u][v]
            residual[v][u] = 0  # reverse edge

    parent = {}
    max_flow = 0
    flow_paths = []

    while bfs(capacity, residual, source, sink, parent):
        # Find minimum residual capacity in the path found
        path_flow = float('inf')
        s = sink
        path = []

        while s != source:
            path.insert(0, s)
            u = parent[s]
            path_flow = min(path_flow, residual[u][s])
            s = u
        path.insert(0, source)

        # Update residual capacities
        v = sink
        while v != source:
            u = parent[v]
            residual[u][v] -= path_flow
            residual[v][u] += path_flow
            v = u

        max_flow += path_flow
        flow_paths.append((path, path_flow))

    return max_flow, flow_paths

# 🔍 Example Usage
if __name__ == "__main__":
    # Example directed graph with capacities
    graph = {
        'S': {'A': 10, 'C': 10},
        'A': {'B': 4, 'C': 2},
        'C': {'D': 9},
        'B': {'T': 10},
        'D': {'B': 6, 'T': 10},
        'T': {}
    }

    source = 'S'
    sink = 'T'
    max_flow, paths = edmonds_karp(graph, source, sink)

    print(f"\n💧 Maximum Flow: {max_flow}")
    print("📊 Flow Paths:")
    for p, f in paths:
        print(f"Path: {' -> '.join(p)}, Flow: {f}")
