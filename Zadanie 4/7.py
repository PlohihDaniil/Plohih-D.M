# -- cooding: utf-8 --
s=input('min 2 h= ')
def man(s):
    s = s[:s.find('h')] + s[s.rfind('h') + 1:]
    print(s)
man(s)
