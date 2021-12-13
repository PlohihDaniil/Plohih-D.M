# -- cooding: utf-8 --
from tkinter import *
from tkinter import messagebox
from typing import Sized


root = Tk() 


def zad1():
    def zad():
        array=[]
        N=int(text1.get())
        a=1
        k=1
        while k<N:
            k=a**2
            if k<N:
                array.append(k)
            a+=1
        messagebox.showinfo(title='Ответ',message=array)
    new=Tk()
    new.title('')
    new.geometry('450x250')

    lbl=Label(new,text='По данному целому числу N распечатайте все квадраты натуральных чисел,')
    lbl.pack()
    lbl=Label(new,text= 'не превосходящие N, в порядке возрастания.')
    lbl.pack()
    lbl=Label(new,text="Введите число N")
    lbl.pack()
    text1=Entry(new,)
    text1.pack()

    btn=Button(new,text="Ответ",command=zad)
    btn.pack()

def zad2():
    def zad ():
        N=int(text1.get())
        a=2
        while a != N:
            k=N%a
            if k == 0 :
                messagebox.showinfo(title='Ответ',message=a)
                break
            if k== 1 :
                messagebox.showinfo(title='Ответ',message=N)
                break
            a+=1
            
    new=Tk()
    new.title('')
    new.geometry('450x250')

    lbl=Label(new,text='Дано целое число, не меньшее 2.') 
    lbl.pack()
    lbl=Label(new,text='Выведите его наименьший натуральный делитель, отличный от 1.')
    lbl.pack()
    lbl=Label(new, text="Введите целое число.")
    lbl.pack()
    text1=Entry(new,)
    text1.pack()

    btn=Button(new,text="Ответ",command=zad)
    btn.pack()

