# -- cooding: utf-8 --
def x():
    a = int(input())
    b = int(input())
    c = int(input())
    if b >= a <= c:
        return f'меньшее число {a}'
    elif a >= b <= c:
        return f'меньшее число {b}'
    else:
        return f'меньшее число {c}'
print (x())