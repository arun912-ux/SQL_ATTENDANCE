
def printline(a):
    for i in a:
        for j in i:
            try:
                print("{0:10}".format(j), end='\t\t')
            except:
                print(j, end="\t\t")
        print()




