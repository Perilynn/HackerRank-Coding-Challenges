# Enter your code here. Read input from STDIN. Print output to STDOUT
import re
num = int(input())
orders = []
redundant = set()
ORDER_ID, DEAL_ID, EMAIL, ADDRESS, CITY, STATE, ZIP, CC_NUMBER = 0,1,2,3,4,5,6,7
for i in range(num):
    orders.append(raw_input().split(","))
for i in range(num):
    #lower case everything
    orders[i][EMAIL] = orders[i][EMAIL].lower()
    orders[i][ADDRESS] = orders[i][ADDRESS].lower()
    orders[i][CITY] = orders[i][CITY].lower()
    orders[i][STATE] = orders[i][STATE].lower()
    
    #normalize email
    orders[i][EMAIL] = re.sub('\+.*@', '@', orders[i][EMAIL])
    orders[i][EMAIL] = re.sub('\.', '', orders[i][EMAIL])
    
    #normalize address
    orders[i][ADDRESS] = re.sub('street', 'st.', orders[i][ADDRESS])
    orders[i][ADDRESS] = re.sub('road', 'rd.', orders[i][ADDRESS])
    
    #normalize state
    orders[i][STATE] = re.sub('illinois', 'il', orders[i][STATE])
    orders[i][STATE] = re.sub('new york', 'ny', orders[i][STATE])
    orders[i][STATE] = re.sub('california', 'ca', orders[i][STATE])
    
    #normalize zip
    orders[i][ZIP] = re.sub('\-', '', orders[i][ZIP])
    for k in range(i):
        #same email and deal, different credit card
        if orders[k][EMAIL] == orders[i][EMAIL] \
        and orders[k][DEAL_ID] == orders[i][DEAL_ID] \
        and orders[k][CC_NUMBER] != orders[i][CC_NUMBER]:
            redundant.add(int(orders[k][ORDER_ID]))
            redundant.add(int(orders[i][ORDER_ID]))
            
        #same address and deal id, different credit card
        if orders[k][ADDRESS] == orders[i][ADDRESS] \
        and orders[k][STATE] == orders[i][STATE] \
        and orders[k][CITY] == orders[i][CITY] \
        and orders[k][ZIP] == orders[i][ZIP] \
        and orders[k][DEAL_ID] == orders[i][DEAL_ID] \
        and orders[k][CC_NUMBER] != orders[i][CC_NUMBER]:
            redundant.add(int(orders[k][ORDER_ID]))
            redundant.add(int(orders[i][ORDER_ID]))
                
redundant = list(redundant)
redundant.sort()
print ",".join(list(map(str, redundant)))