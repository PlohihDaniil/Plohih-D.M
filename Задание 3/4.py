# -- cooding: utf-8 --
n=int(input('n= '))
def man(n):
    sum=0
    for i in range(n):
        a=int(input('a= '))
        sum += a
    print(sum)
man(n)