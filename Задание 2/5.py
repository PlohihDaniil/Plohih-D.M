# -- cooding: utf-8 --
a = int(input())
b = int(input())
c = int(input())
if b >= a <= c:
    print(f'меньшее число {a}')
elif a >= b <= c:
    print(f'меньшее число {b}')
else:
    print(f'меньшее число {c}')