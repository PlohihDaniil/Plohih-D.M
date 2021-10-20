# -- cooding: utf-8 --
def x():
    n = int(input())
    m = int(input())
    k = int(input())
    if k < n * m and ((k % n == 0) or (k % m == 0)):
        return 'YES'
    else:
        return 'NO'
print(x())