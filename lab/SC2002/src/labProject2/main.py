from matplotlib import colors
import matplotlib.pyplot as plt
import seaborn as sns
import sys
import heapq
import os
import random
import numpy as np
from timeit import default_timer as timer


def minWeight(dist)


def minDistance(self, dist, sptSet):

    min = sys.maxsize

    for u in range(self.V):
        if dist[u] < min and sptSet[u] == False:
            min = dist[u]
            min_index = u

    return min_index

def dijkstraAdj(g,)

def dijkstra(vertices, src):

    dist = [sys.maxsize] * self.V
    dist[src] = 0
    sptSet = [False] * self.V

    for cout in range(self.V):
        x = self.minDistance(dist, sptSet)

        sptSet[x] = True

        for y in range(self.V):
            if self.graph[x][y] > 0 and sptSet[y] == False and \
                    dist[y] > dist[x] + self.graph[x][y]:
                dist[y] = dist[x] + self.graph[x][y]

    self.printSolution(dist)



# minWeight()

# dijkstraMatrix()
def dijkstraList(g, vertices):
    list = convert_to_list(g, vertices)
    #implement heapSort()


## Generate STRONGLY CONNECTED GRAPH ##
# generateMatrix()
def generateMatrix(vertices):
    M = np.zeros(vertices,vertices)
    #initialise matrix
    for i in range(vertices):
        for j in range(vertices):
            value = random.choice([random.randint(1,100), sys.maxsize]) #weight of nodes
            M[i][j] = value       #    ^either an int or infinity    #
            M[j][i] = value
            M[i][i] = M[j][j] =0
    return M

# matrix_to_list()
def convert_to_list(g,vertices):
    #initisliase list
    L = [[0 for i in range(vertices)] for j in range(vertices)]
    for i in range(vertices):
        for j in range(vertices):
            if ((g[i][j]!= (0 or sys.maxsize)) and g[i][j]==g[[j][i]]):
                L[i][j].append(j)
    return L

if __name__ == "__main":
    cputimeMatrix = []
    cputimeList = []
    for i in range(100): # number of test cases
        vertices = random.randint(1,100) # number of vertices
        g = generateMatrix(vertices)
        dataMatrix = np.zeros(vertices,vertices)
        start = timer()
        dijkstraMatrix(g,vertices)
        cputimeMatrix.append(timer()-start)
        start = timer()
        dijkstraList(g,vertices)
        cputimeList.append(timer()-start)
        dataMatrix = g
        

    

    # heatmap ==> cpuMatrix-cpuList vs graphDensity vs numberVertices #
    divnorm  = colors.TwoSlopeNorm(vcenter=0.)
    ax = sns.heatmap(dataMatrix, linewidths=0, cmap='seismic', norm=divnorm)
    plt.xlabel("no. of Vertices, |V|")
    plt.ylabel("graphDensity, D")
    plt.show()