#Prosz? napisa? program, kt�ry poprosi u?ytkownika o warto?? N>0, po czym wyliczy i wy?wietli wartos? N! (silnia). 
#Zabezpieczy? program przed problemem nadmiaru. Program napisa? w dw�ch wersjach "do-while" i "while-do". 
#Opdowiedzie? na pytanie: dla jakiej maksymalnej warto?ci N program podaje poprawn� warto?? N!

#$v0 dla rezultatu, wraca funkcjie
# $a0 - dla argument�w
#$t0- dla danych czasowych
#.asciiz zachowuie Stringu w pamiec + dodaja "\0" sybol na koniec
# W MIPS istnieje 32 registru, W karzdym ma 32 Bity ( w ca?osci mo?na rozmie?ci? int)
#S?owo ma 4 bajty, mozna zapisac 16 bit�w
#addi  dwa rejestra + liczba ( max 16-bajtow)

.data
	start:.asciiz "Podaj n (N>0): "
	newLine: .asciiz " \n"
	end:.asciiz "Silna rowna: "
	nadmiar: .asciiz "Wystapil nadmiar, maksymalna liczba przy ktorej nie wystepuje nadmiar to: "
	
	
.text

main:
	#wydruk wiadomosci
	li $v0, 4   	# Load Addresss
	la $a0, start	# Load Linked
	syscall		# sluzbowa instrukcja (ko?ystamy do odwo?ania do systemu operacyjnego aby rozpocz?? dzia?ania
	
	#pobranie wartosci 
	li $v0, 5
	syscall
	move $t0, $v0 #ilosc powtorzeni pobrana od uzytkownika
	
	

#===========================WHILE-do===================================


	li $t1, 1 #poczatkowa wartosc silni
	li $t2, 1 #wartosc  i
		#pote rejestrem t0 jest wartosc maksymalna petli
	while: beq $t2, $t0, exit  #if m == S, we�re done.
		addi $t2, $t2, 1 #i++ iterowanie dwa rejestra i liczba (addi)
		mul $t1, $t1, $t2 #obliczanie silni (mnozenia)
		mfhi $t4 # sprawdzanie przepe?nienia
		beq $t4, $zero, exit2 # jezeli nadmiar wiencej 0 to bendzie nadmiarh
		 #wyswietlenie informacji o przekroczeniu nadmiaru
		li $v0, 4
		la $a0, nadmiar
		syscall

		li $v0, 1
		subi $t2, $t2, 1 # t1 -= �0�
		move $a0, $t2
		syscall				
		
		li $v0, 10 
		syscall
		exit2:		
	#powrot do poczatku petli 
	j while # jamp : Jedyny argument � 26-bitowy adres, do kt�rego chcesz przej??
			
	exit:	
	li $v0, 4
	la $a0, end
	syscall
		
	#wydruk wyniku
	li $v0, 1
	move $a0, $t1
	syscall


#==============================Do-While==========================================


	li $t3, 1 #poczatkowa wartosc silni 
	li $t4, 1 # int i
	
	doWhile: addi $t4, $t4,1
		mul $t3, $t3, $t4	
		mfhi $t5 # sprawdzanie przepe?nienia // copuie z hi do rejestru $t5
		beq $t5, $zero, while2 
		
		
		#wyswietlenie informacji o przekroczeniu nadmiaru
		li $v0, 4
		la $a0, nadmiar
		syscall
		
		li $v0, 1
		subi $t4, $t4, 1
		move $a0, $t4
		syscall
		
		li $v0, 10 
		syscall
	while2:
		beq $t4, $t0, end0
	j doWhile
	
	
	
	end0:
	li $v0, 4
	la $a0, newLine
	syscall
	
	li $v0, 4
	la $a0, end
	syscall
	

	#wydruk wyniku
	li $v0, 1
	move $a0, $t1
	syscall
		
	li $v0, 10 
	syscall
