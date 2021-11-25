# -- cooding: utf-8 --
N=10
a=2
def man (N,a):
    while a != N:
        k=N%a
        if k == 0 :
            print(a)
            break
        a+=1
man (N,a)