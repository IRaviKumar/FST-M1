name=input('Enter your name : ')
age=input('Enter your age : ');
output='Hello {0}..you will turn 100 years of age in the year {1}';
output=output.format(name,(2022-int(age))+100)
print(output)