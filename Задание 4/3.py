# -- cooding: utf-8 --
s = input()
def man(s):
    print(s[(len(s) + 1) // 2:] + s[:(len(s) + 1) // 2])
man(s)