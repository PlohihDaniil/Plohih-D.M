# -- cooding: utf-8 --

def zad8():
    next=int(input())
    last=0
    a=0
    b=0
    while next != 0:
        if last == next:
            a+=1
        else:
            if a>b:
                b=a
                a=0
        last=next
        next=int(input())
    if b>a:
        print(b)
    else:
        print(a)
zad8()