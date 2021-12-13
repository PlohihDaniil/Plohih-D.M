# -- cooding: utf-8 --

def zad7():
    next=int(input())
    last=0
    a=0
    while next != 0:
        if last < next:
            a+=1
        last=next
        next=int(input())
    print (a-1)
zad7()