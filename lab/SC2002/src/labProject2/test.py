import numpy as np
from scipy import stats
import matplotlib.pyplot as plt
import seaborn as sns

np.random.seed(0)
x = []
y = []
z = []
for i in range(5):
    x.append(i)
    y.append(i)
    z.append(5-i)
xf1 = np.array(x)
xf = np.random.rand(5)
print(xf1)
print()
print(xf)
yf = np.array(y)
zf = np.array(z)

means = stats.binned_statistic_2d(xf,
                                  yf,
                                  values=zf)[0]
plt.figure(figsize=(10,8))
sns.heatmap(means,
            cmap="seismic",
            annot=True,
            annot_kws={"fontsize":16},
            cbar=True,
            linewidth=2,
            square=True)

#plt.show()

vertices = 5
list = [False]*5
list[1]=2
print((list))

def main():
    pq=[]
    while pq:
        g = [[1,0],[2,3]]
        print(g)
    print("end")

if __name__ == "__main__":
    main()

