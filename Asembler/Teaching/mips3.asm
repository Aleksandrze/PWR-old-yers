#Program proste dodowanie a+b
#Dzia?anie: dodaje dwie warto?ci wprowadzone z klawiatury i wy?wietla wynik
#Program nie b?dzie zawiera? ?adnych komentarzy pomocniczych. Spróbuj sam/a go przeanalizowa?
#dlaczego nie ma sekcji .data? albo .text? (podpowiedz do drugiego - brak pierwszego heh)
.data
ascaner: .asciiz "Wprowadz wartosc A:"
bscaner: .asciiz "\nWprowadz wartosc B:  " 
.text

#Wyswitlene napisy;
li $v0,4 #4 odpowiada za wyswitlenie Stringu
la $a0,ascaner #argument przymuje dane z adresu wejscie
syscall

#get first number
li $v0,5
syscall
move $t0,$v0

#Wyswitlene napisy B;
li $v0,4 #4 odpowiada za wyswitlenie Stringu
la $a0,bscaner #argument przymuje dane z adresu wejscie
syscall

#get second number
li $v0,5
syscall
move $t1,$v0

add $t2,$t0,$t1 #co? si? tu dzieje

li $v0,1
move $a0,$t2
syscall

li $v0,10
syscall
