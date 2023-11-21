import random

def non_repeating_number_array(start, end, count):
    if end - start + 1 < count:
        raise ValueError("Cannot generate unique array with the given count in the specified range.")

    numbers = random.sample(range(start, end + 1), count)
    return numbers

# Example usage:
start_range = 0
end_range = 99
count_of_numbers = 100

generated_array = non_repeating_number_array(start_range, end_range, count_of_numbers)
print(generated_array)
