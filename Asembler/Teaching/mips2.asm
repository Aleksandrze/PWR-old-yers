#Program 2 : scanner and System.out.println( int ) zapis liczb- int
#Dzia?anie: Program pobiera i wy?wietla liczb? typu ca?kowitego

#Sekcja danych
.data
wejscie: .asciiz "Wprowadz wartocs typy INTEGER:"
wyswietli: .asciiz "Wartosc:"
.text
main:
#Seckcja kodu

#Wyswitlene napisy;
li $v0,4 #4 odpowiada za wyswitlenie Stringu
la $a0,wejscie #argument przymuje dane z adresu wejscie
syscall

#pobieramy INTEGER
li $v0,5 #5-odczytuje inta
syscall
move $t0,$v0 # $t0=$v0 (wprowdziene liczby)

#Wyswietlanie inta

li $v0,4
la $a0,wyswietli
syscall

#pokaz inta
li $v0,1 #kod 1, print int
move $a0,$t0 #rzuc wartosc z $a0  do argumentu $a0 ?evy wydrukowac
syscall

#koniec
li $v0,10 # kod 10 - zakonczenie.
syscall
