# -- cooding: utf-8 --
s=input()
def man(s):
    i=s.count('f')
    if i >= 2:
        print(s.find('f',+1))
    if i == 1:
        print('-1')
    if i < 1:
        print('-2')
man(s)