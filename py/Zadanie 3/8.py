# -- cooding: utf-8 --
n = 4
def man(n):
    if 0< n <=9:
        for i in range(1, n + 1):
            for j in range(1, i + 1):
                print(j,sep="", end="")
            print()
    else:
        print('ошибка')
man(n)