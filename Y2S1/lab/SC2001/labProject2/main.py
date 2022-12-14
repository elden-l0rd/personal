from matplotlib import colors
import matplotlib.pyplot as plt
import seaborn as sns
import sys
import heapq
import os
import random
import numpy as np
from timeit import default_timer as timer
import network


def minWeight()

#def dijkstraMatrix()
    # stored adjMatrix && arr for priority queue

def dijkstraList(g, vertices):
    # stored arr of adjLists && minimising heap for priority queue
    list = convert_to_list(g, vertices)
    # TODO: implement heapify()


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

def main():
    cputimeMatrix = []
    cputimeList = []
    for i in range(100): # number of test cases
        vertices = random.randint(1,100) # number of vertices
        # generate a graph -> run with dijkstraMatrix() and dijkstraList()
        g = generateMatrix(vertices)
        dataMatrix = np.zeros(vertices,vertices)
        tmp=.0
        for i in range(5): # repeat expt 5times -> take ave
            start = timer()
            dijkstraMatrix(g,vertices)
            tmp+=timer()-start
        cputimeMatrix.append(tmp/5.0)
        tmp=.0
        for i in range(5):
            start = timer()
            dijkstraList(g,vertices)
            tmp+=timer()-start
        cputimeList.append(tmp/5.0)
        dataMatrix = g
        


    # heatmap ==> cpuMatrix-cpuList vs graphDensity vs numberVertices #
    divnorm  = colors.TwoSlopeNorm(vcenter=0.)
    ax = sns.heatmap(dataMatrix, linewidths=0, cmap='seismic', norm=divnorm)
    plt.xlabel("no. of Vertices, |V|")
    plt.ylabel("graphDensity, D")
    plt.title("Comparing graph density and running time")
    plt.show()

if __name__ == "__main__":
    main()