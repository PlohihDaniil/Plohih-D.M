a=1
b=5
def man(a,b):
    if a>b:
        for i in range(b,a+1):
            print(i)
    else:
        for i in range(b,a-1,-1):
            print(i)

man(a,b)