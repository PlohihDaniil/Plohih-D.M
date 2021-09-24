# -- cooding: utf-8 --
#1
print("Курс Основы программирования начался!")

#2
print(16823*12302%3092)


#3
name=input("Имя ")
age=int(input("возраст "))

if 16<=age<75:
    if name != "Иван" :
        print("Поздравлем вы поступили во ВГУИТ")
    else:
        print("Вы не поступили во вгуит")
else:
    print("Вам осталось учиться в школе: ", 16-age," лет")
#4
sec=int(input("сек= "))
min=int(sec/60)
chas=int(sec/3600)
day=int(sec/86400)
print(sec,min,chas,day)
#5
n=int(input("число "))
print(n+n**2+n**3+n**4+n**5)

#6
a=int(input("число "))
b=int(input("число "))
c=0
c=a
a=b
b=c
print(a, b )

#7
a=int(input("число "))

if a % 2 ==0:
    print('четное')
else:
    print('нечетное')