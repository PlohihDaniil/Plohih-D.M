n=10
k=5
def man(n,k):
    a=0
    b=1
    c=0
    s=1
    s2=0
    for i in range(1,n):
        c=a+b
        a=b
        b=c
        s=s+c
        if i == k-2 :
            s2=s
        s3=s-s2
    print(s3)
man(n,k)