# QUESTION: Given an input string and width of document, break the raw input into different lines for the following conditions:
# 1. encountered ".", "!" or "?"
# 2. when you run out of width space
# NOTE: New sentence starts on new line and a sentence start is indented by two spaces

input = "Hi! This is the article you have to format properly. Could you do that for me, please?"
width = 16
final = []

temp = ""
for i in range(width):
    temp += "*"
final.append(temp)

temp = "  "
spaceIndex = 0
i = 0
while(i < len(input)):
    print(i)
    if(input[i] == " "):
        spaceIndex = i

    if(input[i] in ["!", ".", "?"]):
        temp += input[i]
        final.append(temp)
        temp = " "
    else:
        if(len(temp) == width):
            if(i<len(input) and input[i] == " "):
                final.append(temp)
                temp = ""
            else:
                for k in range(0, i-spaceIndex):
                    temp = temp[:-1]
                i = spaceIndex
                final.append(temp)
                temp = ""
        else:
            temp += input[i]
    i += 1

if(len(temp) > 0 and temp != " "):
    final.append(temp)

temp = ""
for i in range(width):
    temp += "*"
final.append(temp)

for i in range(len(final)):
    final[i] = final[i].ljust(width)
    final[i] += "*"
    final[i] = "*" + final[i]
    print(final[i])