a=10
b=1
def man(a,b):
    if a>b:
        for i in range(a,b-1,-1):
            if i%2 !=0:
                print(i)
    else:
        print('ошибка')
man(a,b)