import matplotlib.pyplot as plt
import pandas as pd
file = pd.read_excel('C:\\Users\\Aryansh Rajput\\Dropbox\\PC\\Downloads\\Data.csv.xlsx')
print(file)
x_axis = file['X Values']
y_axis = file['Y Values']
plt.bar(x_axis, y_axis, width = 7)
plt.xlabel("X-Axis")
plt.ylabel("Y-Axis")
plt.show()