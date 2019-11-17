# W MIPS istnieje 32 registru, W karzdym ma 32 Bity ( w ca?osci mo?na rozmie?ci? int)
#S?owo ma 4 bajty
# 1 bit = 8 bajtow
# $at register ktory jest zarezerwowany assemblerem
# sw $v0 myArray($t0) rigister $at + 4
.data
myArray: .space 40 # 40 bajtow to 10 liczb typu int ktory mozem tutaj zmiescic (data segment)
newLine:.asciiz","
string:.asciiz " Poda 10 liczb (przez ENTER):"

.text


	li $v0, 4 	# odczyt 4 w rejester wartosci funkcli (wyswietli polecania(string))
	la $a0, string 	#odczyt deklarowanego Stringu z .asciiz w rejestr argumentow  (odczyt adresu)
	syscall 		# wykonaj systemu call( tabelka na samym dole)

inputArray:
	li $t0, 0 	# odczyt 0 w rejester wartosci funkcli
	li $t1, 40 	#odczyt 40 w rejester $t1 ( rejestr wartosci funkcji)

forArray:
	beq $t0, $t1, bub	 #wykonuj do czasu kiedy t0 i t1 nie sa rowne potem idziemy do bub 
	li $v0,5			# odczyt 5 w rejester wartosci funkcli (odczyt liczby naturalny)
	syscall
	sw $v0 , myArray($t0) 	#wpisanie do tablicy pobranej wartosci (przechowania)
	addi $t0, $t0,4 		#przesuniecie indexu na kolejny element tablicy 
	j forArray 		# j skok(przechodzim) do forArray
	
bub:
	jal bubbleSort		#zapamietaj nastepna isntrukcje w rejestre $ra(adres powrotu) i skoczy do label 
	
printArray:
	li $t0, 0 		# odczyt 0 w rejester wartosci funkcli
	li $t1, 40 		#odczyt 40 w rejester $t1 ( rejestr wartosci funkcji)
		
	forP: beq $t0, $t1, exit 		#wykonuj do czasu kiedy t0 i t1 nie sa rowne poteb idz do exit
		li $v0, 1			# odczyt 1 w rejester wartosci funkcli
		lw $t2, myArray($t0)	# odczyt "slowo" do rejestru $t2
	 	move $a0, $t2		#wpisanie do tablicy pobranej wartosci
	 	syscall
	 	addi $t0, $t0, 4		#przesuniecie indexu na kolejny element tablicy 
	 	li $v0, 4
		la $a0, newLine
		syscall

	 	j forP
	exit:
		li $v0, 10
		syscall		
	
bubbleSort:
		li $t0, 0  
		li $t1, 0 
		li $t2, 40
		
 	forIf: beq $t0,$t2, exit1
 		li $t1,0
 	forSort: beq $t1, $t2 , exit2	#wykonuj do czasu kiedy t1 i t2 nie sa rowne poteb idz do exit
 		lw $t8, myArray($t1) 	#pierwsza liczba do porownania
 		addi $t1, $t1, 4 	 	#przesuniecie wskaznika na nastepny element
		lw $t9, myArray($t1)  	#druga liczna do porownania
 		subi $t1, $t1, 4 		# odejmowania
 		
 		bgt $t9,$t8, exit3 		#idz do lab if(scr1>scr2)
 			sw $t9, myArray($t1)	 #wpisanie do rejestru pobranej wartosci (przechowania)
 			addi $t1,$t1,4 		#przechodzim na drigi int
 			sw $t8, myArray($t1)  	#wpisanie do rejestru pobranej wartosci (przechowania)
 			subi $t1, $t1,4 		# wracamy sie do popszedniego inta
 		exit3:
 			addi $t1, $t1,4
 		j forSort
 	exit2:
 		addi $t0, $t0,4
 		j forIf 
 	exit1:
 		jr $ra 		#wracania (skok do zapisanego w $ra adresu powrotu)
