# -- cooding: utf-8 --
N=10
a=1
k=1
def man (N,a,k):
    while k<N:
        k=a**2
        if k<N:
            print(k)
        a+=1
man (N,a,k)