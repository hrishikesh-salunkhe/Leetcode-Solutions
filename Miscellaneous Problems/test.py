# QUESTION: Given an integer divide it into a group of k or less digits and find sum of those digits

input = 11111111
input = str(input)

final = ""
temp = ""

for i in range(len(input)):
    if(i != 0 and i%3 == 0):
        print("Inside if")
        sum = 0
        for j in range(0, 3):
            sum += int(temp[j])
        final += str(sum)
        temp = input[i]
    else:
        print("Inside else")
        temp += input[i]

sum = 0
for k in range(len(temp)):
    sum += int(temp[k])

final += str(sum)

print(final)
