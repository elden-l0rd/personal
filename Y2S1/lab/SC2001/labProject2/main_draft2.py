import matplotlib.pyplot as plt
import seaborn as sns
import sys
import heapq
import random
import numpy as np
import networkx as nx
from collections import defaultdict
from scipy import sparse as scp
from scipy import stats
from timeit import default_timer as timer


def minWeight(w, SS,vertices):
    min=sys.maxsize
    for i in range(vertices):
        if (SS[i]==False and w[i]<=min):
            min=w[i]
            min_index = i
    return min_index

def dijkstraMatrix(g, src, vertices):
    g1 = scp.csr_matrix.toarray(nx.adjacency_matrix(g)) #converts into 2D matrix
    d=[sys.maxsize]*vertices
    S=[False]*vertices
    pq = []
    pq.append(src)
    d[src]=0
    while (pq):
        u = minWeight(d,S,vertices) # return index of smallest node
        pq.remove(u)
        S[u]=True
        for j in range(vertices):
            if (S[j]==False and g1[u][j] and d[u]+g1[u][j]<d[j]):
                if j not in pq:
                    pq.append(j)
                #pq.pop(j)
                d[j] = d[u]+g1[u][j]
    return


def dijkstraList(g, src, vertices):
    # stored arr of adjLists && minimising heap for priority queue
    list = convert_to_list(g, vertices)
    d=[sys.maxsize]*vertices
    pq=[]
    d[src]=0

    for v in list:
        heapq.heappush(pq, (v, d[v]))
    heapq.heapify(pq)

    while (len(pq)):
        curr, currW = heapq.heappop(pq)
        for neighbour in range(len(list[curr])):
            weight=list[curr][neighbour]
            dist = currW+weight
            if dist<d[neighbour]:
                d[neighbour]=dist
                heapq.heappush(pq, (neighbour, dist))
        heapq.heapify(pq)
    return


## Generate random GRAPH ##
def generateMatrix(vertices, prob):
    # p affects graph density
    g = nx.erdos_renyi_graph(vertices,prob,seed=False)
    for (u,v) in g.edges():
        g.edges[u,v]['weight'] = random.randint(1,50) #adding value of weights
    #nx.draw(g, with_labels=True)
    #plt.show()
    return g
    

# matrix_to_list()
def convert_to_list(graph, vertices):
    tmp = scp.csr_matrix.toarray(nx.adjacency_matrix(graph))
    L = defaultdict(list)
    for i in range(vertices):
        for j in range(vertices):
                       if tmp[i][j]!=0:
                           L[i].append(j)
    return L

def main():
    cputimeMatrix = []
    cputimeList = []
    cpu = []
    d = []
    ver = []
    for i in range(1000): # number of test cases
        for prob in np.arange(0.4,0.95,0.1): #value of p
            if (prob==(0 or 1)):    # probability must be nonzero and <1
                prob-=0.2
                continue
            vertices = random.randint(2,100) # number of vertices
            ver.append(vertices)
        # generate a graph -> run with dijkstraMatrix() and dijkstraList()

            g = generateMatrix(vertices, prob)
            d.append(nx.density(g))
            tmp=.0
            for expt in range(5): #repeat experiment 5 times and take ave
                start = timer()
                dijkstraMatrix(g, 0, vertices)
                tmp+=timer()-start
            cputimeMatrix.append(tmp/5.0)
            tmp=.0
            for expt in range(5):
                start = timer()
                dijkstraList(g, 0, vertices)
                tmp+=timer()-start
            cputimeList.append(tmp/5.0)

    # end of data collection
    for i in range(1000*6):
        cpu.append(cputimeMatrix[i] - cputimeList[i])


    x = np.array(ver, dtype=float).astype(float)
    y = np.array(d, dtype=float).astype(float)
    z = np.array(cpu, dtype=float).astype(float)


    means = stats.binned_statistic_2d(x,
                                  y,
                                  values=z)[0]
    plt.figure(figsize=(10,8))
    plt.xlabel("no. of vertices, |V|")
    plt.ylabel("graphDensity, D")
    plt.title("Comparing graphDensity with running time")
    sns.heatmap(means,
                cmap="seismic",
                annot=True,
                annot_kws={"fontsize":16},
                cbar=True,
                linewidth=2,
                square=True)

    plt.show()


def testmain():
    g = generateMatrix(10, 0.92)
    g1 = convert_to_list(g,10)
    print(g1)



if __name__ == "__main__":
    main()
    #testmain()