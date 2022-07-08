# copyright (C) Vitaly A. Feskov, 2021, 2022

debug=False

pi = 3.14159265358979323846 # число пи
e = 2.718281828459045 # число е
c = 2.99792458e8 # скорость света
ht = 1.054571817e-34    # постоянная Планка-Дирака в системе Си
hs = 1.054e-34#27 #6.582119569e-16  # постоянная Планка-Дирака в системе СГС эВ*с ?
G=6.670e-11 # гравитационная постоянная
Pik3 = pi*256 #804.2477
Pik4 = pi*(256**2) #2.059e5
ze=1.6021892e-19    # заряд электрона в системе Си
se=4.8e-10  #  заряд электрона в системе СГС
me2 = 3.05e-31 # масса электрона второго иерархического уровня, в г
ne2 = 2.3e18 # плотность электронов второго иерархического уровня

Hr=4#2.4#9.6#3#4.8#3#11.5#5#3#42 # Высота ролика, см
print('Hr='+str(Hr)+' sm')
Ro=4.8 # g/sm плотность ролика

D=[34, 24, 8] # [300, 150, 100]  # Diameter of external ring of the Searl Disc, in sm
print('D='+str(D)+str(' Diameters, sm'))
rr= [2.5, 1, 1] # Диаметр роликов многосекционного диска Сёрла, в см # [0.8, 0.8, 0.8]
print('rr='+str(rr)+str(' rolik diameters, sm'))
m=0.007539#0.0676#2*0.007539#5#10#0.007539 # small mass
r=rr[0]/(2*100) # small radius rolik, meters
#r=0.005#0.03#0.005#0.03#0.005 # small radius rolik, meters
r_roli=r*100 # радиус ролика в см
print('r_roli='+str(r_roli)+' sm')
Srollers=pi*(r_roli**2) # плаощадь сечения ролика, см^2
Vroller=Hr*Srollers # объем ролика, в СГС
Mroller=Vroller*Ro # масса ролика, г
#M=52*0.007539#0.392#37#1#0.392#0.392#50#120#37#2*0.0904644#0.4674#125#600#1200#2500#1.4208*2#1152#1.4208#5#5000#60#37 #37 #500 #125 #*2*2*10
R=D[0]/(2*100)#0.17#0.175#0.045#0.175#1.5#0.175#0.17#0.25#1.5#0.225#45#0.52#4.8#9.6#10#28#32#0.45#30#0.5#1.5#0.5 #1.5 #0.52 #30 # Радиус Диска Сёрла, в метрах
R=R+r #  эффективный радиус Диска Сёрла
al=int(D[0]*pi/(2*2*r_roli)) # количество роликов
#al=52#14#52#548#52#62#10#548#2*12#62#24#120#240#148#12#148#480#12#548 #120 #548 #24 # количество роликов
M=Mroller*al/1000 # Масса ротора роликов, кг
my_n=2#2#1/2#2#1/2#1#2#3#2#1#2#2#1 #2 # число поляризовавшихся полей

def Ntau(n_fields):
    Ntau=abs(((e ** (2*n_fields))-1)**0.5)
    if (n_fields != 0.5):
        return Ntau
    else:
        return (1)

print('M='+str(M)+' kg')
print('R='+str(R)+' m')
print('al='+str(al)+' pcs.')
print('n='+str(my_n)+' polarized fields')
Veq = 2.059e5 *((e ** (2*my_n)-1)**0.5)*ht / (al*me2*1e-3*R)#633# #Pik4 * ((e ** (2*n)-1) * ht / (al*me2*R) # 633 #3330
Vcr = 804.2477 *((e ** (2*my_n)-1)**0.5)*ht / (al*me2*1e-3*R)#2.5#Pik3 * ((e ** (2*n)-1) * ht / (al*me2*R)
f = Veq/(2*pi*R) 
f_cr = Vcr/(2*pi*R)

Ecr = (M*Vcr*Vcr)/2
Feqцбс=m*Veq*Veq/r

print('Vcr='+str(Vcr)+' m/s')
print('Ecr='+str(Ecr)+' Joules')
print('Veq='+str(Veq)+' m/s')
print('Feqцбс?='+str(Feqцбс)+' ')
print('f_cr='+str(f_cr)+' rps')
print('f='+str(f)+' rps')

def Fg(Radius):
    return 2*pi*Radius*((M*c)**2)*(f-f_cr)/(3*ht*(Pik4**10))
SumFg = 0
for i in range(len(D)):
    if debug: print(''+str(Fg((D[i])/100.0)))
    SumFg+=Fg((D[i])/100.0)
new_e=Pik4*ht*c/(((0.01*0.5e-2)**2)*0.05)
f_2h = f_cr # temporally
H = 4*pi*se*ne2*hs*((f/f_2h)-1)/(c*me2) #*1e-3) #ze = # привести в систему Си ?

print('e?='+str(new_e)+' ')
print('H='+str(H)+' Tl')
print('SumFg='+str(SumFg)+' N')
Um=(Pik4*(c**3)*Ntau(my_n)*ht )/(2*(Pik4**10)*ze*me2*1e-3*G*1000)

N_tau=(((2.718281828459045 ** (2*my_n))-1)**0.5)
Wrot = ((2*pi*M*R*c)**2)*f*(f-f_cr)/((Pik4**10)*ht*1000)
Feq=Wrot/Veq # Сила разгонная
F1rol=1000*Feq/al # Сила на один Ролик
print('Um='+ str(Um)+' kVolt')
print('Ntau='+ str(N_tau)+' time dilation')
if debug: print('my_n='+str(my_n)+' fields')
print('Feq='+ str(Feq)+' kN')
print('F1roll='+str(F1rol)+' N')
print('Wrotor='+str(Wrot)+' kWt')


