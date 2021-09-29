# -- cooding: utf-8 --
def year():
    year = int(input())
    if (year % 4 == 0 and year%100 != 0) or (year%400 == 0) :
        return "Высокосный"
    else:
        return "Обычный"
print(year())