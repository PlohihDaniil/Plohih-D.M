# -- cooding: utf-8 --

def man():
    sum=0
    a=0
    b=int(input())
    while b != 0:
        a+=1
        sum+=b
        b=int(input())
    print(sum/a)
man()