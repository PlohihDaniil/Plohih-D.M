# -- cooding: utf-8 --
n=3
def man(n):
    s=1
    sum=0
    for i in  range(1,n+1):
        s *= i
        sum+=s
    print(sum)
man (n)