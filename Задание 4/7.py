s=input('min 2 h= ')
s = s[:s.find('h')] + s[s.rfind('h') + 1:]
print(s)