def zad3():
    def zad():
        n = int(text1.get())
        a = 2
        s = 1
        
        while a <= n:
            a *= 2
            s += 1

        messagebox.showinfo(title="Показатель степени",message= s-1 )
        messagebox.showinfo(title="Сама степень",message= a//2 )
    new=Tk()
    new.title('')
    new.geometry('500x350')
    
    lbl=Label(new,text="По данному натуральному числу N найдите наибольшую целую степень двойки,")
    lbl.pack()
    lbl=Label(new,text="не превосходящую N. Выведите показатель степени и саму степень. ")
    lbl.pack()
    lbl=Label(new,text="Операцией возведения в степень пользоваться нельзя!")
    lbl.pack()
    lbl=Label(new,text='Введите число N')
    lbl.pack()

    text1=Entry(new,)
    text1.pack()

    btn=Button(new,text="Ответ",command=zad)
    btn.pack()
    
def zad4():
    def zad():
        x = int(text1.get())
        y = int(text2.get())
        n=1
        while x<y:
            a=x*0.1
            x+=a
            n+=1
        messagebox.showinfo(title="Вывод",message=n)

    new=Tk()
    new.title('')
    new.geometry('300x250')
    
    lbl=Label(new,text="В первый день спортсмен пробежал x километров, а затем он каждый день увеличивал пробег на 10% от предыдущего значения.")
    lbl.pack()
    lbl=Label(new,text="По данному числу y определите номер дня, на который пробег спортсмена составит не менее y километров. Программа получает на вход действительные")
    lbl.pack()
    lbl=Label(new,text="числа x и y и должна вывести одно натуральное число.")
    lbl.pack()

    lbl=Label(new,text='Введите число X')
    lbl.pack()

    text1=Entry(new,)
    text1.pack()

    lbl=Label(new,text='Введите число Y')
    lbl.pack()

    text2=Entry(new,)
    text2.pack()

    btn=Button(new,text="Ответ",command=zad)
    btn.pack()

def zad5():
    def zad():
        s=text1.get()
        n=s.split()
        a=-1
        if n[-1] == "0":
            for i in n:
                a+=1
            messagebox.showinfo(title="Ответ",message=a)
        else:
            messagebox.showerror(title="Ошибка",message="в конце нет 0")


    new=Tk()
    new.title=""
    new.geometry('750x350')
    lbl=Label(new,text="Программа получает на вход последовательность целых неотрицательных чисел, каждое число записано в отдельной строке.")
    lbl.pack()
    lbl=Label(new,text="Последовательность завершается числом 0, при считывании которого программа должна закончить свою работу и вывести ")
    lbl.pack()
    lbl=Label(new,text="количество членов последовательности (не считая завершающего числа 0).")
    lbl.pack()
    lbl=Label(new,text="Числа, следующие за числом 0, считывать не нужно.")
    lbl.pack()

    lbl=Label(new,text="Введите числа")
    lbl.pack()

    text1=Entry(new,)
    text1.pack()

    btn=Button(new,text="Ответ",command=zad)
    btn.pack()

def zad6():
    def zad():
        
        s=text1.get()
        n=s.split()
        sum=0
        a=-1
        if n[-1] == "0":
            for i in n:
                m=int(i)
                sum+=m
                a+=1
            otvet=sum/a
            messagebox.showinfo(title="Ответ",message=otvet)
        else:
            messagebox.showerror(title="Ошибка",message="В конце нет 0")


    new=Tk()
    new.title=""
    new.geometry("550x250")

    lbl=Label(new,text='Определите среднее значение всех элементов последовательности, завершающейся числом 0.')
    lbl.pack()

    text1=Entry(new,)
    text1.pack()

    btn=Button(new,text="Ответ",command=zad)
    btn.pack()

def zad7():
    def zad():

        s=text1.get()
        n=s.split()
        pred=0
        a=-1
        if n[-1] == "0":
            for i in n:
                if int(i) > pred:
                    a+=1
                pred = int(i)
            messagebox.showinfo(title="Ответ",message=a)
        else:
            messagebox.showerror(title="Ошибка", message="В конце нет 0")



    new=Tk()
    new.title=""
    new.geometry('550x350')
    lbl=Label(new,text="Последовательность состоит из натуральных чисел и завершается числом 0. ")
    lbl.pack()
    lbl=Label(new,text="Определите, сколько элементов этой последовательности больше предыдущего элемента.")
    lbl.pack()
    lbl=Label(new,text="сколько элементов этой последовательности больше предыдущего элемента.")
    lbl.pack()
    lbl=Label(new,text="Введите числа")
    lbl.pack()

    text1=Entry(new,)
    text1.pack()

    btn=Button(new,text="добавить",command=zad)
    btn.pack()
    


def zad8():
    def zad():
        s=text1.get()
        n=s.split()
        pred=0
        a=0
        if n[-1] == "0":
            for i in n:
                if int(i) == pred:
                    a+=1
                pred = int(i)
            messagebox.showinfo(title="Ответ",message=a)
        else:
            messagebox.showerror(title="Ошибка", message="В конце нет 0")

    new=Tk()
    new.title("")
    new.geometry("550x250")

    lbl=Label(new, text="Дана последовательность натуральных чисел, завершающаяся числом 0. ")
    lbl.pack()
    lbl=Label(new,text="Определите, какое наибольшее число подряд идущих элементов этой последовательности равны друг другу.")
    lbl.pack()

    text1=Entry(new,)
    text1.pack()

    btn=Button(new,text="Ответ",command=zad)
    btn.pack()


#root['bg']='red'#цвет фона
root.title('название программы')
#root.wm_attributes('-alpha',0.7)#прозрачность окна
root.geometry('300x250')

#root.resizable(width=False,heigth=False)#блокировка изменения размера
lbl=Label(root,text="Выбирете задание")
lbl.grid(column=0,row=0)
btn=Button(root,text='Задание 1',command=zad1)
btn.grid(column=0,row=1)
btn=Button(root,text="Задание 2",command=zad2)
btn.grid(column=0,row=2)
btn=Button(root,text="Задание 3",command=zad3)
btn.grid(column=0,row=3)
btn=Button(root,text="Задание 4",command=zad4)
btn.grid(column=0,row=4)
btn=Button(root,text='Задание 5',command=zad5)
btn.grid(column=0,row=5)
btn=Button(root,text="Задание 6",command=zad6)
btn.grid(column=0,row=6)
btn=Button(root,text="Задание 7",command=zad7)
btn.grid(column=0,row=7)
btn=Button(root,text="Задание 8",command=zad8)
btn.grid(column=0,row=8)





root.mainloop()#повторение программы обязательно в конце