# Copyright (C) Vitaly A. Feskov, 2022

pi = 3.14159265358979323846
e = 2.718281828459045
c = 2.99792458e8
ht = 1.054571817e-34    # постоянная Планка-Дирака
Pik3 = pi*256
Pik4 = pi*(256**2)
ze=1.6021892e-19    # заряд электрона в системе Си

Nc=1e20
R=1.00
H=0.01
ln_R_a=1
mu=1/4
a=0.2 # радиус приосевой области, в которой электрическое поле отсутствует, в см
Wcr=100
m=100
Ucr = (pi/4)*( (2*Wcr*Nc*ht/((1-mu)*m*c*c*H*ln_R_a))**0.5 )




print("Ucr="+str(Ucr)+str(' Volt'))

# Schemes for Baumann Disc with parameters given in this file, and the parameters for power generation in such a way,
# that allowed by the specification of the Grid Condensors Transformators (see generating power details)
