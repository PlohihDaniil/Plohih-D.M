# -- cooding: utf-8 --
s='hello world'
def man(s):
    print(s[s.find(' '):],s[:s.find(' ')])
man(s)