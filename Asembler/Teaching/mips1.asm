#Program 1 Hello World
#Wyswiietla na ekranie Hello World (classic)

.data
# create text
hello_msg :.asciiz "Hello  World"

.text
main:
#odczytujemy stal? z tabelki SPIM syscall.

#je?eli chcemy wy?wietli? tekst, to po zmiennej wynikowej($v0)
#dodajemy liczb? 4
#teraz wiemy ze wynikiem b?dzie String
#argument ($a0) teraz wie ze tez musi by? stringiem
li $v0,4
#nadajemy(odczytujemy) string (zapisany w hello_msg) dla argumentu
#$a0
la $a0,hello_msg
#korzystali?my z SPIM syscalls wiec teraz by si? wykona?a powy?sza
#instrukcja musimy
#to zadeklarowa? instrukcja syscall
#drukujemy wynik
syscall

#dla warto?ci 10 funkcja wychodzi z programu //patrz tabelka SPIM
li $v0,10
syscall