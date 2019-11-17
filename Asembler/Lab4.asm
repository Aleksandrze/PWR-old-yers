# wektor rzadki to taki wektor o durzej liczby zer w stosunku do jego rozmiatu( elementow niezerowych jest mniej niz zerowych)
.data
	OneWektor: .space 100 #wiektory \\ Wyró?ni? n bajtów przestrzeni w bie??cym segmencie.
	TwoWektor: .space 100
	namiaryOne: .space 25 #argumenty \\ Wyró?ni? n bajtów przestrzeni w bie??cym segmencie.
	namiaryTwo: .space 25
	liczbaP:.asciiz "Podaj liczbu namiatow wektorów: "
	WektorOne:.asciiz "\nPierszy wektor\n"
	WektorTwo:.asciiz "\nDrugi wektor\n"	
	cordinat:.asciiz "Podaj namiary: "
	scalarny:.asciiz "Iloczyn scalarny dwóch wektorów rowny: "
	
.text
main:		
	# pokaz label
	li $v0, 4
	la $a0, liczbaP # odczyt adresu z label do $a0
	syscall
	# $a0 jest rejestr argumentu
	# wprowadz liczbu ile punktow wektorow
	li $v0, 5
	syscall
	move $t8, $v0 # coping liczby punktow w $t8
	
	la $a0, WektorOne #nadajemy(odczytujemy) rozmiar (zapisany w label) dla argumentu 
	la $a1, OneWektor #Odczyt adresu.
	la $a2, namiaryOne

		jal consol # zapis powrotu w $ra 
	
	la $a0, WektorTwo
	la $a1, TwoWektor
	la $a2, namiaryTwo
	
		jal consol

	# generujemy t
	addi $t0, $zero, 0
	addi $t2, $zero, 0 # mam Krata Polaka 
	addi $t3, $zero, 0
	addi $t4, $zero, 0
	addi $t7, $zero, 0
loop:
	beq $t0, $t8, exit # ili raz bedzie petla if(a==b) to label
	lb $t1, namiaryOne($t0) #Odczyt bajtu z namiaryOne do $t1  #dostajemy argument z W1
	beq $t1, $t9, if # sprawdza parametry ( bajty) if(a==b) to label
	addi $t0, $t0, 1 # iteracja i++
	j loop
	
if:
	lb $t1, namiaryTwo($t2) #Odczyt bajtu z namiaryTwo do $t1  
	beq $t2, $t0, dodaj # sprawdzamy czy poprawny elementy (x=x, y=y,z=z)
	beq $t1, $zero, else # sprawdzamy ze bajt jest zero, jesli to to idziemy do label
	addi $t4, $t4, 4 # bedzie poczebna dla przechodzienie na inne slowo (adres)
else:
	addi $t2, $t2, 1 # daliej dla porownania innych elementow
	j if

dodaj:
	addi $t0, $t0, 1 # i++
	beq $t1, $zero, poprawa  # sprawdzaa czy jest w $t1 jest bajt jesli nie to idzie do poprawy
	lw $t5, OneWektor($t3) # odczyt slowa z OneWektor($t3) w $t5
	lw $t6, TwoWektor($t4)
	mul $t5, $t5, $t6 # mnozenia x*x ; y*y; b*b
	add $t7, $t7, $t5 #dodowania wynikow z mul
	addi $t3, $t3, 4 # przechodzim na inny bajt
	j loop
poprawa:
	addi $t3, $t3, 4
	j loop
	
consol:
	
		li $v0, 4
		syscall
	
		addi $t0, $zero, 0
		addi $t9, $zero, 1
loop2: 
		beq $t0, $t8, return # ile raz biedzie petla
		li $v0, 4
		la $a0, cordinat
		syscall
			
		# dla kordinat
		li $v0, 5
		syscall
		
		beq $v0, $zero, brak # jesli kordinata jest 0 to idziemy do label. jest W celu ekonomii czasu( zer jest za durzo )
		add $t1, $a2, $t0 #zapisujem a adres argumientu 
		#Przechowywanie
		sb $t9, ($t1) #$t1 przechowuje bajt z $t9
		sw $v0, ($a1) #$a1 przechowuje slowo z $v0
		addi $a1, $a1, 4 # zwiekszamy na 4 dla przechodzieie na inne slowo
brak: 
		addi $t0, $t0, 1  # iteracja i++
		j loop2
		
	return:
		jr $ra # w $ra adres powroto ( pc(popszrdni)+4 )
			
exit:
		li $v0, 4
		la $a0, scalarny
		syscall
	
		li $v0, 1
		add $a0, $t7, $zero # zapisujem wynik dla pokazu
		syscall
						
		li $v0, 10
		syscall
