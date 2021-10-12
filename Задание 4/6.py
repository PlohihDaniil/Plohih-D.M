s=input()
i=s.count('f')
if i >= 2:
    print(s.find('f',+1))
if i == 1:
    print('-1')
if i < 1:
    print('-2')