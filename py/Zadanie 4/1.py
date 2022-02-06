# -- cooding: utf-8 --
s='hello world'
def man(s):
    print('i ', s[3])

    print('ii ', s[-2])

    print('iii ', s[:5])

    print('iv ', s[:-2])

    print('v ', s[0::2])

    print('vi ', s[1::2])

    print('vii ', s[::-1])

    print('viii ', s[::-2])

    print('ix ', len(s))
man(s)