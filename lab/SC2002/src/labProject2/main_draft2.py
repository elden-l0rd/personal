from matplotlib import colors
import matplotlib.pyplot as plt
import seaborn as sns
import sys
import heapq
import random
from timeit import default_timer as timer
import networkx as nx
from collections import defaultdict


def minWeight(w, SS,vertices):
    min=sys.maxsize
    for i in range(0,vertices):
        if (SS[i]==False and w[i]<=min):
            min=w[i]
            min_index = i
    return min_index

def dijkstraMatrix(g,src, vertices):
    g1 = nx.adjacency_matrix(g)
    d=[vertices]
    S=[vertices]

    for i in range(0,vertices):
        d[i] = sys.maxsize
        S[i] = False
    d[src]=0
    for i in range(0,vertices-1):
        u = minWeight(d,S, vertices)
        S[u]=True
        for j in range(0,vertices):
            if (not S[j] and g1[u][j] and d[u]!=sys.maxsize and d[u]+g1[u][j]<d[j]):
                d[j] = d[u]+g1[u][j]
    return


def dijkstraList(g, src):
    # stored arr of adjLists && minimising heap for priority queue
    list = convert_to_list(g)
    d={}
    pq=[]
    for v in list:
        d[v] = sys.maxsize
    d[src]=0

    for v in list:
        heapq.heappush(pq, (v, d[v]))
    while len(pq)>0:
        curr, currW = heapq.heappop(pq)
        for neighbour in list[curr]:
            weight=list[curr][neighbour]
            dist = currW+weight
            if dist<d[neighbour]:
                d[neighbour]=dist
                heapq.heappush(pq, (neighbour, dist))
    return


## Generate random GRAPH ##
# generateMatrix()
def generateMatrix(vertices):
    p = 1.0/vertices
    g = nx.gnp_random_graph(vertices,p,seed=False)
    for (u,v) in g.edges():
        g.edges[u,v]['weight'] = random.randint(1,100) #adding value of weights
    return g
    

# matrix_to_list()
def convert_to_list(graph):
    L = defaultdict(list)
    for i in range(len(graph)):
        for j in range(len(graph[i])):
                       if graph[i][j]<sys.maxsize:
                           L[i].append(j)
    return L

def main():
    cputimeMatrix = []
    cputimeList = []
    for i in range(100): # number of test cases
        vertices = random.randint(1,100) # number of vertices
        # generate a graph -> run with dijkstraMatrix() and dijkstraList()
        g = generateMatrix(vertices)
        #dataMatrix = np.zeros(vertices,vertices)
        tmp=.0
        for i in range(5): # repeat expt 5times -> take ave
            start = timer()
            dijkstraMatrix(g,0, vertices)
            tmp+=timer()-start
        cputimeMatrix.append(tmp/5.0)
        tmp=.0
        for i in range(5):
            start = timer()
            dijkstraList(g,0)
            tmp+=timer()-start
        cputimeList.append(tmp/5.0)
        #dataMatrix = g
        


    # heatmap ==> cpuMatrix-cpuList vs graphDensity vs numberVertices #
    divnorm  = colors.TwoSlopeNorm(vcenter=0.)
    ax = sns.heatmap(dataMatrix, linewidths=0, cmap='seismic', norm=divnorm)
    plt.xlabel("no. of Vertices, |V|")
    plt.ylabel("graphDensity, D")
    plt.title("Comparing graph density and running time")
    plt.show()


if __name__ == "__main__":
    main()