n=2
def man(n):
    s=0
    for i in range(1,n+1):
        s += i**3
    print(s)
man(n)