size = int(input("Enter the number of processes:- "))
arrivalTime = []
burstTime = []
for i in range(size):
    temp = input(f"Arrival time of {i} process:- ")
    temp2 = input(f"Burst time of {i} process:- ")
    arrivalTime.append(temp)
    burstTime.append(temp2)
    
for i in range(size):
    