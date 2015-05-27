## Solution for HackerRank Algorithms/Strings/Fraud Detection
## https://www.hackerrank.com/challenges/fraud-prevention
__author__ = 'modi95'
__date__ = 'Tuesday 26 May 2015'

from sys import stdin

order_list = []
fraud_list =[]

class Order(object):

    #pass a single line containing a record
    #create a record object
    def __init__(self, record):
        record = record.lower()
        self.orig = record
        self.orderID, self.dealID, self.email, self.street, self.city, self.state, self.zipCode, self.card = record.split(",")

        self.int_orderID = int(self.orderID)
        self.int_dealID = int(self.dealID)

        self.fix_state()
        self.email = self.fix_email(self.email)
        self.fix_street()

        order_list.append(self)
        return


    def fix_state(self):
        if (self.state == "new york"):
            self.state = "ny"
        if (self.state == "california"):
            self.state = "ca"
        if (self.state == "illinois"):
            self.state = "il"
        return

    def fix_email(self, email):
        if ("+" in email):
            app = True
            nemail = ""
            for lett in email:
                if (lett == "+"): app = False
                if (lett == "@"): app = True
                if (app): nemail += lett
            email = nemail
        email = email.replace(".","")
        return email

    def fix_street(self):
        if ("Street" in self.street):
            self.street = self.street.replace("Street", "St.")
        if ("Road" in self.street):
            self.street = self.street.replace("Street", "Rd")
        return


    def __str__(self):
        return self.orig

    def __repr__(self):
        return self.__str__()


#rule 1:
#  "Two orders have the same e-mail address and deal id,
#   but different credit card information, regardless of street address."
#  -> order1.email == order2.email && order1.dealID == order2.dealID && order1.card != order2.card
#
#Return true iff this order is fraudulent by rule1
def check_rule_1(order1, order2):
    emailM = (order1.email == order2.email)
    dealM = (order1.dealID == order2.dealID)
    cardM = (order1.card != order2.card)
    return (emailM and dealM and cardM)


#rule 2:
#  "Two orders have the same Address/City/State/Zip and deal id,
#   but different credit card information, regardless of e-mail address."
#
#
#Return true iff
def check_rule_2(order1, order2):
    streetM = (order1.street == order2.street)
    cityM = (order1.city == order2.city)
    stateM = (order1.state == order2.state)
    zipM = (order1.zipCode == order2.zipCode)

    dealIDM = (order1.dealID == order2.dealID)

    cardM = (order1.card != order2.card)

    return ((streetM or cityM or stateM or zipM) and dealIDM) and cardM

def check_rules():

    order_list.sort(key=lambda Order: Order.int_dealID, reverse=False)

    for i in range (0, len(order_list)-1):
        for j in range (i+1, len(order_list)):
            if (order_list[i].int_dealID != order_list[j].int_dealID):
                break
            r1 = check_rule_1(order_list[i], order_list[j])
            r2 = check_rule_2(order_list[i], order_list[j])
            if (r1 or r2):
                fraud_list.append(order_list[i].int_orderID)
                fraud_list.append(order_list[j].int_orderID)
    return

def remove_duplicates():
    global fraud_list
    fraud_list.sort()
    rem_dup = []
    for i in fraud_list:
        if (not (i in rem_dup)):
            rem_dup.append(i)
    rem_dup.sort()

    fraud_list = rem_dup
    return


def output_soln():
    #print (fraud_list)

    if (len(fraud_list) == 0): return
    out = str(fraud_list[0])
    for i in range (1, len(fraud_list)):
        out += ("," + str(fraud_list[i]))
        #print (str(fraud_list[i]))
    return out

#retuns list of lines containing orders
def get_inputs():
    inputs = []
    line1 = stdin.readline()
    num_lines = int(line1)
    for i in range (0, num_lines):
        inputs.append(stdin.readline())
        #print inputs[-1]
    return inputs


def main():
    ips = get_inputs()
    for line in ips:
        order = Order(line)
    check_rules()
    remove_duplicates()
    print (output_soln())

    return

if __name__ == "__main__":
    main()
