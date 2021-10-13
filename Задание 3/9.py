# -- cooding: utf-8 --
n=10
def man(n):
    a=1
    b=1
    c=0
    s=2
    for i in range(2,n):
        c=a+b
        a=b
        b=c
        s=s+c
    print(s)
man(n)