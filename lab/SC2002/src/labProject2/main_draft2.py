from this import d
from matplotlib import colors
import matplotlib.pyplot as plt
import seaborn as sns
import sys
import heapq
import random
import numpy as np
import pandas as pd
import networkx as nx
from collections import defaultdict
from scipy import sparse as scp
from timeit import default_timer as timer


def minWeight(w, SS,vertices):
    min=sys.maxsize
    for i in range(vertices):
        if (SS[i]==False and w[i]<=min):
            min=w[i]
            min_index = i
    return min_index

def dijkstraMatrix(g, src, vertices):
    g1 = scp.csr_matrix(nx.adjacency_matrix(g)) #converts into 2D matrix
    d=[v for v in range(vertices)]
    S=[v for v in range(vertices)]

    for i in range(vertices):
        d[i] = sys.maxsize
        S[i] = False
    d[src]=0
    for i in range(vertices):
        u = minWeight(d,S, vertices)
        S[u]=True
        for j in range(vertices):
            if (S[j]==False and g1[u][j] and d[u]!=sys.maxsize and d[u]+g1[u][j]<d[j]):
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
    p = 0.35 # affects graph density
    g = nx.erdos_renyi_graph(vertices,p,seed=False)
    for (u,v) in g.edges():
        g.edges[u,v]['weight'] = random.randint(1,50) #adding value of weights
    #nx.draw(g, with_labels=True)
    #plt.show()
    return g
    

# matrix_to_list()
def convert_to_list(graph):
    L = defaultdict(list)
    for i in range(len(graph)):
        for j in range(len(graph[i])):
                       if graph[i][j]!=0:
                           L[i].append(j)
    return L

def main():
    cputimeMatrix = []
    cputimeList = []
    cpu = []
    d = []
    for i in range(100): # number of test cases
        vertices = random.randint(1,100) # number of vertices
        # generate a graph -> run with dijkstraMatrix() and dijkstraList()
        g = generateMatrix(vertices)
        d.append(nx.density(g))
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

    for i in range(100):
        cpu[i] = cputimeMatrix[i]-cputimeList[i]
    y = np.array(d)
    z = np.array(cpu)
    df = pd.DataFrame({"y":y, "z":z})
    df.to_csv("data.csv", index=False)

"""
    # heatmap ==> cpuMatrix-cpuList vs graphDensity vs numberVertices #
    divnorm  = colors.TwoSlopeNorm(vcenter=0.)
    df2 = pd.read_csv(??)
    ax = sns.heatmap(df2, linewidths=0, cmap='seismic', norm=divnorm)
    plt.xlabel("no. of Vertices, |V|")
    plt.ylabel("graphDensity, D")
    plt.title("Comparing graph density and running time")
    plt.show()"""


if __name__ == "__main__":
    main()