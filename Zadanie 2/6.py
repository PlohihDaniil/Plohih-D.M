# -- cooding: utf-8 --
d= int(input())
a= int(input())
b= int(input())
c= int(input())
def f(a,b,c,d):
    return (a+b+c+d) % 2
if f(a,b,c,d) == 0:
    print('YES')
else:
    print('NO')