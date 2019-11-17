  #Program 4
 #Dzia?anie: zapisywanie ci?gu znaków w rejstrze $t0 (Nowo??: zastosowanie skoków)
 
 #.data declaration Sekcja danych
 .data 
 askString: .asciiz " Podaj dowolny ci?g   znakow:"
 showString: .asciiz "Ciag znakow:"
 newLine: .asciiz "\n" 
 end: .asciiz "Nacisnij dowolny klawisz na zakonczenie..."
 
 .text
 main:
 #pokaz napis askString // poni?sze instrukcja powinny by? zrozumiale
 li $v0,4
 la $a0,askString
 syscall
 
 #wczyatanie Stringa
 li $v0,8 
 move $t0, $a0
 syscall
 
 #pokaz napis showSrting
 li $v0,4
 la $a0,showString
 syscall
 
 #wyswietlenie wcze?niej wpisanego tekstu
 li $v0,4
 move $a0,$t0
 syscall

j nowaLinia # patsz rozdia? 1,2 and 2,2
		#opuszcamy instrukcje poni?ej i skaczymy do naglówka nowaLinia. Poszukajmy jej
		
koniec:#soz to za twór? w 1 programie wspomina?em to LABEL (taki nag?owek)
#exit-String
li $v0,4
la $a0,end
syscall

li $0,5 # a tu po prosyu czekam na wcisniene INT( inaczej program czeka na odp)
syscall

li $v0,10 #10 - koniec i  nie obchodzi nas czy jest cos nizej
syscall

nowaLinia: #ha znalezlismy nag?owek nowaLini =) Wiec te instrukcje zostaj?ykonane po instrukcji "j nowaLinia"
li $v0,4
la $a0,newLine
syscall
j koniec 
