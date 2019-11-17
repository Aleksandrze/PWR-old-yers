    .data
    lin: .word 4
    count: .word 0
    size: .word 16
    Array: .space 64
    space: .word 4
    NL: .asciiz "\n"
    tab: .asciiz " "
    lab: .asciiz "\nPodana maciez:\n"
    wpr1: .asciiz "a["
    wpr2: .asciiz "]["
    wpr3: .asciiz "]= "
    .text
    main:
    lw $t7, size# get size of list
    move $s1, $zero # set counter for # of elems printed
    move $s2, $zero # set offset from Array
    lw $t8, lin
    lw $t0, count
    lw $t9, count
    lw $t6, count
    lw $t3, count #count elements to add to the array[]
    lw $t5, count #count integer
    lw $t2, space #4 int
    add:
    #add to array[]
    bge $t3, $t7, label

    li $v0, 4
    la $a0, wpr1
    syscall

    #wiersz licz
    div $t3, $t8
    mflo $t9
    li $v0, 1
    move $a0, $t9
    syscall

    li $v0, 4
    la $a0, wpr2
    syscall

    #kolumna licz
    j l
    wyzeroj:
    move $t0, $zero
    l:
    bge $t0, $t8, wyzeroj
    li $v0, 1
    move $a0, $t0
    syscall
    addi $t0, $t0, 1

    li $v0, 4
    la $a0, wpr3
    syscall
    #------------— kosmetyki {}  [] ()

    li $v0, 5
    syscall
    move $t4, $v0


    sw $t4, Array($t5)
    addi $t5, $t5, 4
    addi $t3, $t3, 1
    j add

    label:

    li $v0, 4
    la $a0, lab
    syscall #print the lab

    move $t0, $zero
    move $t6, $zero
    move $t3, $zero
    move $t5, $zero

    print_loop:
    bge $s1, $t7, print_loop_end # stop after last elem is printed
    lw $a0, Array($s2) # print next value from the list
    li $v0, 1
    syscall

    #print tab
    li $v0, 4
    la $a0, tab
    syscall

    addi $t0, $t0, 1
    addi $s1, $s1, 1 # increment the loop counter
    addi $s2, $s2, 4 # step to the next array elem

    #porownaj
    blt $t0, $t8, print_loop
    move $t0, $zero

    la $a0, NL # print a newline
    li $v0, 4
    syscall

    cont:
    j print_loop # repeat the loop

    print_loop_end:

    jal diagonal

    li $v0, 10
    syscall


    diagonal:

    li $v0, 4
    la $a0, NL
    syscall

    move $t0, $zero
    move $t6, $zero
    move $t3, $zero
    mul $t9, $t8, $t2
    addi $t9, $t9, 4

    diag:
    bge $t0, $t8, kon
    addi $t0, $t0, 1
    lw $t3, Array($t6)

    add $t6, $t6, $t9

    li $v0, 1
    move $a0, $t3
    syscall

    li $v0, 4
    la $a0, tab
    syscall
    j diag

    kon:
    jr $ra

