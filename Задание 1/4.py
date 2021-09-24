# -- cooding: utf-8 --
sec=int(input("сек= "))
min=int(sec/60)
chas=int(sec/3600)
day=int(sec/86400)
print(f'{sec} сек,{min} мин,{chas} часов,{day} дней')
