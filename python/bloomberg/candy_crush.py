def candy_crush(candy):
    stack = []
    for i in range(len(candy)):
        if stack and stack[-1][0] == candy[i]:
            stack[-1] = (candy[i], stack[-1][1] + 1)
        else:
            if stack and stack[-1][1] >= 3:
                stack.pop()
                if stack and stack[-1][0] == candy[i]:
                    stack[-1] = (candy[i], stack[-1][1] + 1)
                else:
                    stack.append((candy[i], 1))
            else:
                stack.append((candy[i], 1))

    if stack and stack[-1][1] >= 3:
        stack.pop()

    return ''.join([element*count for element, count in stack])


if __name__ == '__main__':
    inputs = ["aaaabbbc", "aabbccddeeedcba", "aaabbbacd", "aaaabbbc", "aabbbacd", "aabbbaacd", "dddabbbbaccccaax"]
    for elem in inputs:
        ans = candy_crush(elem)
        print(ans)