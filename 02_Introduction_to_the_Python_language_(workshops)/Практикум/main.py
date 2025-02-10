numbers = list(range(1, 101))

# квадраты чисел от 1 до 100, кратных 2
squares_numbers = list(filter(lambda a: a % 2 == 0, numbers))
squares_numbers = list(map(lambda a: a**2, squares_numbers))
print(squares_numbers)
print()

# кубы чисел из squares_numbers, кратных 3
cubed_numbers = list(filter(lambda a: a % 3 == 0, squares_numbers))
cubed_numbers = list(map(lambda a: a**3, cubed_numbers))
print(cubed_numbers)
print()

print(sum(cubed_numbers))  # сумма кубов чисел из squares_numbers, кратных 3
