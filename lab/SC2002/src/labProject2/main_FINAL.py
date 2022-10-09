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
    start=timer()
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
    return timer()-start


def dijkstraList(g, src, vertices):
    # stored arr of adjLists && minimising heap for priority queue
    list = convert_to_list(g, vertices)
    start=timer()
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
    
    return timer()-start


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
    TEST_CASE=150
    cputimeMatrix = []
    cputimeList = []
    cpu = []
    d = []
    ver = []
    for i in range(TEST_CASE): # number of test cases
        for prob in np.arange(0.35,0.95,0.1): #value of p
            if (prob==(0 or 1)): # probability must be nonzero and <1
                prob-=0.1
                continue
            vertices = random.randint(10,1000) # number of vertices
            ver.append(vertices)
            
        # generate a graph -> run with dijkstraMatrix() and dijkstraList()
            g = generateMatrix(vertices, prob)
            d.append(nx.density(g))
            tmp=.0
            for expt in range(3): #repeat experiment 3 times and take ave
                tmp+=dijkstraMatrix(g, 0, vertices)
            cputimeMatrix.append(tmp/3.0)
            tmp=.0
            for expt in range(3):
                tmp+=dijkstraList(g, 0, vertices)
            cputimeList.append(tmp/3.0)

    # end of data collection
    for i in range(TEST_CASE*6):
        cpu.append(cputimeMatrix[i] - cputimeList[i])

    x = np.array(ver).astype(float)
    y = np.array(d).astype(float)
    z = np.array(cpu).astype(float)
    
    df = pd.DataFrame.from_dict(np.array([x,y,z]).T)
    df.columns = ['|V|', 'density', 'cputime']
    df['cputime'] = pd.to_numeric(df['cputime'])
    M = df.pivot_table('cputime', 'density', '|V|')
    divnorm = colors.TwoSlopeNorm(vcenter=0.)
    sns.heatmap(M, cmap="seismic", norm=divnorm, annot=False, cbar=True, linewidths=0, square=True)
    plt.figure(figsize=(5,28))
    plt.show()


if __name__ == "__main__":
    main()