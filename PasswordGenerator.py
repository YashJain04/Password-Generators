# Author: Yash Jain
# Date: January 24, 2021
# Project: Password Generator With Python

# import python library
import random

# variables
lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
numbers = "1234567890";
specialCharacters = "!@#$%^&*()[]{}"

usersPassword = lowerCaseLetters + upperCaseLetters + numbers + specialCharacters

# ask for length
length = int(input("Enter the amount of characters you would like in your password: "))

# use random.sample to pick out the amount of characters the user wanted which was stored in the variable length from the variable usersPassword
# all of these characters will be stored in a list
# use the .join function to join all elements in a list into a string
# follow it by an empty string character "" as a seperator
# there will be no character (b/c it's an empty string character) in between the elements in the string that seperates it
usersPassword = "".join(random.sample(usersPassword, length))

# print final password
print(usersPassword)