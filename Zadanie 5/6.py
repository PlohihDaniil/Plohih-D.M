# -- cooding: utf-8 --
sum=0
a=0
b=int(input())
def man(a,sum,b):
    while b != 0:
        a+=1
        sum+=b
        b=int(input())
    print(sum/a)
man(a,sum,b)