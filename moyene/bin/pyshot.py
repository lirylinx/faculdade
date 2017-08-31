#!/usr/bin/python

# PyShot.py v1.0
# Autor: pr0zak
# E-mail: pr0zak@punks.net

import os
import sys
import string

def clear():
	os.system("clear")

def line():
	print("\n+-------------------------------------------+\n")

def info():
	line()
	print("\tPyShot.py v1.0\n")
	print("\tAutor: pr0zak\n")
	print("\tE-mail: pr0zak@punks.net\n")
	line()
	raw_input("Precione uma tecla para continuar...")
	menu()

def shot():
	usr = os.getlogin()
	line()
	print("...:::::::::: Saindo um ScreenShot para %s ::::::::::...") % usr
	os.system("import -w root shot.py")
	print("...:::::::::: Pronto, Ta na mao! ::::::::::...\n")
	line()
	raw_input("Precione uma tecla para continuar...")
	menu()

def menu():
	clear()
	line()
	print("Opcoes: (1).ScreenShot\n        (2).Info\n        (3).Sair\n")
	m = raw_input("Opcao: ")
	if(m == '1'):
		shot()
		menu()
	elif(m == '2'):
		info()
		menu()
	elif(m == '3'):
		sys.exit()
	else:
		print("Opcao Invalida! Tente Novamente...")
		os.system("sleep 2")
		menu()
menu()
