# -- cooding: utf-8 --
s=input('min 2 h= ')
def man(s):
    s= s[:s.find('h')]  +  s[s.rfind('h'):s.find('h'):-1]  +  s[s.rfind('h'):]
    print(s)
man(s)