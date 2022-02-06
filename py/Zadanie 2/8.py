# -- cooding: utf-8 --
def x():
    a = int(input())
    b = int(input())
    c = int(input())
    if a == b == c:
        print(3)
    elif a == b or b == c or a == c:
        print(2)
    else:
        print(0)
x()