#Prosz? napisa? program wyznaczajšcy warto?? wielomianu trzeciego stopnia dla zadanych parametrów a,b,c,d oraz x. Posta? wielomianu: y = ax^3 + bx^2 +cx +d.
#$v0 dla rezultatu, wraca funkcjie
# $a0 - dla argumentów
#$t0- dla danych czasowych
#.asciiz zachowuie Stringu w pamiec + dodaja "\0" sybol na koniec
# W MIPS istnieje 32 registru, W karzdym ma 32 Bity ( w ca?osci mo?na rozmie?ci? int)
#S?owo ma 4 bajty

.data# pocz?tek sygmentu koda
  prompt_a:.asciiz  "Wielomian   \nax^3 + bx^2 + cx + d   \nWspolczynnik a:  "
  prompt_b: .asciiz "Wspolczynnik b: "
  prompt_c: .asciiz "Wspolczynnik c: "
  prompt_d: .asciiz "Wspolczynnik d: "
  prompt_x: .asciiz "Wspolczynnik x: "
  
  result:.asciiz "Wartosc wielomianu to:  "  
  
  # pocczatek kodu
  .text
  #Wspolczynik a
  li $v0,4   # Load Addresss
  la $a0,prompt_a  # Load Linked
  syscall # sluzbowa instrukcja (ko?ystamy do odwo?ania do systemu operacyjnego aby rozpocz?? dzia?ania
  li $v0,5
  syscall
  move $t0, $v0
  
  #Wspolczynik b
  li $v0,4
  la $a0, prompt_b
  syscall
  li $v0,5
  syscall
  move $t1, $v0
  
  #Wspolczynik c
  li $v0,4
  la $a0,prompt_c 
  syscall
  li $v0,5
  syscall
  move $t2, $v0
  
  #Wspolczynik d
  li $v0,4
  la $a0,prompt_d
  syscall
  li $v0,5
  syscall
  move $t3, $v0
  
  #Wspolczynik x
  li $v0,4
  la $a0,prompt_x
  syscall
  li $v0,5
  syscall
  move $t4, $v0
   
   # Obliczenia
   
   #Help "mov" and "add"
   # A - $t0
   # B - $t1
   # C - $t2
   # D - $t3
   # X - $t4  
   # $t5 - koncowy System.out.println
   # $t6 - suma
   
   li $v0,1
   li $t5,0
   li $t6,0
   li $t7,0 # wartosc X na danny moment
   move $t7, $t4 # coping X
   
   #Zaczynamy ot x * c
   mul $t5 $t7, $t2
   
   # b * x^2
   mul $t4, $t4, $t7 #x^2
   mul $t6, $t4, $t1
   add $t5, $t6, $t5 #(bx^2)+cx
   
   # a *x^3
   mul $t4, $t4, $t7 #x^3
   mul $t6, $t4, $t0
   add $t5, $t6, $t5
   
   # dodanie d
   add $t5, $t5, $t3
   
   #wypisanie wyniku
   li $v0,4
   la $a0,result
   syscall
   
   li $v0,1
   move $a0, $t5
   syscall
