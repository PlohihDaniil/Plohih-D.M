# -- cooding: utf-8 --
name=input("Имя ")
age=int(input("возраст "))

if 16<=age<75:
    if name != "Иван" :
        print("Поздравлем вы поступили во ВГУИТ")
    else:
        print("Вы не поступили во вгуит")
else:
    print("Вам осталось учиться в школе: ", 16-age," лет")
