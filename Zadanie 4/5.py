# -- cooding: utf-8 --
s=input()
def man(s):
    i=s.count('f')
    if i == 1:
        print(s.find('f'))
    if i >= 2:
        print(s.find('f'), s.rfind('f'))
    if i == 0:
        print()
man(s)