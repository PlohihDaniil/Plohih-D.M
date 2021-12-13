# -- cooding: utf-8 --

def zad3 ():
    n = 100
    a = 2
    s = 1
    while a <= n:
        a *= 2
        s += 1
    print(s - 1, a // 2)
zad3()