#GRABBING INPUT
inputLength = int(raw_input())
inputString  = str(raw_input())

#PARSING INPUT INTO INTS/SORTING ARRAY
inputArray = inputString.split(" ")
inputArray = [int(i) for i in inputArray]
inputArray.sort()

#TEMPS
currentBestArray = []
currentBestDif = 20000001

#MAIN LOOP
for x in range(0, inputLength-1):
    if (abs(inputArray[x] - inputArray[x+1]) < currentBestDif):
        currentBestArray[:] = []
    if (abs(inputArray[x] - inputArray[x+1]) <= currentBestDif):
        currentBestDif = abs(inputArray[x] - inputArray[x+1])
        currentBestArray.append(inputArray[x])
        currentBestArray.append(inputArray[x+1])

#PRINT ANS
for result in currentBestArray:
    print str(result),